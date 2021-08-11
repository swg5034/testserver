package com.test.testserver;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class MyJob implements Job {
	

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println("Quart 실행: " +
				new Date(System.currentTimeMillis()));
		
	}


}
