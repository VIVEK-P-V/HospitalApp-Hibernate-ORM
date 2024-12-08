package com.ty.hospitalapp.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pid; // Person ID
	private String name; // Person's name
	private int age; // Person's age
	private String gender; // Person's gender
	private String dob; // Person's date of birth
	private String email; // Person's email

	@OneToOne(mappedBy = "person")
	private Encounter encounter; // Associated encounter

	// Getter for pid
	public int getPid() {
		return pid;
	}

	// Setter for pid
	public void setPid(int pid) {
		this.pid = pid;
	}

	// Getter for name
	public String getName() {
		return name;
	}

	// Setter for name
	public void setName(String name) {
		this.name = name;
	}

	// Getter for age
	public int getAge() {
		return age;
	}

	// Setter for age
	public void setAge(int age) {
		this.age = age;
	}

	// Getter for gender
	public String getGender() {
		return gender;
	}

	// Setter for gender
	public void setGender(String gender) {
		this.gender = gender;
	}

	// Getter for dob
	public String getDob() {
		return dob;
	}

	// Setter for dob
	public void setDob(String dob) {
		this.dob = dob;
	}

	// Getter for email
	public String getEmail() {
		return email;
	}

	// Setter for email
	public void setEmail(String email) {
		this.email = email;
	}

	// Getter for encounter
	public Encounter getEncounter() {
		return encounter;
	}

	// Setter for encounter
	public void setEncounter(Encounter encounter) {
		this.encounter = encounter;
	}
}
