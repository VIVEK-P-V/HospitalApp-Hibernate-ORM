package com.ty.hospitalapp.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int aid; // Address ID
	private String street; // Street address
	private String country; // Country
	private String pin; // Postal code
	@OneToOne(mappedBy = "address")
	private Branch branch; // Associated branch

	// Getter for aid
	public int getAid() {
		return aid;
	}

	// Setter for aid
	public void setAid(int aid) {
		this.aid = aid;
	}

	// Getter for street
	public String getStreet() {
		return street;
	}

	// Setter for street
	public void setStreet(String street) {
		this.street = street;
	}

	// Getter for country
	public String getCountry() {
		return country;
	}

	// Setter for country
	public void setCountry(String country) {
		this.country = country;
	}

	// Getter for pin
	public String getPin() {
		return pin;
	}

	// Setter for pin
	public void setPin(String pin) {
		this.pin = pin;
	}

	// Getter for branch
	public Branch getBranch() {
		return branch;
	}

	// Setter for branch
	public void setBranch(Branch branch) {
		this.branch = branch;
	}
}
