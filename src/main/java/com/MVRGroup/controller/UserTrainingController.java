
package com.MVRGroup.controller;

import com.MVRGroup.Service.UserTrainingService;
import com.MVRGroup.entity.UserTrainingEntity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class UserTrainingController {

	
	private final UserTrainingService UserTrainingService;

    @Autowired
    public UserTrainingController(UserTrainingService UserTrainingService) {
        this.UserTrainingService = UserTrainingService;
    }

    
    @GetMapping("/UserTrainingDetails")
    public ResponseEntity<List<UserTrainingEntity>> viewAllUserTraining() {
        List<UserTrainingEntity> services = UserTrainingService.getAllUserTraining();
        return new ResponseEntity<>(services, HttpStatus.OK);
    }

	@GetMapping("/usertrainingregister")
	public String viewUserTrainingPage() {
	    return "usertrainingregister";
	}
	
		
	@PostMapping("/UserTrainingadd")
	public String addTraining(@RequestParam("userid") Integer userid,
	                          @RequestParam("trainingscheduleid") Integer trainingscheduleid,
	                          @RequestParam("trainingid") Integer trainingid) {

	    UserTrainingEntity entityy = new UserTrainingEntity();
	    entityy.setUserid(userid);
	    entityy.setTrainingscheduleid(trainingscheduleid);
	    entityy.setTrainingid(trainingid);

	    try {
	        UserTrainingService.saveUserTraining(entityy);
	    } catch (Exception e) {
	        e.printStackTrace();
	        // Handle the exception appropriately
	    }

	    return "redirect:/usertraining";
	}

	
	
	@PostMapping("/UserTrainingdelete")
    public String UserTrainingdelete(@RequestParam int usertrainingid)
	{
		UserTrainingService.DeleteUserTraining(usertrainingid);
	 return "redirect:/usertraining";
	}
    
    @GetMapping("/usertraining_edit")
	public String viewUserTraining_editPage() {
	    return "usertraining_edit";
	}
   
    
    @PostMapping("/UserTrainingedit")
    public String UserTrainingedit(@RequestParam Integer usertrainingid,
    		@RequestParam Integer userid,
            @RequestParam Integer trainingid,
            @RequestParam Integer trainingscheduleid) {
        try {
            
        	UserTrainingEntity Entityy = new UserTrainingEntity();
        	
        	Entityy.setUsertrainingid(usertrainingid);
        	Entityy.setUserid(userid);
        	Entityy.setTrainingscheduleid(trainingscheduleid);
        	Entityy.setTrainingid(trainingid);

        	UserTrainingService.EditUserTraining(Entityy);

            return "redirect:/usertraining";
        } catch (NumberFormatException e) {
            e.printStackTrace(); // Log the exception
            return "error-page"; // Redirect to an error page
        }
    }
}