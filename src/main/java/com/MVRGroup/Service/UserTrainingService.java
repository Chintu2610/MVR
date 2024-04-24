

package com.MVRGroup.Service;

import com.MVRGroup.entity.UserTrainingEntity;
import com.MVRGroup.repository.UserTrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserTrainingService {

    private final UserTrainingRepository UserTrainingRepository;

    @Autowired
    public UserTrainingService(UserTrainingRepository UserTrainingRepository) {
        this.UserTrainingRepository = UserTrainingRepository;
    }

    public List<UserTrainingEntity> getAllUserTraining() {
        return UserTrainingRepository.findAll();
    }

    
	@Autowired
	private UserTrainingRepository repository;
	public UserTrainingEntity saveUserTraining(UserTrainingEntity entity)
	{
		  return repository.save(entity);
}
	

	public ResponseEntity<String> EditUserTraining(UserTrainingEntity service) {
	    Optional<UserTrainingEntity> existingServiceOptional = repository.findById(service.getUsertrainingid());
	    
	    if (existingServiceOptional.isPresent()) {
	    	UserTrainingEntity existingsss = existingServiceOptional.get();
	    	existingsss.setTrainingid(service.getTrainingid());
	    	existingsss.setTrainingscheduleid(service.getTrainingscheduleid());
	    	existingsss.setUserid(service.getUserid());


	        repository.save(existingsss);
	        
	        return ResponseEntity.ok("Raw material updated successfully");
	    } else {
	        // Raw material not found in the repository
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Raw material with ID " + service.getUsertrainingid() + " not found");
	    }
	}

	
	public String DeleteUserTraining(int usertrainingid) {
		// TODO Auto-generated method stub
		Optional<UserTrainingEntity> work = repository.findById(usertrainingid);
		if (work.isPresent()) {
		    
			repository.delete(work.get());
		    return "Work deleted successfully";
		}

		 return " ID " + usertrainingid + " not found";
		   
	}	
}