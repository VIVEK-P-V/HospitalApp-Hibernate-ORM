package com.ty.hospitalapp.dao;

import java.util.List;
import com.ty.hospitalapp.dto.Encounter;

public interface EncounterDao {
	// Save a new encounter associated with a specific branch
	// Parameters:
	// int bid - The branch ID to associate the encounter with
	// Encounter encounter - The encounter to be saved
	// Returns:
	// The saved encounter object
	public Encounter saveEncounter(int bid, Encounter encounter);

	// Retrieve an encounter by its ID
	// Parameters:
	// int eid - The encounter ID
	// Returns:
	// The encounter object if found, else null
	public Encounter getEncounterById(int eid);

	// Update an existing encounter by its ID
	// Parameters:
	// int eid - The encounter ID
	// Encounter encounter - The new encounter details to update
	// Returns:
	// The updated encounter object if successful, else null
	public Encounter updateEncounterById(int eid, Encounter encounter);

	// Delete an encounter by its ID
	// Parameters:
	// int eid - The encounter ID
	// Returns:
	// True if deletion is successful, else false
	public boolean deleteEncounterById(int eid);

	// Retrieve all encounters
	// Returns:
	// A list of all encounter objects
	public List<Encounter> getAllEncounter();
}
