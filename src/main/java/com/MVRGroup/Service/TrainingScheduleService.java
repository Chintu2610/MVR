

package com.MVRGroup.Service;

import com.MVRGroup.entity.TrainingScheduleEntity;
import com.MVRGroup.entity.User;
import com.MVRGroup.repository.TrainingScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TrainingScheduleService {

    private final TrainingScheduleRepository TrainingScheduleRepository;

    @Autowired
    public TrainingScheduleService(TrainingScheduleRepository TrainingScheduleRepository) {
        this.TrainingScheduleRepository = TrainingScheduleRepository;
    }

    public List<TrainingScheduleEntity> getAllTrainingSchedule() {
        return TrainingScheduleRepository.findAll();
    }

    
	@Autowired
	private TrainingScheduleRepository repository;
	public TrainingScheduleEntity saveTrainingSchedule(TrainingScheduleEntity entity)
	{
		  return repository.save(entity);
}
	

	public ResponseEntity<String> EditTrainingSchedule(TrainingScheduleEntity service) {
	    Optional<TrainingScheduleEntity> existingServiceOptional = repository.findById(service.getTrainingscheduleid());
	    
	    if (existingServiceOptional.isPresent()) {
	    	TrainingScheduleEntity existingsss = existingServiceOptional.get();
	    	existingsss.setTrainingid(service.getTrainingid());
	    	existingsss.setStartDate(service.getStartDate());
	    	existingsss.setEndDate(service.getEndDate());
	    	existingsss.setTimings(service.getTimings());
	    	existingsss.setDescription(service.getDescription());

	        repository.save(existingsss);
	        
	        return ResponseEntity.ok("Raw material updated successfully");
	    } else {
	        // Raw material not found in the repository
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Raw material with ID " + service.getTrainingscheduleid() + " not found");
	    }
	}

	
	public String DeleteTrainingSchedule(int trainingscheduleid) {
		// TODO Auto-generated method stub
		Optional<TrainingScheduleEntity> work = repository.findById(trainingscheduleid);
		if (work.isPresent()) {
		    
			repository.delete(work.get());
		    return "Work deleted successfully";
		}

		 return " ID " + trainingscheduleid + " not found";
		   
	}	
	
	  public List<TrainingScheduleEntity> getAllTrainingScheduleWithTraininName() {
	        return TrainingScheduleRepository.findAllByTrainingID();
	    }

	
}