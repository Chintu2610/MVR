

package com.MVRGroup.controller;

import com.MVRGroup.Service.TrainingService;
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
public class TrainingController {

	
	private final TrainingService trainingService;

    @Autowired
    public TrainingController(TrainingService trainingService) {
        this.trainingService = trainingService;
    }

    
    @GetMapping("/TrainingDetails")
    public ResponseEntity<List<TrainingEntity>> viewAllTraining() {
        List<TrainingEntity> services = trainingService.getAllTraining();
        return new ResponseEntity<>(services, HttpStatus.OK);
    }

	@GetMapping("/training")
	public String viewTrainingPage() {
	    return "training";
	}
	
	
	
	@PostMapping("/trainingadd")
	public String addTraining(@RequestParam("trainingname") String trainingname) {

	    TrainingEntity entityy = new TrainingEntity();
	    entityy.setTrainingname(trainingname);
	  

	    try {
	    	trainingService.saveTraining(entityy);
	    } catch (Exception e) {
	        e.printStackTrace();
	        // Handle the exception appropriately
	    }

	    return "redirect:/training";
	}

	
	
	@PostMapping("/trainingdelete")
    public String Trainingdelete(@RequestParam int trainingid)
	{
		trainingService.DeleteTraining(trainingid);
	 return "redirect:/training";
	}
    
    @GetMapping("/trainingedit")
	public String viewTraining_editPage() {
	    return "trainingedit";
	}
   
    
    @PostMapping("/trainingedit")
    public String Trainingedit(@RequestParam String trainingname,
                                   @RequestParam Integer trainingid) {
        try {
            
        	TrainingEntity Entityy = new TrainingEntity();

        	Entityy.setTrainingname(trainingname);
        	Entityy.setTrainingid(trainingid);

        	trainingService.EditTraining(Entityy);

            return "redirect:/training";
        } catch (NumberFormatException e) {
            e.printStackTrace(); // Log the exception
            return "error-page"; // Redirect to an error page
        }
    }
	
	
	
}