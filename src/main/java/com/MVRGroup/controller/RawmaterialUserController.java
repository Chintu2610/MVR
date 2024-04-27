
package com.MVRGroup.controller;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.MVRGroup.Service.AssignedRawmaterialService;
import com.MVRGroup.entity.AssignedRawMaterial;
import com.MVRGroup.entity.JobEntity;


@Controller
public class RawmaterialUserController {

    @Autowired
    AssignedRawmaterialService assignedrawmaterialService;

  
    //Retrieve DATA
    @RequestMapping(value = "/assignedrawmaterialDetails", method = RequestMethod.GET)
	public ResponseEntity<List<AssignedRawMaterial>> viewRMPage()
	{
		 try {
	            List<AssignedRawMaterial> raw = assignedrawmaterialService.getAllRawMaterialsUser();
	            return ResponseEntity.ok(raw);
	        } catch (Exception e) {
	            // Log the exception for debugging purposes
	            e.printStackTrace();
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	        }	 
		 
	}
		 
		 @RequestMapping(value = "/assignedrawmaterialDetailsUserid", method = RequestMethod.GET)
			public ResponseEntity<List<AssignedRawMaterial>> viewRMPage(@RequestParam Integer userid)
			{
				 try {
			            List<AssignedRawMaterial> raw = assignedrawmaterialService.getAllRawMaterialsUserid(userid);
			            return ResponseEntity.ok(raw);
			        } catch (Exception e) {
			            // Log the exception for debugging purposes
			            e.printStackTrace();
			            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			        }	 
				 
				 
		 
	}
    
    
    
    
  

    
    
    
    
    
    
}