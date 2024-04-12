package com.MVRGroup.controller;



import com.MVRGroup.Service.SubServiceService;
import com.MVRGroup.entity.SubServiceEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SubServiceController {

	
	private final SubServiceService subserviceService;

    @Autowired
    public SubServiceController(SubServiceService subserviceService) {
        this.subserviceService = subserviceService;
    }

    
    @GetMapping("/subserviceDetails")
    public ResponseEntity<List<SubServiceEntity>> viewAllSubServices() {
        List<SubServiceEntity> subservices = subserviceService.getAllSubServices();
        return new ResponseEntity<>(subservices, HttpStatus.OK);
    }

	@GetMapping("/subservice")
	public String viewServicePage() {
	    return "subservice";
	}
}