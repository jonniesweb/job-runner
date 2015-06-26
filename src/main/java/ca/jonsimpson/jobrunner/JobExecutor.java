package ca.jonsimpson.jobrunner;

import java.util.List;

public interface JobExecutor {
	
	public abstract void executeJob(Job job);
	
	/**
	 * Get the currently running jobs
	 * @return
	 */
	public abstract List<JobResult> getRunningJobs();
	
	public abstract List<JobResult> getFailedJobs();
	
	public abstract List<JobResult> getSuccessfulJobs();
	
}