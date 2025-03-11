package com.jobSearchApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.jobSearchApplication", "Job", "CompImpl", "Company","Impl","com.jobSearchApplication.Review"}) 
@EnableJpaRepositories(basePackages = {"Job", "Company","com.jobSearchApplication.Review"})
@EntityScan(basePackages = {"Job", "Company", "com.jobSearchApplication.Review"})

public class JobSearchApplictionApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobSearchApplictionApplication.class, args);
	}

}
