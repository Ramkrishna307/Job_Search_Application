package com.jobSearchApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.jobSearchApplication", "Job", "CompImpl", "Company","Impl"}) 
@EnableJpaRepositories(basePackages = {"Job", "Company"})
@EntityScan(basePackages = {"Job", "Company"})

public class JobSearchApplictionApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobSearchApplictionApplication.class, args);
	}

}
