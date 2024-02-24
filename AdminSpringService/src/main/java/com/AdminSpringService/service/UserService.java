package com.AdminSpringService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AdminSpringService.model.UserDetails;
import com.AdminSpringService.repositry.UserRepositry;

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

	public boolean deleteUser(UserDetails user) {
		if (this.userRepositry.existsById(user.getUserid())) {
			this.userRepositry.delete(user);
			return true;
		} else {
			return false;
		}
	}

	public UserDetails getUserByEmail(String email) {
		System.out.println("getUserByEmail");
		return this.userRepositry.findByEmail(email);
	}

}
