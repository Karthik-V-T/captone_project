package com.AdminSpringService.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.AdminSpringService.model.AdminDetails;


public interface AdminRepositry extends JpaRepository<AdminDetails, Integer> {
	
	public AdminDetails findByEmailAndPassword(String email,String password);
	public boolean existsByEmail(String email);

	
}
