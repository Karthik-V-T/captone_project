package com.UserSpringService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.UserSpringService.model.LoginUser;
import com.UserSpringService.model.ResponseMessage;
import com.UserSpringService.model.UserDetails;
import com.UserSpringService.service.UserService;

@RestController
@CrossOrigin(origins ="http://localhost:4200")
public class UserController {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	public UserController() {
		System.out.println("user controller called");

	}

	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.POST, value = "/addUser")
	public ResponseEntity<UserDetails> addUser(@RequestBody UserDetails user) {
		System.out.println("post user");

		return new ResponseEntity<UserDetails>(userService.saveUser(user), HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/userLogin")
	public ResponseEntity<?> userLogin(@RequestBody LoginUser loginUser) {
		System.out.println(loginUser);
		try {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUser.getEmail(), loginUser.getPassword()));
		}
		catch (BadCredentialsException e) {
			return ResponseEntity.badRequest().body(new ResponseMessage("login failed"));
		}
		return ResponseEntity.ok().body(this.userService.getUserByEmail(loginUser.getEmail()));

//		return new ResponseEntity<UserDetails>(userDatabase.loginUser(email, password), HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/updateUser")
	public ResponseEntity<UserDetails> updateUser(@RequestBody UserDetails user) {
		System.out.println("post user");

		return new ResponseEntity<UserDetails>(userService.saveUser(user), HttpStatus.CREATED);
	}

}
