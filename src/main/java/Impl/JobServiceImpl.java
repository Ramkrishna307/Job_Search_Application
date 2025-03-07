package Impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import Job.Job;
import Job.JobRepository;
import Job.JobService;
@Service
public class JobServiceImpl implements JobService {
	//private List<Job> jobs=new ArrayList<>();
	
	JobRepository jobRepository;
	
	
	public JobServiceImpl(JobRepository jobRepository) {
		super();
		this.jobRepository = jobRepository;
	}

	@Override
	public List<Job> findAll() {
		// TODO Auto-generated method stub
		return jobRepository.findAll();
	}

	@Override
	public void createJob(Job job) {
		// TODO Auto-generated method stub
		jobRepository.save(job);
		
	}

	@Override
	public Job getJobById(Long id) {
		// TODO Auto-generated method stub
//		for(Job job:jobs) {
//			if(job.getId()==id) {
//				return job;
//			}
//		}
//		return null;		
	return	jobRepository.findById(id).orElse(null);

	}

	@Override
	public boolean deleteJobById(long id) {
		// TODO Auto-generated method stub
	/*	for(Job job:jobs)
		{
			if(job.getId()==id) jobs.remove(id);
			return true;
		}
		
		return false;
		
		*/
//		Iterator<Job> iterator=jobs.iterator();
//		
//		while(iterator.hasNext()) {
//			Job job=iterator.next();
//			if(job.getId().equals(id)) {
//				iterator.remove();
//				return true;
//			}
//		}
//		
//		
//		return false;
	try {	
	jobRepository.deleteById(id);
	return true;
	}catch(Exception e){
		return false;
	}
	}

	@Override
	public boolean updateJob(long id, Job job) {
		// TODO Auto-generated method stub
		
//		Iterator<Job> iterator =jobs.iterator();
//		while(iterator.hasNext()) {
//			Job jobTemp=iterator.next();
//			
//			if(jobTemp.getId()==id) {
//			   jobTemp.setTitle(job.getTitle());
//			   jobTemp.setLocation(job.getLocation());
//			   jobTemp.setDescription(job.getDescription());
//			   jobTemp.setMaxSalary(job.getMaxSalary());
//			   jobTemp.setMinSalary(job.getMinSalary());
//			   
//			   
//			   return true;
//			}
//		}
//		return false;
		
		Optional<Job> jobOptional=jobRepository.findById(id);
		
		if(jobOptional.isPresent()) {
			Job jobTemp=jobOptional.get();
			jobTemp.setTitle(job.getTitle());
			   jobTemp.setLocation(job.getLocation());
			   jobTemp.setDescription(job.getDescription());
			   jobTemp.setMaxSalary(job.getMaxSalary());
			   jobTemp.setMinSalary(job.getMinSalary());
			   
			   
			   jobRepository.save(jobTemp);	   
			   return true;
			
		}
		return false;
		
		
	}

}
