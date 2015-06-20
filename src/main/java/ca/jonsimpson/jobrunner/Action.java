package ca.jonsimpson.jobrunner;

import java.io.InputStream;

/**
 * Something to do
 */
public abstract class Action {
	
	protected InputStream inputStream;
	
	public abstract InputStream execute();

	public InputStream getInputStream() {
		return inputStream;
	}
	
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	
}
