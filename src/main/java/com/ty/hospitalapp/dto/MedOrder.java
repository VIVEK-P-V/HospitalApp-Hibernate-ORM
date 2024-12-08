package com.ty.hospitalapp.dto;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class MedOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int mid; // Medical Order ID
	private String dname; // Doctor's name
	private String orderDate; // Order date

	@OneToMany(mappedBy = "medOrder")
	private List<Item> items; // List of items in the medical order

	@ManyToOne
	@JoinColumn
	private Encounter encounter; // Associated encounter

	// Getter for mid
	public int getMid() {
		return mid;
	}

	// Setter for mid
	public void setMid(int mid) {
		this.mid = mid;
	}

	// Getter for dname
	public String getDname() {
		return dname;
	}

	// Setter for dname
	public void setDname(String dname) {
		this.dname = dname;
	}

	// Getter for orderDate
	public String getOrderDate() {
		return orderDate;
	}

	// Setter for orderDate
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	// Getter for items
	public List<Item> getItems() {
		return items;
	}

	// Setter for items
	public void setItems(List<Item> items) {
		this.items = items;
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
