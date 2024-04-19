package com.MVRGroup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.MVRGroup.Service.Userservice;
import com.MVRGroup.entity.User;
@Controller
public class UserController {
	@Autowired
	Userservice userservice;
	@RequestMapping(value = "/userDetails", method = RequestMethod.GET)
	public ResponseEntity<List<User>> viewUsersPage()
	{
		 try {
	            List<User> users = userservice.getAllUsers();
	            return ResponseEntity.ok(users);
	        } catch (Exception e) {
	            // Log the exception for debugging purposes
	            e.printStackTrace();
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	        }	 
	}
	


	@PostMapping("/useradd")
	public String addUser(@RequestParam("name") String name,
	                          @RequestParam("address") String address,
	                          @RequestParam("email") String email,
	                          @RequestParam("password") String password,
	                          @RequestParam("phone_num") String phone_num,
	                          @RequestParam("paid250") String paid250,
	                         // @RequestParam("approvestatus") String approvestatus,
	                          @RequestParam("roleid") Integer roleid) {

	    String approvestatus; // Declare approvestatus here

	    if ("success".equals(paid250)) {
	        approvestatus = "approved";
	    } else {
	        approvestatus = "not approved";
	    }

		User entityy = new User();
	    entityy.setName(name);
	    entityy.setAddress(address);
	    entityy.setEmail(email);
	    entityy.setPassword(password);
	    entityy.setPhoneNum(phone_num);
	    entityy.setRoleid(roleid);
	    entityy.setPaid250(paid250);
	    entityy.setApprovestatus(approvestatus);
	 

	    try {
	    	userservice.saveUser(entityy);
	    } catch (Exception e) {
	        e.printStackTrace();
	        // Handle the exception appropriately
	    }

	    return "redirect:/user";
	}
	
	
	
	
	
	 @PostMapping("/approveUser")
	    public String approveUser(@RequestParam("userId") Integer userId) {
	        try {
	            User user = userservice.getUserById(userId);	            
	            user.setApprovestatus("approved");	
	            user.setPaid250("success");	
	            userservice.saveUser(user);	
	            return "redirect:/user";
	           // return "User approved successfully";
	        } catch (Exception e) {
	            e.printStackTrace();
	            // Handle the exception appropriately
	            return "Error approving user";
	        }
	    }
	 
	
	 
	 @PostMapping("/userdelete")
	    public String Userdelete(@RequestParam int userid)
		{
		 userservice.DeleteUser(userid);
		 return "redirect:/users";
		}
	 
	 @GetMapping("/useredit")
		public String viewTraining_editPage() {
		    return "useredit";
		}
	   
	    
	    @PostMapping("/useredit")
	    public String Useredit(@RequestParam("name") String name,
                @RequestParam("address") String address,
                @RequestParam("email") String email,
                @RequestParam("password") String password,
                @RequestParam("phone_num") String phone_num,
                @RequestParam("paid250") String paid250,
                @RequestParam("approvestatus") String approvestatus,
                @RequestParam("roleid") Integer roleid) {
	        try {
	            
	        	User entityy = new User();
	    	    entityy.setName(name);
	    	    entityy.setAddress(address);
	    	    entityy.setEmail(email);
	    	    entityy.setPassword(password);
	    	    entityy.setPhoneNum(phone_num);
	    	    entityy.setRoleid(roleid);
	    	    entityy.setPaid250(paid250);
	    	    entityy.setApprovestatus(approvestatus);

	    	    userservice.EditUser(entityy);

	            return "redirect:/training";
	        } catch (NumberFormatException e) {
	            e.printStackTrace(); // Log the exception
	            return "error-page"; // Redirect to an error page
	        }
	    }
		
	 
}
