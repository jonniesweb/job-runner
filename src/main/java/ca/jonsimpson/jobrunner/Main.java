package ca.jonsimpson.jobrunner;

public class Main {
	
	public Main() {
		
		Job job = new Job("Test Job" , new LocalShellAction("echo 123"));
		
		JobRunner jobRunner = new JobRunner();
		jobRunner.executeJob(job);
		
		
		
	}
	
	public static void main(String[] args) {
		new Main();
	}
	
}
