package com.MVRGroup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.MVRGroup.Service.AdminWorkAssignService;
import com.MVRGroup.dto.WorkAssignDTO;
import com.MVRGroup.entity.WorkAssign;

@Controller
public class NotificationController {
	@Autowired
	AdminWorkAssignService workservice;
	@RequestMapping(value = "/notification", method = RequestMethod.GET)
	public String viewNotificationPage(ModelMap map)
	{
		return "notification";
	}
	
	 @GetMapping("/getWithin2DaysData")
	 @ResponseBody 
	    public List<WorkAssignDTO> getWithin2DaysData() {
		 List<WorkAssignDTO> works= workservice.getWithin2DaysData();
	        // Replace this with your actual logic to fetch data for deliveries within 2 days
	        return works;
	    }
	 	
	    // Controller method to fetch data for deliveries with a delivery date passed
	    @GetMapping("/getDeliveryDatePassedData")
	    @ResponseBody 
	    public List<WorkAssignDTO> getDeliveryDatePassedData() {
	    	 List<WorkAssignDTO> works= workservice.getDeliveryDatePassedData();
		        // Replace this with your actual logic to fetch data for deliveries within 2 days
		        return works;
	    }

	    // Controller method to fetch data for delivered products
	    @GetMapping("/getDeliveredProductsData")
	    @ResponseBody
	    public List<WorkAssignDTO> getDeliveredProductsData() {
	    	 List<WorkAssignDTO> works= workservice.getDeliveredProductsData();
		        // Replace this with your actual logic to fetch data for deliveries within 2 days
		        return works;
	    }
}
