package com.ty.hospitalapp.controller;

import java.util.List;
import java.util.Scanner;

import com.ty.hospitalapp.dto.Observation;
import com.ty.hospitalapp.service.ObservationService;

public class ObservationController {
	private static ObservationService observationService = new ObservationService();
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		while (true) {
			// Display menu options
			System.out.println("1. Save Observation");
			System.out.println("2. Get Observation by ID");
			System.out.println("3. Update Observation by ID");
			System.out.println("4. Delete Observation by ID");
			System.out.println("5. Get Observations by Doctor Name");
			System.out.println("6. Exit");
			System.out.print("Enter choice: ");
			int choice = scanner.nextInt();

			// Handle user choice
			switch (choice) {
			case 1:
				saveObservation();
				break;
			case 2:
				getObservationById();
				break;
			case 3:
				updateObservationById();
				break;
			case 4:
				deleteObservationById();
				break;
			case 5:
				getObservationsByDoctorName();
				break;
			case 6:
				System.exit(0);
				break;
			default:
				System.out.println("Invalid choice");
			}
		}
	}

	// Method to save a new observation
	private static void saveObservation() {
		System.out.print("Enter Encounter ID: ");
		int eid = scanner.nextInt();
		scanner.nextLine(); // Consume newline
		System.out.print("Enter Doctor Name: ");
		String dname = scanner.nextLine();
		System.out.print("Enter Observation: ");
		String rObservation = scanner.nextLine();

		Observation observation = new Observation();
		observation.setDname(dname);
		observation.setrObservation(rObservation);

		Observation savedObservation = observationService.saveObservation(eid, observation);
		if (savedObservation != null) {
			System.out.println("Observation saved: " + savedObservation);
		} else {
			System.out.println("Observation not saved");
		}
	}

	// Method to get an observation by its ID
	private static void getObservationById() {
		System.out.print("Enter Observation ID: ");
		int oid = scanner.nextInt();

		Observation observation = observationService.getObservationById(oid);
		if (observation != null) {
			// Printing observation details line by line
			System.out.println("Observation Details:");
			System.out.println("ID: " + observation.getOid());
			System.out.println("Doctor Name: " + observation.getDname());
			System.out.println("Observation: " + observation.getrObservation());
		} else {
			System.out.println("Observation not found");
		}
	}

	// Method to update an observation by its ID
	private static void updateObservationById() {
		System.out.print("Enter Observation ID: ");
		int oid = scanner.nextInt();
		scanner.nextLine(); // Consume newline
		System.out.print("Enter Doctor Name: ");
		String dname = scanner.nextLine();
		System.out.print("Enter Observation: ");
		String rObservation = scanner.nextLine();

		Observation observation = new Observation();
		observation.setDname(dname);
		observation.setrObservation(rObservation);

		Observation updatedObservation = observationService.updateObservationById(oid, observation);
		if (updatedObservation != null) {
			System.out.println("Observation updated: " + updatedObservation);
		} else {
			System.out.println("Observation not updated");
		}
	}

	// Method to delete an observation by its ID
	private static void deleteObservationById() {
		System.out.print("Enter Observation ID: ");
		int oid = scanner.nextInt();

		boolean deleted = observationService.deleteObservationById(oid);
		if (deleted) {
			System.out.println("Observation deleted");
		} else {
			System.out.println("Observation not deleted");
		}
	}

	// Method to get observations by doctor name
	private static void getObservationsByDoctorName() {
		scanner.nextLine(); // Consume newline
		System.out.print("Enter Doctor Name: ");
		String dname = scanner.nextLine();

		List<Observation> observations = observationService.getAllObservationByDoctorName(dname);
		if (observations != null && !observations.isEmpty()) {
			for (Observation observation : observations) {
				// Printing observation details line by line
				System.out.println("Observation Details:");
				System.out.println("ID: " + observation.getOid());
				System.out.println("Doctor Name: " + observation.getDname());
				System.out.println("Observation: " + observation.getrObservation());
				System.out.println("---------------------");
			}
		} else {
			System.out.println("No observations found for the given doctor name");
		}
	}
}
