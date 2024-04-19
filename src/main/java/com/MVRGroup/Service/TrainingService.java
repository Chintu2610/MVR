

package com.MVRGroup.Service;

import com.MVRGroup.entity.TrainingEntity;
import com.MVRGroup.repository.TrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TrainingService {

    private final TrainingRepository trainingRepository;

    @Autowired
    public TrainingService(TrainingRepository trainingRepository) {
        this.trainingRepository = trainingRepository;
    }

    public List<TrainingEntity> getAllTraining() {
        return trainingRepository.findAll();
    }

    
	@Autowired
	private TrainingRepository repository;
	public TrainingEntity saveTraining(TrainingEntity entity)
	{
		  return repository.save(entity);
}
	

	public ResponseEntity<String> EditTraining(TrainingEntity service) {
	    Optional<TrainingEntity> existingServiceOptional = repository.findById(service.getTrainingid());
	    
	    if (existingServiceOptional.isPresent()) {
	    	TrainingEntity existingsss = existingServiceOptional.get();

	    	existingsss.setTrainingname(service.getTrainingname());


	        repository.save(existingsss);
	        
	        return ResponseEntity.ok("  updated successfully");
	    } else {
	        // Raw material not found in the repository
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Raw material with ID " + service.getTrainingid() + " not found");
	    }
	}

	
	public String DeleteTraining(int trainingid) {
		Optional<TrainingEntity> work = repository.findById(trainingid);
		if (work.isPresent()) {
		    
			repository.delete(work.get());
		    return "Work deleted successfully";
		}

		 return " ID " + trainingid + " not found";
		   
	}	
	
	
	
}