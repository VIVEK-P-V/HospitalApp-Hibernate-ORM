package com.ty.hospitalapp.dao;

import java.util.List;
import com.ty.hospitalapp.dto.User;

public interface UserDao {
	// Save a new user
	// Parameters:
	// User user - The user to be saved
	// Returns:
	// The saved user object
	public User saveUser(User user);

	// Retrieve a user by their ID
	// Parameters:
	// int uid - The user ID
	// Returns:
	// The user object if found, else null
	public User getUser(int uid);

	// Update an existing user by their ID
	// Parameters:
	// int uid - The user ID
	// User user - The new user details to update
	// Returns:
	// The updated user object if successful, else null
	public User updateUser(int uid, User user);

	// Delete a user by their ID
	// Parameters:
	// int uid - The user ID
	// Returns:
	// True if deletion is successful, else false
	public boolean deleteUserById(int uid);

	// Retrieve all users
	// Returns:
	// A list of all user objects
	public List<User> getAllUser();

	// Retrieve all users by role
	// Parameters:
	// String role - The role of the users to retrieve
	// Returns:
	// A list of users with the specified role
	public List<User> getAllUserByRole(String role);
}
