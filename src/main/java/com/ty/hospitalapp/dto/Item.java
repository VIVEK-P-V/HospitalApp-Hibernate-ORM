package com.ty.hospitalapp.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; // Item ID
	private String itemName; // Item name
	private double cost; // Item cost
	private int quantity; // Item quantity

	@ManyToOne
	@JoinColumn
	private MedOrder medOrder; // Associated medical order

	// Getter for id
	public int getId() {
		return id;
	}

	// Setter for id
	public void setId(int id) {
		this.id = id;
	}

	// Getter for itemName
	public String getItemName() {
		return itemName;
	}

	// Setter for itemName
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	// Getter for cost
	public double getCost() {
		return cost;
	}

	// Setter for cost
	public void setCost(double cost) {
		this.cost = cost;
	}

	// Getter for quantity
	public int getQuantity() {
		return quantity;
	}

	// Setter for quantity
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	// Getter for medOrder
	public MedOrder getMedOrder() {
		return medOrder;
	}

	// Setter for medOrder
	public void setMedOrder(MedOrder medOrder) {
		this.medOrder = medOrder;
	}
}
