package com.ty.hospitalapp.controller;

import java.util.List;
import java.util.Scanner;

import com.ty.hospitalapp.dto.Branch;
import com.ty.hospitalapp.service.BranchService;

public class BranchController {
	private static BranchService branchService = new BranchService();
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		while (true) {
			// Display menu options
			System.out.println("1. Save Branch");
			System.out.println("2. Get Branch by ID");
			System.out.println("3. Update Branch by ID");
			System.out.println("4. Delete Branch by ID");
			System.out.println("5. Get All Branches");
			System.out.println("6. Exit");
			System.out.print("Enter choice: ");
			int choice = scanner.nextInt();

			// Handle user choice
			switch (choice) {
			case 1:
				saveBranch();
				break;
			case 2:
				getBranchById();
				break;
			case 3:
				updateBranchById();
				break;
			case 4:
				deleteBranch();
				break;
			case 5:
				getAllBranches();
				break;
			case 6:
				System.exit(0);
				break;
			default:
				System.out.println("Invalid choice");
			}
		}
	}

	// Method to save a new branch
	private static void saveBranch() {
		System.out.print("Enter Hospital ID: ");
		int hid = scanner.nextInt();
		scanner.nextLine(); // Consume newline
		System.out.print("Enter Branch Name: ");
		String name = scanner.nextLine();
		System.out.print("Enter Phone Number: ");
		long phno = scanner.nextLong();
		scanner.nextLine(); // Consume newline
		System.out.print("Enter Email: ");
		String email = scanner.nextLine();

		Branch branch = new Branch();
		branch.setName(name);
		branch.setPhno(phno);
		branch.setEmail(email);

		Branch savedBranch = branchService.saveBranch(hid, branch);
		if (savedBranch != null) {
			System.out.println("Branch saved: " + savedBranch);
		} else {
			System.out.println("Branch not saved");
		}
	}

	// Method to get a branch by its ID
	private static void getBranchById() {
		System.out.print("Enter Branch ID: ");
		int bid = scanner.nextInt();

		Branch branch = branchService.getBranchById(bid);
		if (branch != null) {
			// Printing branch details line by line
			System.out.println("Branch Details:");
			System.out.println("ID: " + branch.getBid());
			System.out.println("Name: " + branch.getName());
			System.out.println("Phone Number: " + branch.getPhno());
			System.out.println("Email: " + branch.getEmail());
		} else {
			System.out.println("Branch not found");
		}
	}

	// Method to update a branch by its ID
	private static void updateBranchById() {
		System.out.print("Enter Branch ID: ");
		int bid = scanner.nextInt();
		scanner.nextLine(); // Consume newline
		System.out.print("Enter Branch Name: ");
		String name = scanner.nextLine();
		System.out.print("Enter Phone Number: ");
		long phno = scanner.nextLong();
		scanner.nextLine(); // Consume newline
		System.out.print("Enter Email: ");
		String email = scanner.nextLine();

		Branch branch = new Branch();
		branch.setName(name);
		branch.setPhno(phno);
		branch.setEmail(email);

		Branch updatedBranch = branchService.updateBranchById(bid, branch);
		if (updatedBranch != null) {
			System.out.println("Branch updated: " + updatedBranch);
		} else {
			System.out.println("Branch not updated");
		}
	}

	// Method to delete a branch by its ID
	private static void deleteBranch() {
		System.out.print("Enter Branch ID: ");
		int bid = scanner.nextInt();

		boolean deleted = branchService.deleteBranch(bid);
		if (deleted) {
			System.out.println("Branch deleted");
		} else {
			System.out.println("Branch not deleted");
		}
	}

	// Method to get all branches
	private static void getAllBranches() {
		List<Branch> branches = branchService.getAllBranch();
		if (branches != null && !branches.isEmpty()) {
			for (Branch branch : branches) {
				System.out.println("Branch Details:");
				System.out.println("ID: " + branch.getBid());
				System.out.println("Name: " + branch.getName());
				System.out.println("Phone Number: " + branch.getPhno());
				System.out.println("Email: " + branch.getEmail());
				System.out.println("---------------------");
			}
		} else {
			System.out.println("No branches found");
		}
	}
}
