package com.ty.hospitalapp.controller;

import java.util.List;
import java.util.Scanner;

import com.ty.hospitalapp.dto.Address;
import com.ty.hospitalapp.service.AddressService;

public class AddressController {
    private static AddressService addressService = new AddressService();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            // Display menu options
            System.out.println("1. Save Address");
            System.out.println("2. Get Address by ID");
            System.out.println("3. Update Address by ID");
            System.out.println("4. Delete Address by ID");
            System.out.println("5. Get All Addresses");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();

            // Handle user choice
            switch (choice) {
                case 1:
                    saveAddress();
                    break;
                case 2:
                    getAddressById();
                    break;
                case 3:
                    updateAddressById();
                    break;
                case 4:
                    deleteAddressById();
                    break;
                case 5:
                    getAllAddresses();
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    // Method to save a new address
    private static void saveAddress() {
        System.out.print("Enter Branch ID: ");
        int bid = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Street: ");
        String street = scanner.nextLine();
        System.out.print("Enter Country: ");
        String country = scanner.nextLine();
        System.out.print("Enter Pin: ");
        String pin = scanner.next();

        Address address = new Address();
        address.setStreet(street);
        address.setCountry(country);
        address.setPin(pin);

        addressService.saveAddress(bid, address);
    }

    // Method to get an address by its ID
    private static void getAddressById() {
        System.out.print("Enter Address ID: ");
        int aid = scanner.nextInt();

        Address address = addressService.getAddressById(aid);
        if (address != null) {
            // Printing address details line by line
            System.out.println("Address Details:");
            System.out.println("ID: " + address.getAid());
            System.out.println("Street: " + address.getStreet());
            System.out.println("Country: " + address.getCountry());
            System.out.println("Pin: " + address.getPin());
        } else {
            System.out.println("Address not found");
        }
    }

    // Method to update an address by its ID
    private static void updateAddressById() {
        System.out.print("Enter Address ID: ");
        int aid = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Street: ");
        String street = scanner.nextLine();
        System.out.print("Enter Country: ");
        String country = scanner.nextLine();
        System.out.print("Enter Pin: ");
        String pin = scanner.next();

        Address address = new Address();
        address.setStreet(street);
        address.setCountry(country);
        address.setPin(pin);

        Address updatedAddress = addressService.updateAddressById(aid, address);
        if (updatedAddress != null) {
            System.out.println("Address updated: " + updatedAddress);
        } else {
            System.out.println("Address not updated");
        }
    }

    // Method to delete an address by its ID
    private static void deleteAddressById() {
        System.out.print("Enter Address ID: ");
        int aid = scanner.nextInt();

        boolean deleted = addressService.deleteAddressById(aid);
        if (deleted) {
            System.out.println("Address deleted");
        } else {
            System.out.println("Address not deleted");
        }
    }

    // Method to get all addresses
    private static void getAllAddresses() {
        List<Address> addresses = addressService.getAllAddress();
        if (addresses != null && !addresses.isEmpty()) {
            for (Address address : addresses) {
                System.out.println("Address Details:");
                System.out.println("ID: " + address.getAid());
                System.out.println("Street: " + address.getStreet());
                System.out.println("Country: " + address.getCountry());
                System.out.println("Pin: " + address.getPin());
                System.out.println("---------------------");
            }
        } else {
            System.out.println("No addresses found");
        }
    }
}
