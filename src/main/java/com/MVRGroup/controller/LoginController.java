package com.MVRGroup.controller;


import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;



import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

	 
	 
	 
		/*
		 * @PostMapping("/loginflutter") public String validateUser1(HttpServletRequest
		 * request, Model model) { User user =
		 * userservice.ValidateUser(request.getParameter("email"),
		 * request.getParameter("password")); if (user != null) { if (user.getRoleid()
		 * == 2) { HttpSession session = request.getSession(); // Store user information
		 * in the session session.setAttribute("name", user.getName());
		 * session.setAttribute("email", user.getEmail()); model.addAttribute("message",
		 * user); return "admin_dashboard"; } else { return "redirect:/access-denied"; }
		 * } else { return "login"; } }
		 * 
		 */
	 
	 
	 
	 
	 @PostMapping("/loginflutter")
	    public ResponseEntity<String> validateUser1(HttpServletRequest request) {
	        String email = request.getParameter("email");
	        String password = request.getParameter("password");

	        if (email == null || password == null) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email or password cannot be null");
	        }

	        User user = userservice.ValidateUser(email, password);
	        if (user != null) {
	            if (user.getRoleid() == 2) {
	                HttpSession session = request.getSession();
	                session.setAttribute("name", user.getName());
	                session.setAttribute("email", user.getEmail());
	                session.setAttribute("userid", user.getUserid());

	                JSONObject jsonResponse = new JSONObject();
	                jsonResponse.put("status", "Authentication successful");
	                jsonResponse.put("userid", user.getUserid());

	                return ResponseEntity.ok().body(jsonResponse.toString());
	            } else {
	                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User does not have sufficient privileges");
	            }
	        } else {
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
	        }
	    }
	 
	 
	 
	 
}























