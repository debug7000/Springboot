package com.learn.web.springwebdemo.service;

import org.springframework.stereotype.Component;

//spring bean
@Component
public class LoginService {
	
	public boolean validateUser(String userid, String Password){
		
		return "deepak".equals(userid) && "password".equalsIgnoreCase(Password);
	}

}
