package com.ty.hospitalapp.dao;

import java.util.List;
import com.ty.hospitalapp.dto.Observation;

public interface ObservationDao {
	// Save a new observation associated with a specific encounter
	// Parameters:
	// int eid - The encounter ID to associate the observation with
	// Observation observation - The observation to be saved
	// Returns:
	// The saved observation object
	public Observation saveObservation(int eid, Observation observation);

	// Retrieve an observation by its ID
	// Parameters:
	// int oid - The observation ID
	// Returns:
	// The observation object if found, else null
	public Observation getObservationById(int oid);

	// Update an existing observation by its ID
	// Parameters:
	// int oid - The observation ID
	// Observation observation - The new observation details to update
	// Returns:
	// The updated observation object if successful, else null
	public Observation updateObservationById(int oid, Observation observation);

	// Delete an observation by its ID
	// Parameters:
	// int oid - The observation ID
	// Returns:
	// True if deletion is successful, else false
	public boolean deleteObservationById(int oid);

	// Retrieve all observations by doctor's name
	// Parameters:
	// String dname - The doctor's name
	// Returns:
	// A list of observations associated with the specified doctor
	public List<Observation> getAllObservationByDoctorName(String dname);
}
