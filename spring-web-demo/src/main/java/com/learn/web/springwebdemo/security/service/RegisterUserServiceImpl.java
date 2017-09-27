package com.learn.web.springwebdemo.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.learn.web.springwebdemo.model.User;
import com.learn.web.springwebdemo.security.repository.UserRepository;

@Service
public class RegisterUserServiceImpl implements RegisterUserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public void save(String username, String password) {
		
		User user = new User();
		
		user.setUsername(username);
		user.setPassword(bCryptPasswordEncoder.encode(password));
		
		userRepository.save(user);
	}

}
