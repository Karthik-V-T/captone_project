package com.AdminSpringService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.AdminSpringService.model.UserDetails;
import com.AdminSpringService.service.UserService;

@RestController
@CrossOrigin(origins ="http://localhost:4200")
@RequestMapping(value = "/user")
public class UserController {

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

	@RequestMapping(method = RequestMethod.PUT, value = "/updateUser")
	public ResponseEntity<UserDetails> updateUser(@RequestBody UserDetails user) {
		System.out.println("put/update user");

		return new ResponseEntity<UserDetails>(userService.saveUser(user), HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/deleteUser")
	public boolean deleteUser(@RequestBody UserDetails user) {
		System.out.println("delete user");

		return this.userService.deleteUser(user);
	}

	@GetMapping("/getUserByEmail/{email}")
	private ResponseEntity<?> getUserByEmail(@PathVariable String email) {
		System.out.println(email);
		return new ResponseEntity<UserDetails>(this.userService.getUserByEmail(email), HttpStatus.CREATED);
	}

}
