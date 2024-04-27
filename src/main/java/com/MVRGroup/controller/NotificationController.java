package com.MVRGroup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.MVRGroup.Service.AdminWorkAssignService;
import com.MVRGroup.Service.SendMailService;
import com.MVRGroup.dto.WorkAssignDTO;

@Controller
public class NotificationController {
	@Autowired
	AdminWorkAssignService workservice;
	@Autowired
	SendMailService mailsrv;
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
	 @GetMapping("/getWithin2DaysDataUser")
	 @ResponseBody 
	    public List<WorkAssignDTO> getWithin2DaysDataUser(@RequestParam int userid) {
		 List<WorkAssignDTO> works= workservice.getWithin2DaysDataByuserid(userid);
	        // Replace this with your actual logic to fetch data for deliveries within 2 days
	        return works;
	    }
	 
	 	
	    // Controller method to fetch data for deliveries with a delivery date passed
	    @GetMapping("/getDeliveryDatePassedDatabyUserid")
	    @ResponseBody 
	    public List<WorkAssignDTO> getDeliveryDatePassedDatabyUserid(@RequestParam int userid) {
	    	 List<WorkAssignDTO> works= workservice.getDeliveryDatePassedDataByUserid(userid);
		        // Replace this with your actual logic to fetch data for deliveries within 2 days
		        return works;
	    }
	    
	    
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
		        return works;
	    }
	    
	    
	    @GetMapping("/getDeliveredProductsDatabyUserid")
	    @ResponseBody
	    public List<WorkAssignDTO> getDeliveredProductsDatabyUserid(@RequestParam int userid) {
	    	 List<WorkAssignDTO> works= workservice.getDeliveredProductsDatabyUserid(userid);
		        return works;
	    }
	    
	    
	    @PostMapping("/remindUserController")    
	    public String remindUserController(@RequestParam String email) {
	    	mailsrv.sendLinkEmail(email);
	    	 return "mail sended successfully";   
	    }

	    
}
