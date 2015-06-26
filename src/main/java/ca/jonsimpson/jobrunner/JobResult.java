package ca.jonsimpson.jobrunner;

import java.util.Date;

/**
 * A {@link Job} which is running or has run. The output of the job is recorded
 * here.
 */
public class JobResult {

	private static final int RESULT_SUCCESS = 0;
	
	private final Job job;
	private String output;
	private int resultCode;
	private Date startDate;
	private Date endDate;
	
	/**
	 * @param job
	 */
	public JobResult(Job job) {
		this.job = job;
		startDate = new Date();
	}

	public String getOutput() {
		return output;
	}

	public void setOutput(String output) {
		this.output = output;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Job getJob() {
		return job;
	}

	public int getResultCode() {
		return resultCode;
	}

	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}
	
	public boolean isSuccess() {
		return resultCode == RESULT_SUCCESS;
	}
	
}
