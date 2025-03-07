package Job;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobController {
	private JobService jobService;
//	private Long nextId=1L;
	
	public JobController(JobService jobService) {
		
		this.jobService = jobService;
	}

	@GetMapping("/jobs")
    public ResponseEntity<List<Job>>findAll(){
		
    	return new ResponseEntity<>(jobService.findAll(),HttpStatus.OK);
    }
	
	@PostMapping("/jobs")
	public ResponseEntity<String> createJob(@RequestBody Job job) {
		
//		job.setId(nextId);
//		
		jobService.createJob(job);
//		++nextId;
		return new ResponseEntity<>("Job added successfully", HttpStatus.CREATED);
	}
	
	
	@GetMapping("/jobs/{id}")
	public ResponseEntity<Job> getJobById(@PathVariable Long id) {
		
		Job job=jobService.getJobById(id);
		if(job!=null)
		return new ResponseEntity(job,HttpStatus.OK);
		
		return new ResponseEntity(HttpStatus.NOT_FOUND);
		
		
	}
	
	
	@DeleteMapping("/jobs/{id}")
	public ResponseEntity<String> deleteJob(@PathVariable long id){
		
		boolean b=jobService.deleteJobById(id);
		if (b==true)
		   return new ResponseEntity<>("Job Deleted Successfully",HttpStatus.OK);
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	@PutMapping("/jobs/{id}")
	public ResponseEntity<String> updateJob(@PathVariable long id, @RequestBody Job job){
		boolean b=jobService.updateJob(id,job);
		
		if (b) {
			return new ResponseEntity("Job Updated succesfully",HttpStatus.OK);
		}
		
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}
	
	
}
