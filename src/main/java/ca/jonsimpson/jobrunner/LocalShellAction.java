package ca.jonsimpson.jobrunner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

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
			
			System.out.println("LocalShellAction.execute() - returning the inputstream");
			return getProcess().getInputStream();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		
		
	}
	
	public static void main(String[] args) {
		// execute test ls command
		LocalShellAction action = new LocalShellAction("./src/main/resources/poll.sh");
		
		Job job = new Job("123", action);
		
		JobExecutor executor = new DefaultJobExecutor();
		
		executor.executeJob(job);
		
		
//		InputStream is = action.execute();
//		System.out.println("started execution");
//		
//		try {
//			// output results
////			OutputAllOnClose.outputFromInput(is, System.out);
//			BufferedReader reader = new BufferedReader(new InputStreamReader(is));
//			
//			for (String s = reader.readLine(); s != null; s = reader.readLine()) {
//				System.out.println(s);
//			}
//			
//			System.out.println(action.getProcess().exitValue());
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}

	public Process getProcess() {
		return process;
	}

	protected void setProcess(Process process) {
		this.process = process;
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	/**
	 * Set the return code on completion.
	 */
	@Override
	public void postExecutionHook(JobResult jobResult) {
		if (process.isAlive() == false) {
			jobResult.setResultCode(getProcess().exitValue());
		} else
			throw new RuntimeException("Can't call postExecutionHook() when action is still running");
		
	}
	
	
}
