package com.AdminSpringService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.AdminSpringService.model.AdminDetails;
import com.AdminSpringService.model.LoginAdmin;
import com.AdminSpringService.service.AdminService;

@RestController
@CrossOrigin(origins={"http://localhost:4200","http://localhost:62566"})
public class AdminController {

	public AdminController() {
	}

	@Autowired
	private AdminService adminService;

	@RequestMapping(method = RequestMethod.POST, value = "/")
	public ResponseEntity<?> addAdmin(@RequestBody AdminDetails admin) {
		System.out.println("post/add admin");

		return new ResponseEntity<>(this.adminService.saveAdmin(admin), HttpStatus.CREATED);

	}


	@PostMapping("/adminLogin")
	public ResponseEntity<AdminDetails> adminLogin(@RequestBody LoginAdmin adminLogin) {
		System.out.println(adminLogin);

		return new ResponseEntity<AdminDetails>(adminService.adminLogin(adminLogin.getEmail(),adminLogin.getPassword()), HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/")
	public ResponseEntity<AdminDetails> updateAdmin(@RequestBody AdminDetails admin) {
		System.out.println("put/update Admin");

		return new ResponseEntity<AdminDetails>(adminService.updateAdmin(admin), HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/")
	public boolean deleteAdmin(@RequestBody AdminDetails admin) {
		System.out.println("Delete admin");

		return adminService.deleteAdmin(admin);
	}
}
