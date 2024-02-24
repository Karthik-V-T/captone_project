package com.UserSpringService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.UserSpringService.model.UserDetails;
import com.UserSpringService.repositry.UserRepositry;

@Service
public class UserService {

	@Autowired
	private UserRepositry userRepositry;

	public UserDetails saveUser(UserDetails user) {
		return this.userRepositry.save(user);
	}

	public UserDetails loginUser(String email, String password) {
		return userRepositry.findByEmailAndPassword(email, password);
	}

	public Object getUserByEmail(String email) {
		
		return userRepositry.findByEmail(email);
	}


	
	
	

}
