package com.ty.hospitalapp.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int uid; // User ID
	private String name; // User's name
	private String email; // User's email
	private long phno; // User's phone number
	private String pass; // User's password
	private String role; // User's role

	// Getter for uid
	public int getUid() {
		return uid;
	}

	// Setter for uid
	public void setUid(int uid) {
		this.uid = uid;
	}

	// Getter for name
	public String getName() {
		return name;
	}

	// Setter for name
	public void setName(String name) {
		this.name = name;
	}

	// Getter for email
	public String getEmail() {
		return email;
	}

	// Setter for email
	public void setEmail(String email) {
		this.email = email;
	}

	// Getter for phno
	public long getPhno() {
		return phno;
	}

	// Setter for phno
	public void setPhno(long phno) {
		this.phno = phno;
	}

	// Getter for pass
	public String getPass() {
		return pass;
	}

	// Setter for pass
	public void setPass(String pass) {
		this.pass = pass;
	}

	// Getter for role
	public String getRole() {
		return role;
	}

	// Setter for role
	public void setRole(String role) {
		this.role = role;
	}
}
