
package com.MVRGroup.Service;

import com.MVRGroup.entity.TrainingAssigneeEntity;
import com.MVRGroup.entity.User;
import com.MVRGroup.repository.TrainingAssigneeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TrainingAssigneeService {

    private final TrainingAssigneeRepository trainingassigneeRepository;

    @Autowired
    public TrainingAssigneeService(TrainingAssigneeRepository trainingassigneeRepository) {
        this.trainingassigneeRepository = trainingassigneeRepository;
    }

    public List<TrainingAssigneeEntity> getAllTrainingAssignee() {
        return trainingassigneeRepository.findAll();
    }

    
	@Autowired
	private TrainingAssigneeRepository repository;
	public TrainingAssigneeEntity saveTrainingAssignee(TrainingAssigneeEntity entity)
	{
		  return repository.save(entity);
}
	

	public ResponseEntity<String> EditTrainingAssignee(TrainingAssigneeEntity service) {
	    Optional<TrainingAssigneeEntity> existingServiceOptional = repository.findById(service.getTrainingassigneid());
	    
	    if (existingServiceOptional.isPresent()) {
	    	TrainingAssigneeEntity existingsss = existingServiceOptional.get();
	    	existingsss.setTrainingassignestatus(service.getTrainingassignestatus());
	    	existingsss.setTrainingid(service.getTrainingid());
	    	existingsss.setUserid(service.getUserid());

	        repository.save(existingsss);
	        
	        return ResponseEntity.ok("Raw material updated successfully");
	    } else {
	        // Raw material not found in the repository
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Raw material with ID " + service.getTrainingassigneid() + " not found");
	    }
	}

	
	public String DeleteTrainingAssignee(int trainingassigneid) {
		// TODO Auto-generated method stub
		Optional<TrainingAssigneeEntity> work = repository.findById(trainingassigneid);
		if (work.isPresent()) {
		    
			repository.delete(work.get());
		    return "Work deleted successfully";
		}

		 return " ID " + trainingassigneid + " not found";
		   
	}	
	
	

	 public TrainingAssigneeEntity getTrainingStatusById(Integer trainingassigneid) {
	        return repository.findById(trainingassigneid).orElse(null);
	    }
}