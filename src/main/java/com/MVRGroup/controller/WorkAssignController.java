package com.MVRGroup.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.MVRGroup.Service.AdminWorkAssignService;
import com.MVRGroup.dto.WorkAssignDTO;
import com.MVRGroup.entity.WorkAssign;
import com.MVRGroup.entity.Works;

@Controller
public class WorkAssignController {
	@Autowired
	AdminWorkAssignService adminservice;
	@RequestMapping(value = "/assign_work", method = RequestMethod.GET)
	public String viewAssignedWorkPage(ModelMap map)
	{
		return "assign_work";
	}
	 @PostMapping("/assign_work")
	    public String assignWorkUser(@RequestParam String email,@RequestParam String work)
		{
		 adminservice.AssignWork(email,work);
			return  "redirect:/assign_work";
		}
	 @GetMapping("/getAvailableWorks")
	 public ResponseEntity<List<Works>> getAvailableWorks() {
	        List<Works> availableWorks = adminservice.getAvailableWorks();
	        return ResponseEntity.ok(availableWorks);
	    }
	 @GetMapping("/getAllAssignedWorks")

	 public ResponseEntity<List<WorkAssignDTO>> getAllAssignedWorks() {
		    List<WorkAssign> assignedWorks = adminservice.getAllAssignedWorks();
		    List<WorkAssignDTO> assignedWorksDTO = assignedWorks.stream()
		    	    .map(workAssign -> {
		    	        WorkAssignDTO workAssignDTO = new WorkAssignDTO();
		    	        // Map common properties
		    	        workAssignDTO.setId(workAssign.getId());
		    	        workAssignDTO.setEmail(workAssign.getEmail());
		    	        workAssignDTO.setAssignedWork(workAssign.getAssignedWork());
		    	        // Map user ID from associated User entity
		    	        if (workAssign.getUser() != null) {
		    	            workAssignDTO.setUserId(workAssign.getUser().getUserid());
		    	        }
		    	        return workAssignDTO;
		    	    })
		    	    .collect(Collectors.toList());

		    return ResponseEntity.ok(assignedWorksDTO);
		}

	 @PostMapping("/addWork")
	    public ResponseEntity<String> addNewWork(@RequestParam String work)
		{
		 	adminservice.AddWork(work);
			return ResponseEntity.ok("Work assigned successfully");
		}
	 @PostMapping("/updateWork")
	    public String updateWork(@RequestParam String workname,@RequestParam int workid)
		{
         adminservice.EditWork(workname,workid);
		 return "redirect:/works";
		}
	 @PostMapping("/deleteWork")
	    public String deleteWork(@RequestParam int workid)
		{
      adminservice.DeleteWork(workid);
		 return "redirect:/works";
		}
	 @RequestMapping(value = "/works", method = RequestMethod.GET)
		public String viewdWorkPage(ModelMap map)
		{
			return "works";
		}
}
