package Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import Job.Job;
import Job.JobService;
@Service
public class JobServiceImpl implements JobService {
	private List<Job> jobs=new ArrayList<>();
	@Override
	public List<Job> findAll() {
		// TODO Auto-generated method stub
		return jobs;
	}

	@Override
	public void createJob(Job job) {
		// TODO Auto-generated method stub
		jobs.add(job);
		
	}

	@Override
	public Job getJobById(Long id) {
		// TODO Auto-generated method stub
		for(Job job:jobs) {
			if(job.getId()==id) {
				return job;
			}
		}
		return null;
	}

}
