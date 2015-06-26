package ca.jonsimpson.jobrunner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Specify which beans to use for this application
 */
@Configuration
public class Config {
	
	@Bean
	public JobExecutor getJobExecutor() {
		return new DefaultJobExecutor();
	}
	
}
