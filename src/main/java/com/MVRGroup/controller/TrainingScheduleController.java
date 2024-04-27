
package com.MVRGroup.controller;

import com.MVRGroup.Service.TrainingScheduleService;
import com.MVRGroup.dto.TrainingScheduleDTO;
import com.MVRGroup.dto.WorkAssignDTO;
import com.MVRGroup.entity.TrainingEntity;
import com.MVRGroup.entity.TrainingScheduleEntity;
import com.MVRGroup.repository.TrainingRepository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class TrainingScheduleController {

	@Autowired
	private final TrainingScheduleService TrainingScheduleService;
	@Autowired
	TrainingRepository trainingRepository;

    
    public TrainingScheduleController(TrainingScheduleService TrainingScheduleService) {
        this.TrainingScheduleService = TrainingScheduleService;
    }

    
    @GetMapping("/TrainingScheduleDetails")
    public ResponseEntity<List<TrainingScheduleEntity>> viewAllTrainingSchedule() {
        List<TrainingScheduleEntity> services = TrainingScheduleService.getAllTrainingSchedule();
        return new ResponseEntity<>(services, HttpStatus.OK);
    }

	@GetMapping("/trainingschedule")
	public String viewTrainingSchedulePage() {
	    return "trainingschedule";
	}
	
	@PostMapping("/TrainingScheduleadd")
	public String addTraining(@RequestParam("startDate") String startDate,
	                          @RequestParam("endDate") String endDate,
	                          @RequestParam("timings") String timings,
	                          @RequestParam("description") String description,
	                          @RequestParam("trainingid") Integer trainingid) {
//		String trName=trainingRepository.findTrainingNameByTrainingid(trainingid);
		TrainingEntity existingTrainingEntity = trainingRepository.findById(trainingid).orElse(null);

		if (existingTrainingEntity != null) {
		    // Set the existing TrainingEntity in the TrainingScheduleEntity
		    TrainingScheduleEntity entity1 = new TrainingScheduleEntity();
		    entity1.setStartDate(startDate);
		    entity1.setEndDate(endDate);
		    entity1.setTimings(timings);
		    entity1.setDescription(description);
		    entity1.setTrainingid(trainingid);
		    entity1.setTrainingEntity(existingTrainingEntity); // Set the existing TrainingEntity here

		    try {
		        TrainingScheduleService.saveTrainingSchedule(entity1);
		    } catch (Exception e) {
		        e.printStackTrace();
		        // Handle the exception appropriately
		    }
		} 

	    return "redirect:/trainingschedule";
	}

	@PostMapping("/TrainingScheduledelete")
    public String TrainingScheduledelete(@RequestParam int trainingscheduleid)
	{
		TrainingScheduleService.DeleteTrainingSchedule(trainingscheduleid);
	 return "redirect:/trainingschedule";
	}
    
    @GetMapping("/TrainingSchedule_edit")
	public String viewTrainingSchedule_editPage() {
	    return "trainingschedule_edit";
	}
   
    
    @PostMapping("/TrainingScheduleedit")
    public String TrainingScheduleedit(@RequestParam Integer trainingscheduleid,
    		@RequestParam String startDate,
            @RequestParam String endDate,
            @RequestParam String timings,
            @RequestParam String description,
            @RequestParam Integer trainingid) {
        try {
            
        	TrainingScheduleEntity Entityy = new TrainingScheduleEntity();
        	
        	Entityy.setTrainingscheduleid(trainingscheduleid);
        	Entityy.setStartDate(startDate);
        	Entityy.setEndDate(endDate);
        	Entityy.setTimings(timings);
        	Entityy.setDescription(description);
        	Entityy.setTrainingid(trainingid);

        	TrainingScheduleService.EditTrainingSchedule(Entityy);

            return "redirect:/trainingschedule";
        } catch (NumberFormatException e) {
            e.printStackTrace(); // Log the exception
            return "error-page"; // Redirect to an error page
        }
    }
    
    @GetMapping("/TrainingScheduleDetailsTrainingName")
    public ResponseEntity<List<TrainingScheduleDTO>> viewAllTrainingScheduleWithTraininName() {
        List<TrainingScheduleEntity> services = TrainingScheduleService.getAllTrainingScheduleWithTraininName();
        
        List<TrainingScheduleDTO> assignedWorksDTO = services.stream()
	    	    .map(service -> {
	    	    	TrainingScheduleDTO trainingScheduleDTO = new TrainingScheduleDTO();
	    	        // Map common properties
	    	    	trainingScheduleDTO.setDescription(service.getDescription());
	    	    	if (service.getTrainingEntity() != null) {
	    	    	trainingScheduleDTO.setTrainingname(service.getTrainingEntity().getTrainingname());
	    	    	}
	    	    	trainingScheduleDTO.setTrainingscheduleid(service.getTrainingscheduleid());
	    	    	trainingScheduleDTO.setEndDate(service.getEndDate());
	    	    	trainingScheduleDTO.setStartDate(service.getStartDate());
	    	    	trainingScheduleDTO.setTimings(service.getTimings());
	    	    	trainingScheduleDTO.setTrainingid(service.getTrainingid());
	    	        // Map user ID from associated User entity
	    	        
	    	        return trainingScheduleDTO;
	    	    })
	    	    .collect(Collectors.toList());

	   
        
        return new ResponseEntity<>(assignedWorksDTO, HttpStatus.OK);
    }
    
    
}