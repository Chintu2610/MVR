package com.MVRGroup.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.MVRGroup.entity.SubSubServiceEntity;
import com.MVRGroup.repository.SubSubServiceRepository;

@Service 
public class SubSubServiceService {
	
	 private final SubSubServiceRepository subsubserviceRepository;

	    @Autowired
	    public SubSubServiceService(SubSubServiceRepository subsubserviceRepository) {
	        this.subsubserviceRepository = subsubserviceRepository;
	    }
	

    public List<SubSubServiceEntity> getAllSubSubServices() {
        return subsubserviceRepository.findAll();
    }
    
	
	public List<SubSubServiceEntity> getSubSubServicesBySubServiceId(Integer subserviceId) {
        return subsubserviceRepository.findBySubserviceId(subserviceId);
    }
	
	
	 

	@Autowired
	private  SubSubServiceRepository repository;
	public  SubSubServiceEntity saveSubSubService(SubSubServiceEntity entity)
	{
		  
		return repository.save(entity);
		
}
	
	
	
	public ResponseEntity<String> EditSubSubService(SubSubServiceEntity service) {
	    Optional<SubSubServiceEntity> existingServiceOptional = repository.findById(service.getSubsubserviceId());
	    
	    if (existingServiceOptional.isPresent()) {
	    	SubSubServiceEntity existingsss = existingServiceOptional.get();
	    	existingsss.setSubserviceId(service.getSubserviceId());
	    	existingsss.setTitle(service.getTitle());
	    	existingsss.setUrl(service.getUrl());

	        repository.save(existingsss);
	        
	        return ResponseEntity.ok("Raw material updated successfully");
	    } else {
	        // Raw material not found in the repository
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Raw material with ID " + service.getSubsubserviceId() + " not found");
	    }
	}

	

	
	public String DeleteSubSubService(int subsubserviceId) {
		// TODO Auto-generated method stub
		Optional<SubSubServiceEntity> work = repository.findById(subsubserviceId);
		if (work.isPresent()) {
		    
			repository.delete(work.get());
		    return "Work deleted successfully";
		}

		 return "Work with ID " + subsubserviceId + " not found";
		   
	}	
	
	
	
}
