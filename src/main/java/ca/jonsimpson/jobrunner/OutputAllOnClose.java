package ca.jonsimpson.jobrunner;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class OutputAllOnClose implements OutputListener {
	
	public void update(InputStream input) {
		
	}

	public void update(OutputStream output) {
		// TODO Auto-generated method stub
		
	}

	
	public static void main(String[] args) {
		
		ByteArrayInputStream inputStream = new ByteArrayInputStream("123".getBytes());
		
		try {
			outputFromInput(inputStream, new OutputStream() {
				
				@Override
				public void write(int b) throws IOException {
					System.out.println((char) b);
				}
			});
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		byte[] b = new byte[] { 49 }; 
		System.out.println(new String(b, StandardCharsets.UTF_8));
	}
	
	
	public static void outputFromInput(InputStream is, OutputStream os) throws IOException {
		byte[] buffer = new byte[1024];
		
		int i = 0;
		
		while ((i = is.read(buffer)) != -1) {
			os.write(buffer, 0, i);
		}
	}
	
}
