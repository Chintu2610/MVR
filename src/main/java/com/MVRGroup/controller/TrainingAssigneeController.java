
package com.MVRGroup.controller;

import com.MVRGroup.Service.TrainingAssigneeService;
import com.MVRGroup.entity.SubSubServiceEntity;
import com.MVRGroup.entity.TrainingAssigneeEntity;
import com.MVRGroup.entity.TrainingEntity;
import com.MVRGroup.entity.User;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class TrainingAssigneeController {

	
	private final TrainingAssigneeService trainingassigneeService;

    @Autowired
    public TrainingAssigneeController(TrainingAssigneeService trainingassigneeService) {
        this.trainingassigneeService = trainingassigneeService;
    }

    
    @GetMapping("/TrainingAssigneeDetails")
    public ResponseEntity<List<TrainingAssigneeEntity>> viewAllTrainingAssignee() {
        List<TrainingAssigneeEntity> services = trainingassigneeService.getAllTrainingAssignee();
        return new ResponseEntity<>(services, HttpStatus.OK);
    }

	@GetMapping("/trainingassignee")
	public String viewTrainingAssigneePage() {
	    return "trainingassignee";
	}
	
	
	/*
	 * @PostMapping("/trainingassigneeadd") public String
	 * addTraining(@RequestParam("userid") User userid,
	 * 
	 * @RequestParam("trainingassignestatus") String trainingassignestatus,
	 * 
	 * @RequestParam("trainingid") TrainingEntity trainingid) {
	 * TrainingAssigneeEntity entityy = new TrainingAssigneeEntity();
	 * entityy.setUserid(userid);
	 * entityy.setTrainingassignestatus(trainingassignestatus);
	 * entityy.setTrainingid(trainingid);
	 * 
	 * trainingassigneeService.saveTrainingAssignee(entityy);
	 * 
	 * return "redirect:/trainingassignee"; }
	 */

	
	
	
	@PostMapping("/trainingassigneeadd")
	public String addTraining(@RequestParam("userid") Integer userid,
	                          @RequestParam("trainingassignestatus") String trainingassignestatus,
	                          @RequestParam("trainingid") Integer trainingid) {

	    TrainingAssigneeEntity entityy = new TrainingAssigneeEntity();
	    entityy.setUserid(userid);
	    entityy.setTrainingassignestatus(trainingassignestatus);
	    entityy.setTrainingid(trainingid);

	    try {
	        trainingassigneeService.saveTrainingAssignee(entityy);
	    } catch (Exception e) {
	        e.printStackTrace();
	        // Handle the exception appropriately
	    }

	    return "redirect:/trainingassignee";
	}

	
	
	@PostMapping("/trainingassigneedelete")
    public String TrainingAssigneedelete(@RequestParam int trainingassigneid)
	{
		trainingassigneeService.DeleteTrainingAssignee(trainingassigneid);
	 return "redirect:/service";
	}
    
    @GetMapping("/trainingassignee_edit")
	public String viewTrainingAssignee_editPage() {
	    return "trainingassignee_edit";
	}
   
    
    @PostMapping("/trainingassigneeedit")
    public String TrainingAssigneeedit(@RequestParam Integer userid,
                                   @RequestParam Integer trainingassigneid,
                                   @RequestParam String trainingassignestatus,
                                   @RequestParam Integer trainingid) {
        try {
            
        	TrainingAssigneeEntity Entityy = new TrainingAssigneeEntity();
        	Entityy.setUserid(userid);
        	Entityy.setTrainingassigneid(trainingassigneid);
        	Entityy.setTrainingassignestatus(trainingassignestatus);
        	Entityy.setTrainingid(trainingid);

        	trainingassigneeService.EditTrainingAssignee(Entityy);

            return "redirect:/trainingassignee";
        } catch (NumberFormatException e) {
            e.printStackTrace(); // Log the exception
            return "error-page"; // Redirect to an error page
        }
    }
	
    
	 @PostMapping("/completedStatus")
    public String approveUser(@RequestParam("trainingassigneid") Integer trainingassigneid) {
        try {
        	TrainingAssigneeEntity user = trainingassigneeService.getTrainingStatusById(trainingassigneid);	            
            user.setTrainingassignestatus("completed");	            
            trainingassigneeService.saveTrainingAssignee(user);	
            return "redirect:/user";
           // return "User approved successfully";
        } catch (Exception e) {
            e.printStackTrace();
            // Handle the exception appropriately
            return "Error approving user";
        }
    }
    }
	
	
