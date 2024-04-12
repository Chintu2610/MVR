package com.MVRGroup.Service;

import com.MVRGroup.entity.ServiceEntity;
import com.MVRGroup.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceService {

    private final ServiceRepository serviceRepository;

    @Autowired
    public ServiceService(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    public List<ServiceEntity> getAllServices() {
        return serviceRepository.findAll();
    }

    
	@Autowired
	private ServiceRepository repository;
	public ServiceEntity saveService(ServiceEntity entity)
	{
		  return repository.save(entity);
}
	
	public ResponseEntity<String> EditService(ServiceEntity service) {
	    Optional<ServiceEntity> existingServiceOptional = repository.findById(service.getServiceId());
	    
	    if (existingServiceOptional.isPresent()) {
	    	ServiceEntity existingsss = existingServiceOptional.get();
	    	existingsss.setServiceName(service.getServiceName());
	    	existingsss.setImageUrl(service.getImageUrl());
	    	existingsss.setUrl(service.getUrl());

	        repository.save(existingsss);
	        
	        return ResponseEntity.ok("Raw material updated successfully");
	    } else {
	        // Raw material not found in the repository
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Raw material with ID " + service.getServiceId() + " not found");
	    }
	}

	

	
	public String DeleteService(int serviceId) {
		// TODO Auto-generated method stub
		Optional<ServiceEntity> work = repository.findById(serviceId);
		if (work.isPresent()) {
		    
			repository.delete(work.get());
		    return "Work deleted successfully";
		}

		 return "Work with ID " + serviceId + " not found";
		   
	}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
