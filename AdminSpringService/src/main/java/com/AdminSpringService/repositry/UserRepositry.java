package com.AdminSpringService.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.AdminSpringService.model.UserDetails;


public interface UserRepositry extends JpaRepository<UserDetails, Integer>{

	public UserDetails findByEmailAndPassword(String email,String password);

	public UserDetails findByEmail(String email);
	
}
