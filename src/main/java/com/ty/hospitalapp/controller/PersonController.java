package com.ty.hospitalapp.controller;

import java.util.List;
import java.util.Scanner;
import com.ty.hospitalapp.dto.Person;
import com.ty.hospitalapp.service.PersonService;

public class PersonController {
	private static PersonService personService = new PersonService();
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		while (true) {
			// Display menu options
			System.out.println("1. Save Person");
			System.out.println("2. Get Person by ID");
			System.out.println("3. Update Person by ID");
			System.out.println("4. Delete Person by ID");
			System.out.println("5. Get All Persons");
			System.out.println("6. Get Persons by Gender");
			System.out.println("7. Get Persons by Age");
			System.out.println("8. Get Persons by Phone Number");
			System.out.println("9. Exit");
			System.out.print("Enter choice: ");
			int choice = scanner.nextInt();

			// Handle user choice
			switch (choice) {
			case 1:
				savePerson();
				break;
			case 2:
				getPersonById();
				break;
			case 3:
				updatePersonById();
				break;
			case 4:
				deletePersonById();
				break;
			case 5:
				getAllPersons();
				break;
			case 6:
				getPersonsByGender();
				break;
			case 7:
				getPersonsByAge();
				break;
			case 8:
				getPersonsByPhone();
				break;
			case 9:
				System.exit(0);
				break;
			default:
				System.out.println("Invalid choice");
			}
		}
	}

	// Method to save a new person
	private static void savePerson() {
		System.out.print("Enter Encounter ID: ");
		int eid = scanner.nextInt();
		scanner.nextLine(); // Consume newline
		System.out.print("Enter Name: ");
		String name = scanner.nextLine();
		System.out.print("Enter Age: ");
		int age = scanner.nextInt();
		scanner.nextLine(); // Consume newline
		System.out.print("Enter Gender: ");
		String gender = scanner.nextLine();
		System.out.print("Enter Date of Birth: ");
		String dob = scanner.nextLine();
		System.out.print("Enter Email: ");
		String email = scanner.nextLine();

		Person person = new Person();
		person.setName(name);
		person.setAge(age);
		person.setGender(gender);
		person.setDob(dob);
		person.setEmail(email);

		Person savedPerson = personService.savePerson(eid, person);
		if (savedPerson != null) {
			System.out.println("Person saved: " + savedPerson);
		} else {
			System.out.println("Person not saved");
		}
	}

	// Method to get a person by their ID
	private static void getPersonById() {
		System.out.print("Enter Person ID: ");
		int pid = scanner.nextInt();

		Person person = personService.getPersonById(pid);
		if (person != null) {
			// Printing person details line by line
			System.out.println("Person Details:");
			System.out.println("ID: " + person.getPid());
			System.out.println("Name: " + person.getName());
			System.out.println("Age: " + person.getAge());
			System.out.println("Gender: " + person.getGender());
			System.out.println("Date of Birth: " + person.getDob());
			System.out.println("Email: " + person.getEmail());
		} else {
			System.out.println("Person not found");
		}
	}

	// Method to update a person by their ID
	private static void updatePersonById() {
		System.out.print("Enter Person ID: ");
		int pid = scanner.nextInt();
		scanner.nextLine(); // Consume newline
		System.out.print("Enter Name: ");
		String name = scanner.nextLine();
		System.out.print("Enter Age: ");
		int age = scanner.nextInt();
		scanner.nextLine(); // Consume newline
		System.out.print("Enter Gender: ");
		String gender = scanner.nextLine();
		System.out.print("Enter Date of Birth: ");
		String dob = scanner.nextLine();
		System.out.print("Enter Email: ");
		String email = scanner.nextLine();

		Person person = new Person();
		person.setName(name);
		person.setAge(age);
		person.setGender(gender);
		person.setDob(dob);
		person.setEmail(email);

		Person updatedPerson = personService.updatePersonById(pid, person);
		if (updatedPerson != null) {
			System.out.println("Person updated: " + updatedPerson);
		} else {
			System.out.println("Person not updated");
		}
	}

	// Method to delete a person by their ID
	private static void deletePersonById() {
		System.out.print("Enter Person ID: ");
		int pid = scanner.nextInt();

		boolean deleted = personService.deletePersonById(pid);
		if (deleted) {
			System.out.println("Person deleted");
		} else {
			System.out.println("Person not deleted");
		}
	}

	// Method to get all persons
	private static void getAllPersons() {
		List<Person> persons = personService.getAllPerson();
		if (persons != null && !persons.isEmpty()) {
			for (Person person : persons) {
				// Printing person details line by line
				System.out.println("Person Details:");
				System.out.println("ID: " + person.getPid());
				System.out.println("Name: " + person.getName());
				System.out.println("Age: " + person.getAge());
				System.out.println("Gender: " + person.getGender());
				System.out.println("Date of Birth: " + person.getDob());
				System.out.println("Email: " + person.getEmail());
				System.out.println("---------------------");
			}
		} else {
			System.out.println("No persons found");
		}
	}

	// Method to get persons by gender
	private static void getPersonsByGender() {
		scanner.nextLine(); // Consume newline
		System.out.print("Enter Gender: ");
		String gender = scanner.nextLine();

		List<Person> persons = personService.getPersonByGender(gender);
		if (persons != null && !persons.isEmpty()) {
			for (Person person : persons) {
				// Printing person details line by line
				System.out.println("Person Details:");
				System.out.println("ID: " + person.getPid());
				System.out.println("Name: " + person.getName());
				System.out.println("Age: " + person.getAge());
				System.out.println("Gender: " + person.getGender());
				System.out.println("Date of Birth: " + person.getDob());
				System.out.println("Email: " + person.getEmail());
				System.out.println("---------------------");
			}
		} else {
			System.out.println("No persons found for the given gender");
		}
	}

	// Method to get persons by age
	private static void getPersonsByAge() {
		System.out.print("Enter Age: ");
		int age = scanner.nextInt();

		List<Person> persons = personService.getPersonByAge(age);
		if (persons != null && !persons.isEmpty()) {
			for (Person person : persons) {
				// Printing person details line by line
				System.out.println("Person Details:");
				System.out.println("ID: " + person.getPid());
				System.out.println("Name: " + person.getName());
				System.out.println("Age: " + person.getAge());
				System.out.println("Gender: " + person.getGender());
				System.out.println("Date of Birth: " + person.getDob());
				System.out.println("Email: " + person.getEmail());
				System.out.println("---------------------");
			}
		} else {
			System.out.println("No persons found for the given age");
		}
	}

	// Method to get persons by phone number
	private static void getPersonsByPhone() {
		System.out.print("Enter Phone Number: ");
		long phno = scanner.nextLong();

		List<Person> persons = personService.getPersonByPhone(phno);
		if (persons != null && !persons.isEmpty()) {
			for (Person person : persons) {
				// Printing person details line by line
				System.out.println("Person Details:");
				System.out.println("ID: " + person.getPid());
				System.out.println("Name: " + person.getName());
				System.out.println("Age: " + person.getAge());
				System.out.println("Gender: " + person.getGender());
				System.out.println("Date of Birth: " + person.getDob());
				System.out.println("Email: " + person.getEmail());
				System.out.println("---------------------");
			}
		} else {
			System.out.println("No persons found for the given phone number");
		}
	}
}
