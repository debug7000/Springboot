package com.learn.web.springwebdemo.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.learn.web.springwebdemo.model.User;
import com.learn.web.springwebdemo.security.repository.UserRepository;
@Service
public class UserServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(userName);
		
		return new CustomeUserDetails(user.getUsername(), user.getPassword(), true, true, true, true, user.getAuthorities());
	}

}
