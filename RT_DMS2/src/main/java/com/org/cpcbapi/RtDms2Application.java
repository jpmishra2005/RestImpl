package main.java.com.org.cpcbapi;


import java.util.concurrent.Executor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@SpringBootApplication
@EnableScheduling
@EnableAsync
public class RtDms2Application extends AsyncConfigurerSupport  {

	public static void main(String[] args) {
		System.out.println("RtDms2Application initialized");
		SpringApplication.run(RtDms2Application.class, args);
	}
	 @Override
	    public Executor getAsyncExecutor() {
	        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
	        executor.setCorePoolSize(2);
	        executor.setMaxPoolSize(2);
	        executor.setQueueCapacity(500);
	        executor.setThreadNamePrefix("RTDAS-");
	        executor.initialize();
	        return executor;
	    }
}
