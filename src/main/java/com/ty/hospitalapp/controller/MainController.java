package com.ty.hospitalapp.controller;

import java.util.Scanner;

public class MainController {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		while (true) {
		
			System.out.println("------Welcome to the Hospital Management System ------");
			System.out.println();
			System.out.println("1.User Management");
			System.out.println();
			System.out.println("2.Hospital Management");
			System.out.println();
			System.out.println("3.Branch Management");
			System.out.println();
			System.out.println("4.Person Management");
			System.out.println();
			System.out.println("5.Address Management");
			System.out.println();
			System.out.println("6.Encounter Management");
			System.out.println();
			System.out.println("7.Item Management");
			System.out.println();
			System.out.println("8.MedOrder Management");
			System.out.println();
			System.out.println("9.Observation Management");
			System.out.println();
			System.out.println("10.Exit");
			System.out.println();
			System.out.println();
			System.out.print("Enter your choice: ");
			int choice = scanner.nextInt();

			// Handle user choice
			switch (choice) {
			case 1:
				UserController.main(args);
				break;
			case 2:
				HospitalController.main(args);
				break;
			case 3:
				BranchController.main(args);
				break;
			case 4:
				PersonController.main(args);
				break;
			case 5:
				AddressController.main(args);
				break;
			case 6:
				EncounterController.main(args);
				break;
			case 7:
				ItemController.main(args);
				break;
			case 8:
				MedOrderController.main(args);
				break;
			case 9:
				ObservationController.main(args);
				break;
			case 10:
				System.out.println("Exiting the system. Have a great day!");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		}
	}
}
