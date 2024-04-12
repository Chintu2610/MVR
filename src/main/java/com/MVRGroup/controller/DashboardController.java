package com.MVRGroup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DashboardController {
	
	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public String viewLoginPage(ModelMap map)
	{
		return "dashboard";
	}
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String viewUsersPage(ModelMap map)
	{
		return "users";
	}
	
	@RequestMapping(value = "/user_email", method = RequestMethod.GET)
	public String viewuser_emailPage(ModelMap map)
	{
		return "user_email";
	}
	
}
