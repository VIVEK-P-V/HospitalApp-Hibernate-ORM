package com.ty.hospitalapp.service;

import java.util.List;
import com.ty.hospitalapp.dao.impl.UserDaoImpl;
import com.ty.hospitalapp.dto.User;

public class UserService {

	// Method to save a new user
	public User saveUser(User user) {
		UserDaoImpl daoImp = new UserDaoImpl();
		User user2 = daoImp.saveUser(user);
		if (user2 != null) {
			System.out.println("Record Saved");
			return user2;
		} else {
			System.out.println("Record Not Saved");
			return null;
		}
	}

	// Method to get a user by their ID
	public User getUser(int uid) {
		UserDaoImpl daoImp = new UserDaoImpl();
		User user2 = daoImp.getUser(uid);
		if (user2 != null) {
			return user2;
		} else {
			return null;
		}
	}

	// Method to update an existing user by their ID
	public User updateUser(int uid, User user) {
		UserDaoImpl daoImp = new UserDaoImpl();
		User user2 = daoImp.updateUser(uid, user);
		if (user2 != null) {
			return user2;
		} else {
			return null;
		}
	}

	// Method to delete a user by their ID
	public boolean deleteUserById(int uid) {
		UserDaoImpl daoImp = new UserDaoImpl();
		boolean flag = daoImp.deleteUserById(uid);
		if (flag) {
			System.out.println("Record Deleted Successfully");
			return true;
		} else {
			System.out.println("Record Not Deleted");
			return false;
		}
	}

	// Method to get a list of all users
	public List<User> getAllUser() {
		UserDaoImpl daoImp = new UserDaoImpl();
		List<User> users = daoImp.getAllUser();
		if (users != null) {
			return users;
		} else {
			return null;
		}
	}

	// Method to get a list of users by role
	public List<User> getAllUserByRole(String role) {
		UserDaoImpl daoImp = new UserDaoImpl();
		List<User> users = daoImp.getAllUserByRole(role);
		if (users != null) {
			return users;
		} else {
			return null;
		}
	}
}
