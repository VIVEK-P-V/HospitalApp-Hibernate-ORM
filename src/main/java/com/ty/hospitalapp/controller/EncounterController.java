package com.ty.hospitalapp.controller;

import java.util.List;
import java.util.Scanner;
import com.ty.hospitalapp.dto.Encounter;
import com.ty.hospitalapp.service.EncounterService;

public class EncounterController {
	private static EncounterService encounterService = new EncounterService();
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		while (true) {
			// Display menu options
			System.out.println("1. Save Encounter");
			System.out.println("2. Get Encounter by ID");
			System.out.println("3. Update Encounter by ID");
			System.out.println("4. Delete Encounter by ID");
			System.out.println("5. Get All Encounters");
			System.out.println("6. Exit");
			System.out.print("Enter choice: ");
			int choice = scanner.nextInt();

			// Handle user choice
			switch (choice) {
			case 1:
				saveEncounter();
				break;
			case 2:
				getEncounterById();
				break;
			case 3:
				updateEncounterById();
				break;
			case 4:
				deleteEncounterById();
				break;
			case 5:
				getAllEncounters();
				break;
			case 6:
				System.exit(0);
				break;
			default:
				System.out.println("Invalid choice");
			}
		}
	}

	// Method to save a new encounter
	private static void saveEncounter() {
		System.out.print("Enter Branch ID: ");
		int bid = scanner.nextInt();
		scanner.nextLine(); // Consume newline
		System.out.print("Enter Reason: ");
		String reason = scanner.nextLine();
		System.out.print("Enter Date of Join: ");
		String dateOfJoin = scanner.nextLine();
		System.out.print("Enter Discharge Date: ");
		String discharge = scanner.nextLine();

		Encounter encounter = new Encounter();
		encounter.setReason(reason);
		encounter.setDateOfJoin(dateOfJoin);
		encounter.setDischarge(discharge);

		Encounter savedEncounter = encounterService.saveEncounter(bid, encounter);
		if (savedEncounter != null) {
			System.out.println("Encounter saved: " + savedEncounter);
		} else {
			System.out.println("Encounter not saved");
		}
	}

	// Method to get an encounter by its ID
	private static void getEncounterById() {
		System.out.print("Enter Encounter ID: ");
		int eid = scanner.nextInt();

		Encounter encounter = encounterService.getEncounterById(eid);
		if (encounter != null) {
			// Printing encounter details line by line
			System.out.println("Encounter Details:");
			System.out.println("ID: " + encounter.getEid());
			System.out.println("Reason: " + encounter.getReason());
			System.out.println("Date of Join: " + encounter.getDateOfJoin());
			System.out.println("Discharge Date: " + encounter.getDischarge());
		} else {
			System.out.println("Encounter not found");
		}
	}

	// Method to update an encounter by its ID
	private static void updateEncounterById() {
		System.out.print("Enter Encounter ID: ");
		int eid = scanner.nextInt();
		scanner.nextLine(); // Consume newline
		System.out.print("Enter Reason: ");
		String reason = scanner.nextLine();
		System.out.print("Enter Date of Join: ");
		String dateOfJoin = scanner.nextLine();
		System.out.print("Enter Discharge Date: ");
		String discharge = scanner.nextLine();

		Encounter encounter = new Encounter();
		encounter.setReason(reason);
		encounter.setDateOfJoin(dateOfJoin);
		encounter.setDischarge(discharge);

		Encounter updatedEncounter = encounterService.updateEncounterById(eid, encounter);
		if (updatedEncounter != null) {
			System.out.println("Encounter updated: " + updatedEncounter);
		} else {
			System.out.println("Encounter not updated");
		}
	}

	// Method to delete an encounter by its ID
	private static void deleteEncounterById() {
		System.out.print("Enter Encounter ID: ");
		int eid = scanner.nextInt();

		boolean deleted = encounterService.deleteEncounterById(eid);
		if (deleted) {
			System.out.println("Encounter deleted");
		} else {
			System.out.println("Encounter not deleted");
		}
	}

	// Method to get all encounters
	private static void getAllEncounters() {
		List<Encounter> encounters = encounterService.getAllEncounter();
		if (encounters != null && !encounters.isEmpty()) {
			for (Encounter encounter : encounters) {
				System.out.println("Encounter Details:");
				System.out.println("ID: " + encounter.getEid());
				System.out.println("Reason: " + encounter.getReason());
				System.out.println("Date of Join: " + encounter.getDateOfJoin());
				System.out.println("Discharge Date: " + encounter.getDischarge());
				System.out.println("---------------------");
			}
		} else {
			System.out.println("No encounters found");
		}
	}
}
