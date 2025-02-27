package com.jobSearchApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.jobSearchApplication", "Job","Impl"}) 
public class JobSearchApplictionApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobSearchApplictionApplication.class, args);
	}

}
