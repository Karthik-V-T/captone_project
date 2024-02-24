package com.AdminSpringService.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admin")
public class AdminDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int adminid;
	private String email;
	private String adminname;
	private String password;

	public AdminDetails() {
	}

	public AdminDetails(int adminid, String email, String adminname, String password) {
		super();
		this.adminid = adminid;
		this.email = email;
		this.adminname = adminname;
		this.password = password;
	}

	public int getAdminid() {
		return adminid;
	}

	public void setAdminid(int adminid) {
		this.adminid = adminid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdminname() {
		return adminname;
	}

	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "AdminDetails [adminid=" + adminid + ", email=" + email + ", adminname=" + adminname + ", password="
				+ password + "]";
	}

}
