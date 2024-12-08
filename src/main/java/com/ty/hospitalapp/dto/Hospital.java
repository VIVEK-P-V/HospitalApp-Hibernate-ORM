package com.ty.hospitalapp.dto;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Hospital {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int hid; // Hospital ID
	private String name; // Hospital name
	private String website; // Hospital website

	@OneToMany(mappedBy = "hospitals")
	private List<Branch> branchs; // List of branches

	// Getter for hid
	public int getHid() {
		return hid;
	}

	// Setter for hid
	public void setHid(int hid) {
		this.hid = hid;
	}

	// Getter for name
	public String getName() {
		return name;
	}

	// Setter for name
	public void setName(String name) {
		this.name = name;
	}

	// Getter for website
	public String getWebsite() {
		return website;
	}

	// Setter for website
	public void setWebsite(String website) {
		this.website = website;
	}

	// Getter for branchs
	public List<Branch> getBranchs() {
		return branchs;
	}

	// Setter for branchs
	public void setBranchs(List<Branch> branchs) {
		this.branchs = branchs;
	}
}
