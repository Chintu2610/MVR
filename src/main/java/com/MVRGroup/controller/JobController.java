
package com.MVRGroup.controller;

import com.MVRGroup.Service.JobService;
import com.MVRGroup.entity.JobEntity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class JobController {

	
	private final JobService jobService;

    @Autowired
    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    
    @GetMapping("/JobDetails")
    public ResponseEntity<List<JobEntity>> viewAllJobs() {
        List<JobEntity> services = jobService.getAllJob();
        return new ResponseEntity<>(services, HttpStatus.OK);
    }

	@GetMapping("/job")
	public String viewJobPage() {
	    return "job";
	}
	


	 // STORE DATA
    @RequestMapping(value = "/jobadd", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<String> addJob(@RequestBody JobEntity rawmaterial) {
        jobService.saveJob(rawmaterial);
        return ResponseEntity.ok(" added successfully");// Redirect to GET mapping to show the form again or any appropriate view
    }
	
	
	@PostMapping("/jobdelete")
    public String Jobdelete(@RequestParam int jobid)
	{
		jobService.DeleteJob(jobid);
	 return "redirect:/job";
	}
    
    @GetMapping("/jobedit")
	public String viewJob_editPage() {
	    return "jobedit";
	}
   
    
    @PostMapping("/jobedit")
    public String Jobedit(@RequestParam String job,
            @RequestParam Integer userid,
            @RequestParam Integer qty,
            @RequestParam String startDate,
            @RequestParam String endDate,
            @RequestParam Integer jobid) {
        try {
            
        	JobEntity Entityy = new JobEntity();

        	Entityy.setJob(job);
        	Entityy.setUserid(userid);
     	   	Entityy.setQty(qty);
     	   	Entityy.setStartDate(startDate);
     	   	Entityy.setEndDate(endDate);
        	Entityy.setJobid(jobid);

        	jobService.EditJob(Entityy);

            return "redirect:/job";
        } catch (NumberFormatException e) {
            e.printStackTrace(); // Log the exception
            return "error-page"; // Redirect to an error page
        }
    }
    
    @GetMapping("/UserJobs")
    public ResponseEntity<List<JobEntity>> viewUserJobs(@RequestParam Integer userid) {
        List<JobEntity> userJobs = jobService.getJobsByUserId(userid);
        return new ResponseEntity<>(userJobs, HttpStatus.OK);
    }

    
    
}