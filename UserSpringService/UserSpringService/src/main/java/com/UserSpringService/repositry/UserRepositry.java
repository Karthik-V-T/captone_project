package com.UserSpringService.repositry;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.UserSpringService.model.UserDetails;

public interface UserRepositry extends JpaRepository<UserDetails, Integer> {

	public UserDetails findByEmailAndPassword(String email, String password);

	public Optional<UserDetails> findByEmail(String username);
}
