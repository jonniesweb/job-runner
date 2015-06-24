package ca.jonsimpson.jobrunner;


public class Job {
	
	private String id;
	private String name;
	private Action action;
	
	
	public Job(String name, Action action) {
		this.name = name;
		this.action = action;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Action getAction() {
		return action;
	}


	public void setAction(Action action) {
		this.action = action;
	}
	
}
