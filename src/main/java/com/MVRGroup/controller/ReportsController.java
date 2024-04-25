package com.MVRGroup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.MVRGroup.Service.ReportsService;
import com.MVRGroup.dto.WorkAssignDTO;
import com.MVRGroup.entity.User;

@Controller
public class ReportsController {
	@Autowired
	ReportsService reportsService;
	@RequestMapping(value = "/reports", method = RequestMethod.GET)
	public String viewNotificationPage(ModelMap map)
	{
		return "reports";
	}
	
	@RequestMapping(value = "/numberOfUsersRegisteredThisMonth", method = RequestMethod.GET)
	public  List<User> numberOfUsersRegisteredThisMonth(ModelMap map)
	{
		List<User> users=reportsService.getnumberOfUsersRegisteredThisMonth();
		return null;
	}
}
