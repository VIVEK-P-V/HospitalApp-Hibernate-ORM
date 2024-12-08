package com.ty.hospitalapp.controller;

import java.util.List;
import java.util.Scanner;

import com.ty.hospitalapp.dto.Hospital;
import com.ty.hospitalapp.service.HospitalService;

public class HospitalController {
	private static HospitalService hospitalService = new HospitalService();
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		while (true) {
			// Display menu options
			System.out.println("1. Save Hospital");
			System.out.println("2. Get Hospital by ID");
			System.out.println("3. Update Hospital by ID");
			System.out.println("4. Delete Hospital by ID");
			System.out.println("5. Get All Hospitals");
			System.out.println("6. Exit");
			System.out.print("Enter choice: ");
			int choice = scanner.nextInt();

			// Handle user choice
			switch (choice) {
			case 1:
				saveHospital();
				break;
			case 2:
				getHospitalById();
				break;
			case 3:
				updateHospitalById();
				break;
			case 4:
				deleteHospital();
				break;
			case 5:
				getAllHospitals();
				break;
			case 6:
				System.exit(0);
				break;
			default:
				System.out.println("Invalid choice");
			}
		}
	}

	// Method to save a new hospital
	private static void saveHospital() {
		scanner.nextLine(); // Consume newline
		System.out.print("Enter Name: ");
		String name = scanner.nextLine();
		System.out.print("Enter Website: ");
		String website = scanner.nextLine();

		Hospital hospital = new Hospital();
		hospital.setName(name);
		hospital.setWebsite(website);

		hospitalService.saveHospital(hospital);
	}

	// Method to get a hospital by its ID
	private static void getHospitalById() {
		System.out.print("Enter Hospital ID: ");
		int hid = scanner.nextInt();

		Hospital hospital = hospitalService.getHospitalById(hid);
		if (hospital != null) {
			// Printing hospital details line by line
			System.out.println("Hospital Details:");
			System.out.println("ID: " + hospital.getHid());
			System.out.println("Name: " + hospital.getName());
			System.out.println("Website: " + hospital.getWebsite());
		} else {
			System.out.println("Hospital not found");
		}
	}

	// Method to update a hospital by its ID
	private static void updateHospitalById() {
		System.out.print("Enter Hospital ID: ");
		int hid = scanner.nextInt();
		scanner.nextLine(); // Consume newline
		System.out.print("Enter Name: ");
		String name = scanner.nextLine();
		System.out.print("Enter Website: ");
		String website = scanner.nextLine();

		Hospital hospital = new Hospital();
		hospital.setName(name);
		hospital.setWebsite(website);

		Hospital updatedHospital = hospitalService.updateHospitalById(hid, hospital);
		if (updatedHospital != null) {
			System.out.println("Hospital updated: " + updatedHospital);
		} else {
			System.out.println("Hospital not updated");
		}
	}

	// Method to delete a hospital by its ID
	private static void deleteHospital() {
		System.out.print("Enter Hospital ID: ");
		int hid = scanner.nextInt();

		boolean deleted = hospitalService.deleteHospital(hid);
		if (deleted) {
			System.out.println("Hospital deleted");
		} else {
			System.out.println("Hospital not deleted");
		}
	}

	// Method to get all hospitals
	private static void getAllHospitals() {
		List<Hospital> hospitals = hospitalService.getAllHospital();
		if (hospitals != null && !hospitals.isEmpty()) {
			for (Hospital hospital : hospitals) {
				System.out.println("Hospital Details:");
				System.out.println("ID: " + hospital.getHid());
				System.out.println("Name: " + hospital.getName());
				System.out.println("Website: " + hospital.getWebsite());
				System.out.println("---------------------");
			}
		} else {
			System.out.println("No hospitals found");
		}
	}
}
