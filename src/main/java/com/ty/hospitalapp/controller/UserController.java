package com.ty.hospitalapp.controller;

import java.util.List;
import java.util.Scanner;
import com.ty.hospitalapp.dto.User;
import com.ty.hospitalapp.service.UserService;

public class UserController {
	private static UserService userService = new UserService();
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		while (true) {
			// Display menu options
			System.out.println("1. Save User");
			System.out.println("2. Get User by ID");
			System.out.println("3. Update User by ID");
			System.out.println("4. Delete User by ID");
			System.out.println("5. Get All Users");
			System.out.println("6. Get Users by Role");
			System.out.println("7. Exit");
			System.out.print("Enter choice: ");
			int choice = scanner.nextInt();

			// Handle user choice
			switch (choice) {
			case 1:
				saveUser();
				break;
			case 2:
				getUserById();
				break;
			case 3:
				updateUserById();
				break;
			case 4:
				deleteUserById();
				break;
			case 5:
				getAllUsers();
				break;
			case 6:
				getUsersByRole();
				break;
			case 7:
				System.exit(0);
				break;
			default:
				System.out.println("Invalid choice");
			}
		}
	}

	// Method to save a new user
	private static void saveUser() {
		scanner.nextLine(); // Consume newline
		System.out.print("Enter Name: ");
		String name = scanner.nextLine();
		System.out.print("Enter Email: ");
		String email = scanner.nextLine();
		System.out.print("Enter Phone Number: ");
		long phno = scanner.nextLong();
		scanner.nextLine(); // Consume newline
		System.out.print("Enter Password: ");
		String pass = scanner.nextLine();
		System.out.print("Enter Role: ");
		String role = scanner.nextLine();

		User user = new User();
		user.setName(name);
		user.setEmail(email);
		user.setPhno(phno);
		user.setPass(pass);
		user.setRole(role);

		User savedUser = userService.saveUser(user);
		if (savedUser != null) {
			System.out.println("User saved: " + savedUser);
		} else {
			System.out.println("User not saved");
		}
	}

	// Method to get a user by their ID
	private static void getUserById() {
		System.out.print("Enter User ID: ");
		int uid = scanner.nextInt();

		User user = userService.getUser(uid);
		if (user != null) {
			// Printing user details line by line
			System.out.println("User Details:");
			System.out.println("ID: " + user.getUid());
			System.out.println("Name: " + user.getName());
			System.out.println("Email: " + user.getEmail());
			System.out.println("Phone Number: " + user.getPhno());
			System.out.println("Password: " + user.getPass());
			System.out.println("Role: " + user.getRole());
		} else {
			System.out.println("User not found");
		}
	}

	// Method to update a user by their ID
	private static void updateUserById() {
		System.out.print("Enter User ID: ");
		int uid = scanner.nextInt();
		scanner.nextLine(); // Consume newline
		System.out.print("Enter Name: ");
		String name = scanner.nextLine();
		System.out.print("Enter Email: ");
		String email = scanner.nextLine();
		System.out.print("Enter Phone Number: ");
		long phno = scanner.nextLong();
		scanner.nextLine(); // Consume newline
		System.out.print("Enter Password: ");
		String pass = scanner.nextLine();
		System.out.print("Enter Role: ");
		String role = scanner.nextLine();

		User user = new User();
		user.setName(name);
		user.setEmail(email);
		user.setPhno(phno);
		user.setPass(pass);
		user.setRole(role);

		User updatedUser = userService.updateUser(uid, user);
		if (updatedUser != null) {
			System.out.println("User updated: " + updatedUser);
		} else {
			System.out.println("User not updated");
		}
	}

	// Method to delete a user by their ID
	private static void deleteUserById() {
		System.out.print("Enter User ID: ");
		int uid = scanner.nextInt();

		boolean deleted = userService.deleteUserById(uid);
		if (deleted) {
			System.out.println("User deleted");
		} else {
			System.out.println("User not deleted");
		}
	}

	// Method to get all users
	private static void getAllUsers() {
		List<User> users = userService.getAllUser();
		if (users != null && !users.isEmpty()) {
			for (User user : users) {
				// Printing user details line by line
				System.out.println("User Details:");
				System.out.println("ID: " + user.getUid());
				System.out.println("Name: " + user.getName());
				System.out.println("Email: " + user.getEmail());
				System.out.println("Phone Number: " + user.getPhno());
				System.out.println("Password: " + user.getPass());
				System.out.println("Role: " + user.getRole());
				System.out.println("---------------------");
			}
		} else {
			System.out.println("No users found");
		}
	}

	// Method to get users by role
	private static void getUsersByRole() {
		scanner.nextLine(); // Consume newline
		System.out.print("Enter Role: ");
		String role = scanner.nextLine();

		List<User> users = userService.getAllUserByRole(role);
		if (users != null && !users.isEmpty()) {
			for (User user : users) {
				// Printing user details line by line
				System.out.println("User Details:");
				System.out.println("ID: " + user.getUid());
				System.out.println("Name: " + user.getName());
				System.out.println("Email: " + user.getEmail());
				System.out.println("Phone Number: " + user.getPhno());
				System.out.println("Password: " + user.getPass());
				System.out.println("Role: " + user.getRole());
				System.out.println("---------------------");
			}
		} else {
			System.out.println("No users found for the given role");
		}
	}
}
