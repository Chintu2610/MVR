
package com.MVRGroup.Service;

import com.MVRGroup.entity.ServiceEntity;
import com.MVRGroup.entity.SubServiceEntity;
import com.MVRGroup.repository.ServiceRepository;
import com.MVRGroup.repository.SubServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class SubServiceService {

    private final SubServiceRepository subserviceRepository;

    @Autowired
    public SubServiceService(SubServiceRepository subserviceRepository) {
        this.subserviceRepository = subserviceRepository;
    }

    public List<SubServiceEntity> getAllSubServices() {
        return subserviceRepository.findAll();
    }
    
    
    public List<SubServiceEntity> getSubServicesByServiceId(Integer serviceId) {
        return subserviceRepository.findByServiceId(serviceId);
    }
    
    
    @Autowired
	private SubServiceRepository repository;
	public SubServiceEntity saveSubService(SubServiceEntity entity)
	{
		  return repository.save(entity);
}
	
	
	
	
	public String DeleteSubService(int subserviceId) {
		// TODO Auto-generated method stub
		Optional<SubServiceEntity> work = repository.findById(subserviceId);
		if (work.isPresent()) {
		    
			repository.delete(work.get());
		    return "Work deleted successfully";
		}

		 return "Work with ID " + subserviceId + " not found";
		   
	}	
	
	
	public ResponseEntity<String> EditSubService(SubServiceEntity service) {
	    Optional<SubServiceEntity> existingServiceOptional = repository.findById(service.getSubserviceId());
	    
	    if (existingServiceOptional.isPresent()) {
	    	SubServiceEntity existingsss = existingServiceOptional.get();
	    	existingsss.setSubserviceName(service.getSubserviceName());
	    	existingsss.setImageUrl(service.getImageUrl());
	    	existingsss.setServiceId(service.getServiceId());

	        repository.save(existingsss);
	        
	        return ResponseEntity.ok("Raw material updated successfully");
	    } else {
	        // Raw material not found in the repository
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Raw material with ID " + service.getSubserviceId() + " not found");
	    }
	}
	
	
	
	
	
	
	
	
	
}