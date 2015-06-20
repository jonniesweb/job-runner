package ca.jonsimpson.jobrunner;

import java.io.IOException;
import java.io.InputStream;

public class LocalShellAction extends Action {
	
	private String command;
	private Process process;

	public LocalShellAction(String command) {
		this.command = command;
	}

	public InputStream execute() {
		try {
			setProcess(Runtime.getRuntime().exec(command));
			setInputStream(inputStream);
			
			return getProcess().getInputStream();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		
		
	}
	
	public static void main(String[] args) {
		// execute test ls command
		LocalShellAction action = new LocalShellAction("ls -la");
		
		InputStream is = action.execute();
		try {
			// output results
			OutputAllOnClose.outputFromInput(is, System.out);
			System.out.println(action.getProcess().exitValue());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Process getProcess() {
		return process;
	}

	protected void setProcess(Process process) {
		this.process = process;
	}
	
	
}
