package com.MVRGroup.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.MVRGroup.Service.ReportsService;
import com.MVRGroup.dto.WorkAssignDTO;
import com.MVRGroup.entity.TrainingAssigneeEntity;
import com.MVRGroup.entity.User;
import com.MVRGroup.entity.WorkAssign;
import com.MVRGroup.repository.TrainingAssigneeRepository;
import com.MVRGroup.repository.WorkAssignRepo;

@Controller
public class ReportsController {
	@Autowired
	ReportsService reportsService;
	@Autowired
	WorkAssignRepo workAssignRepo;
	@Autowired
	TrainingAssigneeRepository trainingrepo;
	@RequestMapping(value = "/reports", method = RequestMethod.GET)
	public String viewNotificationPage(ModelMap map)
	{
		return "reports";
	}
	
	@RequestMapping(value = "/numberOfUsersRegisteredThisMonth", method = RequestMethod.GET)
	@ResponseBody
	public  List<User> numberOfUsersRegisteredThisMonth(ModelMap map)
	{
		return reportsService.getnumberOfUsersRegisteredThisMonth();
		 
	}
	@RequestMapping(value = "/numberOfWorksAssignedThisMonth", method = RequestMethod.GET)
	@ResponseBody
	public  List<WorkAssignDTO> numberOfWorksAssignedThisMonth(ModelMap map)
	{
		 List<WorkAssign> assignedWorks = workAssignRepo.numberOfWorksAssignedThisMonth();
		    List<WorkAssignDTO> assignedWorksDTO = assignedWorks.stream()
		    	    .map(workAssign -> {
		    	        WorkAssignDTO workAssignDTO = new WorkAssignDTO();
		    	        // Map common properties
		    	        workAssignDTO.setId(workAssign.getWorkid());
		    	        workAssignDTO.setEmail(workAssign.getEmail());
		    	        workAssignDTO.setAssignedWork(workAssign.getAssignedWork());
		    	        workAssignDTO.setStatus(workAssign.getStatus());
		    	        workAssignDTO.setDeadline(workAssign.getDeadLine());
		    	        workAssignDTO.setWorkAssignDate(workAssign.getWorkAssignDate());
		    	        // Map user ID from associated User entity
		    	        if (workAssign.getUser() != null) {
		    	            workAssignDTO.setUserId(workAssign.getUser().getUserid());
		    	        }
		    	        return workAssignDTO;
		    	    })
		    	    .collect(Collectors.toList());

//		    return ResponseEntity.ok(assignedWorksDTO);
		return assignedWorksDTO;	
		
	}
	@RequestMapping(value = "/numberOfTrainingCompletedThisMonth", method = RequestMethod.GET)
	@ResponseBody
	public  List<TrainingAssigneeEntity> numberOfTrainingCompletedThisMonth(ModelMap map)
	{
		return trainingrepo.numberOfTrainingCompletedThisMonth();
	}
}
