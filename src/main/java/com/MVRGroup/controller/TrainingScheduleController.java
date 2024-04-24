
package com.MVRGroup.controller;

import com.MVRGroup.Service.TrainingScheduleService;
import com.MVRGroup.entity.TrainingScheduleEntity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class TrainingScheduleController {

	
	private final TrainingScheduleService TrainingScheduleService;

    @Autowired
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

	    TrainingScheduleEntity entityy = new TrainingScheduleEntity();
	    entityy.setStartDate(startDate);
	    entityy.setEndDate(endDate);
	    entityy.setTimings(timings);
	    entityy.setDescription(description);
	    entityy.setTrainingid(trainingid);

	    try {
	        TrainingScheduleService.saveTrainingSchedule(entityy);
	    } catch (Exception e) {
	        e.printStackTrace();
	        // Handle the exception appropriately
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
}