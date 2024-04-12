package com.MVRGroup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
	
	
	

	 
	
}
