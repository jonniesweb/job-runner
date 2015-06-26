package ca.jonsimpson.jobrunner.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ca.jonsimpson.jobrunner.Job;
import ca.jonsimpson.jobrunner.JobExecutor;
import ca.jonsimpson.jobrunner.JobResult;
import ca.jonsimpson.jobrunner.LocalShellAction;

@RestController
@RequestMapping("/job")
public class JobController {
	
	private Set<Job> jobs = new HashSet<Job>();
	
	@Autowired
	private JobExecutor jobExecutor;
	
	public JobController() {
		jobs.add(new Job("123", new LocalShellAction("ls")));
		jobs.add(new Job("124", new LocalShellAction("ls -l")));
		jobs.add(new Job("125", new LocalShellAction("ls -la")));
		
	}
	
	public Job addJob(String name, String action) {
		return null;
		
	}
	
	@RequestMapping(method=GET)
	public Collection<Job> getJobs(
			@RequestParam(value = "name", required = false) String name) {
		
		if (name == null) {
			return jobs;
		}
		List<Job> results = new ArrayList<Job>();
		
		for (Job job : jobs) {
			if (job.getName().contains(name)) {
				results.add(job);
			}
		}
		
		return results;
	}
	
	@RequestMapping("/success")
	public Collection<JobResult> getSuccessfulJobs() {
		return getJobExecutor().getSuccessfulJobs();
	}
	
	public JobExecutor getJobExecutor() {
		System.out.println("getting job executor: " + jobExecutor);
		return jobExecutor;
	}
	
	public void setJobExecutor(JobExecutor jobExecutor) {
		this.jobExecutor = jobExecutor;
	}
}
