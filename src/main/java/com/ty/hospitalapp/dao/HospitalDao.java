package com.ty.hospitalapp.dao;

import java.util.List;
import com.ty.hospitalapp.dto.*;

public interface HospitalDao {
	// Save a new hospital
	// Parameters:
	// Hospital hospital - The hospital to be saved
	// Returns:
	// The saved hospital object
	public Hospital saveHospital(Hospital hospital);

	// Retrieve a hospital by its ID
	// Parameters:
	// int hid - The hospital ID
	// Returns:
	// The hospital object if found, else null
	public Hospital getHospitalById(int hid);

	// Update an existing hospital by its ID
	// Parameters:
	// int hid - The hospital ID
	// Hospital hospital - The new hospital details to update
	// Returns:
	// The updated hospital object if successful, else null
	public Hospital updateHospitalById(int hid, Hospital hospital);

	// Delete a hospital by its ID
	// Parameters:
	// int hid - The hospital ID
	// Returns:
	// True if deletion is successful, else false
	public boolean deleteHospital(int hid);

	// Retrieve all hospitals
	// Returns:
	// A list of all hospital objects
	public List<Hospital> getAllHospital();
}
