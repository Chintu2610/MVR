package com.MVRGroup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.MVRGroup.Service.Userservice;
import com.MVRGroup.entity.User;

@Controller
public class RegisterController {
	@Autowired
	Userservice userservice;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
    public String viewRegistrationPage(ModelMap map) {
        return "registration";
    }
	
	
    @PostMapping("/register")
	public ResponseEntity<User> registerUser(@RequestBody User userDto)
	{
		return   new ResponseEntity<User>(userservice.UserRegistration(userDto),HttpStatus.CREATED);
	}
    
}
