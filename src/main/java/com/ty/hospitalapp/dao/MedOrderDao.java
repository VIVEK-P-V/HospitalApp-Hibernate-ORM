package com.ty.hospitalapp.dao;

import java.util.List;
import com.ty.hospitalapp.dto.MedOrder;

public interface MedOrderDao {
	// Save a new medical order associated with a specific encounter
	// Parameters:
	// int eid - The encounter ID to associate the medical order with
	// MedOrder medOrder - The medical order to be saved
	// Returns:
	// The saved medical order object
	public MedOrder saveMedOrder(int eid, MedOrder medOrder);

	// Retrieve a medical order by its ID
	// Parameters:
	// int mid - The medical order ID
	// Returns:
	// The medical order object if found, else null
	public MedOrder getMedOrderById(int mid);

	// Update an existing medical order by its ID
	// Parameters:
	// int mid - The medical order ID
	// MedOrder medOrder - The new medical order details to update
	// Returns:
	// The updated medical order object if successful, else null
	public MedOrder updateMedOrderById(int mid, MedOrder medOrder);

	// Delete a medical order by its ID
	// Parameters:
	// int mid - The medical order ID
	// Returns:
	// True if deletion is successful, else false
	public boolean deleteMedOrderById(int mid);

	// Retrieve all medical orders
	// Returns:
	// A list of all medical order objects
	public List<MedOrder> getAllMedOrder();

	// Retrieve medical orders by doctor's name
	// Parameters:
	// String dname - The doctor's name
	// Returns:
	// A list of medical orders associated with the specified doctor
	public List<MedOrder> getMedOrderByDoctorName(String dname);
}
