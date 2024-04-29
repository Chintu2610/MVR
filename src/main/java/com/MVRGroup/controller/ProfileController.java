package com.MVRGroup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.MVRGroup.Service.Userservice;
import com.MVRGroup.entity.User;


@Controller
public class ProfileController {
	@Autowired
	Userservice userservice;
	@RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String viewProfile() {    	
        return "profile";
    }
	@RequestMapping(value = "/ProfileDetails", method = RequestMethod.GET)
    public ResponseEntity<User> viewProfileDetails(@RequestParam String username) {    	
		User userDetails = userservice.GetUserDetails(username);
        return ResponseEntity.ok(userDetails);
    }
    @RequestMapping(value = "/EditProfile", method = RequestMethod.POST ,consumes="application/json")
    public String editProfile(@RequestBody User dto) {  	
    	userservice.UpdateUser(dto);
        return null;
    }
    

    @RequestMapping(value = "/ProfileDetailsbyUserid123", method = RequestMethod.GET)
    public ResponseEntity<User> viewProfileDetailsusinguserid(@RequestParam int userid) {    	
		User userDetails = userservice.GetUserDetailsusingUserid(userid);
        return ResponseEntity.ok(userDetails);
    }
    

    

    
}
