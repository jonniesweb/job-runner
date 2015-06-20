package ca.jonsimpson.jobrunner;

import java.io.OutputStream;

public class Job {
	
	String name;
	Action action;
	
	
	public Job(String name, Action action) {
		this.name = name;
		this.action = action;
	}


	public OutputStream getOutputStream() {
		return action.getInputStream();
	}
	
}
