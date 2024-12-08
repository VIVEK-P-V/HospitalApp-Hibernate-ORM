package com.ty.hospitalapp.controller;

import java.util.List;
import java.util.Scanner;

import com.ty.hospitalapp.dto.Item;
import com.ty.hospitalapp.service.ItemService;

public class ItemController {
	private static ItemService itemService = new ItemService();
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		while (true) {
			// Display menu options
			System.out.println("1. Save Item");
			System.out.println("2. Get Item by ID");
			System.out.println("3. Update Item by ID");
			System.out.println("4. Delete Item by ID");
			System.out.println("5. Get All Items");
			System.out.println("6. Exit");
			System.out.print("Enter choice: ");
			int choice = scanner.nextInt();

			// Handle user choice
			switch (choice) {
			case 1:
				saveItem();
				break;
			case 2:
				getItemById();
				break;
			case 3:
				updateItemById();
				break;
			case 4:
				deleteItemById();
				break;
			case 5:
				getAllItems();
				break;
			case 6:
				System.exit(0);
				break;
			default:
				System.out.println("Invalid choice");
			}
		}
	}

	// Method to save a new item
	private static void saveItem() {
		System.out.print("Enter MedOrder ID: ");
		int mid = scanner.nextInt();
		scanner.nextLine(); // Consume newline
		System.out.print("Enter Item Name: ");
		String itemName = scanner.nextLine();
		System.out.print("Enter Cost: ");
		double cost = scanner.nextDouble();
		System.out.print("Enter Quantity: ");
		int quantity = scanner.nextInt();

		Item item = new Item();
		item.setItemName(itemName);
		item.setCost(cost);
		item.setQuantity(quantity);

		Item savedItem = itemService.saveItem(mid, item);
		if (savedItem != null) {
			System.out.println("Item saved: " + savedItem);
		} else {
			System.out.println("Item not saved");
		}
	}

	// Method to get an item by its ID
	private static void getItemById() {
		System.out.print("Enter Item ID: ");
		int id = scanner.nextInt();

		Item item = itemService.getItemById(id);
		if (item != null) {
			// Printing item details line by line
			System.out.println("Item Details:");
			System.out.println("ID: " + item.getId());
			System.out.println("Name: " + item.getItemName());
			System.out.println("Cost: " + item.getCost());
			System.out.println("Quantity: " + item.getQuantity());
		} else {
			System.out.println("Item not found");
		}
	}

	// Method to update an item by its ID
	private static void updateItemById() {
		System.out.print("Enter Item ID: ");
		int id = scanner.nextInt();
		scanner.nextLine(); // Consume newline
		System.out.print("Enter Item Name: ");
		String itemName = scanner.nextLine();
		System.out.print("Enter Cost: ");
		double cost = scanner.nextDouble();
		System.out.print("Enter Quantity: ");
		int quantity = scanner.nextInt();

		Item item = new Item();
		item.setItemName(itemName);
		item.setCost(cost);
		item.setQuantity(quantity);

		Item updatedItem = itemService.updateItemById(id, item);
		if (updatedItem != null) {
			System.out.println("Item updated: " + updatedItem);
		} else {
			System.out.println("Item not updated");
		}
	}

	// Method to delete an item by its ID
	private static void deleteItemById() {
		System.out.print("Enter Item ID: ");
		int id = scanner.nextInt();

		boolean deleted = itemService.deleteItemById(id);
		if (deleted) {
			System.out.println("Item deleted");
		} else {
			System.out.println("Item not deleted");
		}
	}

	// Method to get all items
	private static void getAllItems() {
		List<Item> items = itemService.getAllItem();
		if (items != null && !items.isEmpty()) {
			for (Item item : items) {
				// Printing item details line by line
				System.out.println("Item Details:");
				System.out.println("ID: " + item.getId());
				System.out.println("Name: " + item.getItemName());
				System.out.println("Cost: " + item.getCost());
				System.out.println("Quantity: " + item.getQuantity());
				System.out.println("---------------------");
			}
		} else {
			System.out.println("No items found");
		}
	}
}
