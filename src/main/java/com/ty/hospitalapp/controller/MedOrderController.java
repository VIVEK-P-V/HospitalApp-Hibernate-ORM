package com.ty.hospitalapp.controller;

import java.util.List;
import java.util.Scanner;

import com.ty.hospitalapp.dto.MedOrder;
import com.ty.hospitalapp.service.MedOrderService;

public class MedOrderController {
	private static MedOrderService medOrderService = new MedOrderService();
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		while (true) {
			// Display menu options
			System.out.println("1. Save MedOrder");
			System.out.println("2. Get MedOrder by ID");
			System.out.println("3. Update MedOrder by ID");
			System.out.println("4. Delete MedOrder by ID");
			System.out.println("5. Get All MedOrders");
			System.out.println("6. Get MedOrders by Doctor Name");
			System.out.println("7. Exit");
			System.out.print("Enter choice: ");
			int choice = scanner.nextInt();

			// Handle user choice
			switch (choice) {
			case 1:
				saveMedOrder();
				break;
			case 2:
				getMedOrderById();
				break;
			case 3:
				updateMedOrderById();
				break;
			case 4:
				deleteMedOrderById();
				break;
			case 5:
				getAllMedOrders();
				break;
			case 6:
				getMedOrdersByDoctorName();
				break;
			case 7:
				System.exit(0);
				break;
			default:
				System.out.println("Invalid choice");
			}
		}
	}

	// Method to save a new MedOrder
	private static void saveMedOrder() {
		System.out.print("Enter Encounter ID: ");
		int eid = scanner.nextInt();
		scanner.nextLine(); // Consume newline
		System.out.print("Enter Doctor Name: ");
		String dname = scanner.nextLine();
		System.out.print("Enter Order Date: ");
		String orderDate = scanner.nextLine();

		MedOrder medOrder = new MedOrder();
		medOrder.setDname(dname);
		medOrder.setOrderDate(orderDate);

		MedOrder savedMedOrder = medOrderService.saveMedOrder(eid, medOrder);
		if (savedMedOrder != null) {
			System.out.println("MedOrder saved: " + savedMedOrder);
		} else {
			System.out.println("MedOrder not saved");
		}
	}

	// Method to get a MedOrder by its ID
	private static void getMedOrderById() {
		System.out.print("Enter MedOrder ID: ");
		int mid = scanner.nextInt();

		MedOrder medOrder = medOrderService.getMedOrderById(mid);
		if (medOrder != null) {
			// Printing MedOrder details line by line
			System.out.println("MedOrder Details:");
			System.out.println("ID: " + medOrder.getMid());
			System.out.println("Doctor Name: " + medOrder.getDname());
			System.out.println("Order Date: " + medOrder.getOrderDate());
		} else {
			System.out.println("MedOrder not found");
		}
	}

	// Method to update a MedOrder by its ID
	private static void updateMedOrderById() {
		System.out.print("Enter MedOrder ID: ");
		int mid = scanner.nextInt();
		scanner.nextLine(); // Consume newline
		System.out.print("Enter Doctor Name: ");
		String dname = scanner.nextLine();
		System.out.print("Enter Order Date: ");
		String orderDate = scanner.nextLine();

		MedOrder medOrder = new MedOrder();
		medOrder.setDname(dname);
		medOrder.setOrderDate(orderDate);

		MedOrder updatedMedOrder = medOrderService.updateMedOrderById(mid, medOrder);
		if (updatedMedOrder != null) {
			System.out.println("MedOrder updated: " + updatedMedOrder);
		} else {
			System.out.println("MedOrder not updated");
		}
	}

	// Method to delete a MedOrder by its ID
	private static void deleteMedOrderById() {
		System.out.print("Enter MedOrder ID: ");
		int mid = scanner.nextInt();

		boolean deleted = medOrderService.deleteMedOrderById(mid);
		if (deleted) {
			System.out.println("MedOrder deleted");
		} else {
			System.out.println("MedOrder not deleted");
		}
	}

	// Method to get all MedOrders
	private static void getAllMedOrders() {
		List<MedOrder> medOrders = medOrderService.getAllMedOrder();
		if (medOrders != null && !medOrders.isEmpty()) {
			for (MedOrder medOrder : medOrders) {
				// Printing MedOrder details line by line
				System.out.println("MedOrder Details:");
				System.out.println("ID: " + medOrder.getMid());
				System.out.println("Doctor Name: " + medOrder.getDname());
				System.out.println("Order Date: " + medOrder.getOrderDate());
				System.out.println("---------------------");
			}
		} else {
			System.out.println("No MedOrders found");
		}
	}

	// Method to get MedOrders by Doctor Name
	private static void getMedOrdersByDoctorName() {
		scanner.nextLine(); // Consume newline
		System.out.print("Enter Doctor Name: ");
		String dname = scanner.nextLine();

		List<MedOrder> medOrders = medOrderService.getMedOrderByDoctorName(dname);
		if (medOrders != null && !medOrders.isEmpty()) {
			for (MedOrder medOrder : medOrders) {
				// Printing MedOrder details line by line
				System.out.println("MedOrder Details:");
				System.out.println("ID: " + medOrder.getMid());
				System.out.println("Doctor Name: " + medOrder.getDname());
				System.out.println("Order Date: " + medOrder.getOrderDate());
				System.out.println("---------------------");
			}
		} else {
			System.out.println("No MedOrders found for the given doctor name");
		}
	}
}
