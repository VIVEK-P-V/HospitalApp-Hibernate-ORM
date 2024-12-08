package com.ty.hospitalapp.dao;

import java.util.List;
import com.ty.hospitalapp.dto.Person;

public interface PersonDao {
	// Save a new person associated with a specific encounter
	// Parameters:
	// int eid - The encounter ID to associate the person with
	// Person person - The person to be saved
	// Returns:
	// The saved person object
	public Person savePerson(int eid, Person person);

	// Retrieve a person by their ID
	// Parameters:
	// int pid - The person ID
	// Returns:
	// The person object if found, else null
	public Person getPersonById(int pid);

	// Update an existing person by their ID
	// Parameters:
	// int pid - The person ID
	// Person person - The new person details to update
	// Returns:
	// The updated person object if successful, else null
	public Person updatePersonById(int pid, Person person);

	// Delete a person by their ID
	// Parameters:
	// int pid - The person ID
	// Returns:
	// True if deletion is successful, else false
	public boolean deletePersonById(int pid);

	// Retrieve all persons
	// Returns:
	// A list of all person objects
	public List<Person> getAllPerson();

	// Retrieve persons by gender
	// Parameters:
	// String gender - The gender of the persons to retrieve
	// Returns:
	// A list of persons of the specified gender
	public List<Person> getPersonByGender(String gender);

	// Retrieve persons by age
	// Parameters:
	// int age - The age of the persons to retrieve
	// Returns:
	// A list of persons of the specified age
	public List<Person> getPersonByAge(int age);

	// Retrieve persons by phone number
	// Parameters:
	// long phno - The phone number of the persons to retrieve
	// Returns:
	// A list of persons with the specified phone number
	public List<Person> getPersonByPhone(long phno);
}
