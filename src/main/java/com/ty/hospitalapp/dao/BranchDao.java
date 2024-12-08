package com.ty.hospitalapp.dao;

import java.util.List;
import com.ty.hospitalapp.dto.Branch;

public interface BranchDao {
	// Save a new branch associated with a specific hospital
	// Parameters:
	// int hid - The hospital ID to associate the branch with
	// Branch branch - The branch to be saved
	// Returns:
	// The saved branch object
	public Branch saveBranch(int hid, Branch branch);

	// Retrieve a branch by its ID
	// Parameters:
	// int bid - The branch ID
	// Returns:
	// The branch object if found, else null
	public Branch getBranchById(int bid);

	// Update an existing branch by its ID
	// Parameters:
	// int bid - The branch ID
	// Branch branch - The new branch details to update
	// Returns:
	// The updated branch object if successful, else null
	public Branch updateBranchById(int bid, Branch branch);

	// Delete a branch by its ID
	// Parameters:
	// int bid - The branch ID
	// Returns:
	// True if deletion is successful, else false
	public boolean deleteBranch(int bid);

	// Retrieve all branches
	// Returns:
	// A list of all branch objects
	public List<Branch> getAllBranch();
}
