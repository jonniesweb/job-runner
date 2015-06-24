package ca.jonsimpson.jobrunner;

import java.io.InputStream;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Something to do
 */
public abstract class Action {
	
	@JsonIgnore
	protected InputStream inputStream;
	
	public abstract InputStream execute();

	public InputStream getInputStream() {
		return inputStream;
	}
	
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	
}
