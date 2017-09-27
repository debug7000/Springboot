package com.learn.web.springwebdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.learn.web.springwebdemo.service.LoginService;

@Controller

public class LoginController {
	
	@Autowired
	LoginService login;

	@RequestMapping(value = "/", method = RequestMethod.GET)

	public String showLogin(ModelMap model) {
		
		model.put("name", getLoggedInUserName(model));

		return "welcome";
	}
	
	
	private String getLoggedInUserName(ModelMap model) {
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();

		if (principal instanceof UserDetails)
			return ((UserDetails) principal).getUsername();

		return principal.toString();
	}

	/*@RequestMapping(value = "/login", method = RequestMethod.POST)

	public String showLoginedin(ModelMap model, @RequestParam String name,@RequestParam String password) {
		
		if(!login.validateUser(name, password)){
			model.put("errorMessage", "Invalid Credentials!!");
		return "login";
		}else {
			model.put("name", name);
			model.put("password", password);
			return "welcome";
		}
	}*/

}
