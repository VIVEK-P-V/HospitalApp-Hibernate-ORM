package com.ty.hospitalapp.dto;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Branch {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bid; // Branch ID
	private String name; // Branch name
	private Long phno; // Phone number
	private String email; // Email address

	@ManyToOne
	@JoinColumn
	private Hospital hospitals; // Associated hospital

	@OneToOne
	@JoinColumn
	private Address address; // Associated address

	@OneToMany(mappedBy = "branchs")
	private List<Encounter> encounters; // List of encounters

	// Getter for bid
	public int getBid() {
		return bid;
	}

	// Setter for bid
	public void setBid(int bid) {
		this.bid = bid;
	}

	// Getter for name
	public String getName() {
		return name;
	}

	// Setter for name
	public void setName(String name) {
		this.name = name;
	}

	// Getter for phno
	public Long getPhno() {
		return phno;
	}

	// Setter for phno
	public void setPhno(Long phno) {
		this.phno = phno;
	}

	// Getter for email
	public String getEmail() {
		return email;
	}

	// Setter for email
	public void setEmail(String email) {
		this.email = email;
	}

	// Getter for hospitals
	public Hospital getHospitals() {
		return hospitals;
	}

	// Setter for hospitals
	public void setHospitals(Hospital hospitals) {
		this.hospitals = hospitals;
	}

	// Getter for address
	public Address getAddress() {
		return address;
	}

	// Setter for address
	public void setAddress(Address address) {
		this.address = address;
	}

	// Getter for encounters
	public List<Encounter> getEncounters() {
		return encounters;
	}

	// Setter for encounters
	public void setEncounters(List<Encounter> encounters) {
		this.encounters = encounters;
	}
}
