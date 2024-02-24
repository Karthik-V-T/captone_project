package com.UserSpringService.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.UserSpringService.model.UserDetails;
import com.UserSpringService.repositry.UserRepositry;

@Service
public class LoginUserService  implements UserDetailsService{
	
	@Autowired
	private UserRepositry userRepositry;
	
	@Override
	public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String email)
			throws UsernameNotFoundException {
		Optional<UserDetails> optuser = this.userRepositry.findByEmail(email);

		return optuser.map(acc ->{

			User user = new User(acc.getEmail(), 
					acc.getPassword(),
					new ArrayList<>());
			return user;
		})
		.orElseThrow(()-> new UsernameNotFoundException("User does not exist with username "+email));
	}

}
