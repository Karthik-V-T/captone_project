package com.AdminSpringService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AdminSpringService.model.AdminDetails;
import com.AdminSpringService.repositry.AdminRepositry;

@Service
public class AdminService {
	@Autowired
	private AdminRepositry adminRepository;

	public AdminDetails saveAdmin(AdminDetails admin) {
		if (this.adminRepository.existsByEmail(admin.getEmail())) {

		}
		return this.adminRepository.save(admin);
	}

	public AdminDetails updateAdmin(AdminDetails admin) {
		return this.adminRepository.save(admin);
	}

	public AdminDetails adminLogin(String email, String password) {
		return this.adminRepository.findByEmailAndPassword(email, password);
	}

	public boolean deleteAdmin(AdminDetails admin) {
		if (this.adminRepository.existsById(admin.getAdminid())) {
			this.adminRepository.delete(admin);
			return true;
		} else {
			return false;
		}
	}
}
