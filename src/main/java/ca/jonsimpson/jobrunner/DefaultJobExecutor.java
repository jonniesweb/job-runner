package ca.jonsimpson.jobrunner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.util.List;

/**
 * Executes {@link Job}s and creates a {@link JobResult} with it.
 */
public class DefaultJobExecutor implements JobExecutor {
	
	private List<JobResult> runningJobs;
	private List<JobResult> failedJobs;
	private List<JobResult> successfulJobs;
	
	/* (non-Javadoc)
	 * @see ca.jonsimpson.jobrunner.JobExecutor#executeJob(ca.jonsimpson.jobrunner.Job)
	 */
	@Override
	public void executeJob(Job job) {
		
		
		// start a thread to execute the job and handle its lifecycle
		Runnable r = new Runnable() {
			
			@Override
			public void run() {
				
				// create a new JobResult for this job and add it to the running jobs
				JobResult jobResult = new JobResult(job);
				runningJobs.add(jobResult);
				
				// execute the job and get its output stream
				InputStream stdOutErr = job.getAction().execute(); 
				try {
					BufferedReader reader = new BufferedReader(new InputStreamReader(stdOutErr));
					
					// read output of job until finished, outputting to the JobResult
					for (String s = reader.readLine(); s != null; s = reader.readLine()) {
						jobResult.setOutput(jobResult.getOutput() + s);
					}
					
					// execute the post execution hook
					job.getAction().postExecutionHook(jobResult);
					
					// add the JobResult to the success list
					successfulJobs.add(jobResult);
					
				} catch (IOException e) {
					// TODO: log
					e.printStackTrace();
					
					// TODO: better error handling when it isn't the Action's fault
					jobResult.setResultCode(1);
					
					// add the JobResult to the failed list
					failedJobs.add(jobResult);
				} finally {
					// remove the jobResult on completion or error
					runningJobs.remove(jobResult);
				}
				
			}
		};
		
		// start the new runnable
		new Thread(r).start();
	}
	
	/* (non-Javadoc)
	 * @see ca.jonsimpson.jobrunner.JobExecutor#getRunningJobs()
	 */
	@Override
	public List<JobResult> getRunningJobs() {
		return runningJobs;
	}
	
	/* (non-Javadoc)
	 * @see ca.jonsimpson.jobrunner.JobExecutor#getFailedJobs()
	 */
	@Override
	public List<JobResult> getFailedJobs() {
		return failedJobs;
	}
	
	/* (non-Javadoc)
	 * @see ca.jonsimpson.jobrunner.JobExecutor#getSuccessfulJobs()
	 */
	@Override
	public List<JobResult> getSuccessfulJobs() {
		return successfulJobs;
	}
}
