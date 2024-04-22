package com.MVRGroup.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
	    public String assignWorkUser(@RequestParam String email,@RequestParam String work,@RequestParam Map<String, String> rawMaterials)
		{
		 Map<String, Integer> rawMaterials1 = new HashMap<>();

		    // Iterate over the rawMaterials map to filter out raw materials with quantities greater than 0
		 for (Map.Entry<String, String> entry : rawMaterials.entrySet()) {
		        String key = entry.getKey(); // Raw material name
		        String valueString = entry.getValue(); // Quantity as String

		        // Parse the quantity string to an integer
		        

		        // Check if the key (raw material name) contains "_quantity" and the quantity is greater than 0
		        if (key.endsWith("_quantity")) {
		            try {
		                // Parse the quantity string to an integer
		                int quantity = Integer.parseInt(valueString);

		                // Check if the quantity is greater than 0
		                if (quantity > 0) {
		                    // Extract the raw material name by removing "_quantity" from the key
		                    String rawMaterialName = key.substring(0, key.lastIndexOf("_quantity"));

		                    // Add the raw material name and its quantity to the new map
		                    rawMaterials1.put(rawMaterialName, quantity);
		                }
		            } catch (NumberFormatException e) {
		                // Handle cases where the quantity cannot be parsed as an integer
		                // Log an error or take appropriate action
		            }
		        }
		    }
	        adminservice.AssignWork(email,work,rawMaterials1);
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
		    	        workAssignDTO.setId(workAssign.getWorkid());
		    	        workAssignDTO.setEmail(workAssign.getEmail());
		    	        workAssignDTO.setAssignedWork(workAssign.getAssignedWork());
		    	        workAssignDTO.setStatus(workAssign.getStatus());
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
