
package com.MVRGroup.Service;

import com.MVRGroup.entity.JobEntity;
import com.MVRGroup.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class JobService {

    private final JobRepository jobRepository;

    @Autowired
    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public List<JobEntity> getAllJob() {
        return jobRepository.findAll();
    }

    
	@Autowired
	private JobRepository repository;
	public JobEntity saveJob(JobEntity entity)
	{
		  return repository.save(entity);
}
	

	public ResponseEntity<String> EditJob(JobEntity service) {
	    Optional<JobEntity> existingServiceOptional = repository.findById(service.getJobid());
	    
	    if (existingServiceOptional.isPresent()) {
	    	JobEntity existingsss = existingServiceOptional.get();

	    	existingsss.setJob(service.getJob());
	    	existingsss.setQty(service.getQty());
	    	existingsss.setUserid(service.getUserid());
	    	existingsss.setStartDate(service.getStartDate());
	    	existingsss.setEndDate(service.getEndDate());


	        repository.save(existingsss);
	        
	        return ResponseEntity.ok("  updated successfully");
	    } else {
	        // Raw material not found in the repository
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(" with ID " + service.getJobid() + " not found");
	    }
	}

	
	public String DeleteJob(int Jobid) {
		Optional<JobEntity> work = repository.findById(Jobid);
		if (work.isPresent()) {
		    
			repository.delete(work.get());
		    return "Work deleted successfully";
		}

		 return " ID " + Jobid + " not found";
		   
	}	
	
	
}