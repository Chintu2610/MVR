package com.MVRGroup.controller;


import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;



import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import com.MVRGroup.Service.Userservice;
import com.MVRGroup.entity.User;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

 




@Controller
public class LoginController {
	@Autowired
	Userservice userservice;
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String viewLoginPage(ModelMap map)
	{
		return "login";
	}
	 @PostMapping("/login")
	    public String validateUser(HttpServletRequest request,Model model)
		{
			User user= userservice.ValidateUser(request.getParameter("email"), request.getParameter("password"));
			if(user!=null) {
				HttpSession session = request.getSession();
	            // Store user information in the session
	            session.setAttribute("name", user.getName());
	            session.setAttribute("email", user.getEmail());
	            model.addAttribute("message", user);
				return "admin_dashboard";

			}else
			{
				return "login";
			}
		}

	 @RequestMapping(value = "/logout", method = RequestMethod.GET)
	    public String viewLogoutPage(ModelMap map) {
	        return "logout";
	    }

	 
}























