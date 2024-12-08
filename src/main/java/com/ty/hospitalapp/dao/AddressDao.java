package com.ty.hospitalapp.dao;

import java.util.List;
import com.ty.hospitalapp.dto.Address;

public interface AddressDao {
	// Save a new address associated with a specific branch
	// Parameters:
	// int bid - The branch ID to associate the address with
	// Address address - The address to be saved
	// Returns:
	// The saved address object
	public Address saveAddress(int bid, Address address);

	// Retrieve an address by its ID
	// Parameters:
	// int aid - The address ID
	// Returns:
	// The address object if found, else null
	public Address getAddressById(int aid);

	// Update an existing address by its ID
	// Parameters:
	// int aid - The address ID
	// Address address - The new address details to update
	// Returns:
	// The updated address object if successful, else null
	public Address updateAddressById(int aid, Address address);

	// Delete an address by its ID
	// Parameters:
	// int aid - The address ID
	// Returns:
	// True if deletion is successful, else false
	public boolean deleteAddressById(int aid);

	// Retrieve all addresses
	// Returns:
	// A list of all address objects
	public List<Address> getAllAddress();
}
