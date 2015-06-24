package ca.jonsimpson.jobrunner;

import java.io.InputStream;
import java.util.List;

public class JobRunner {
	
	private List<Job> runningJobs;
	
	public void executeJob(Job job) {
		
		InputStream execute = job.getAction().execute();
		
		if (execute == null) {
			// TODO: job failed to execute
			return;
		}
		
		runningJobs.add(job);
		
	}
	
	
	
}
