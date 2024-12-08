package com.ty.hospitalapp.service;

import java.util.List;
import com.ty.hospitalapp.dao.impl.PersonDaoImpl;
import com.ty.hospitalapp.dto.Person;

public class PersonService {

	// Method to save a new person associated with an encounter
	public Person savePerson(int eid, Person person) {
		PersonDaoImpl daoImp = new PersonDaoImpl();
		Person person2 = daoImp.savePerson(eid, person);
		if (person2 != null) {
			System.out.println("Record Saved");
			return person2;
		} else {
			System.out.println("Record Not Saved");
			return null;
		}
	}

	// Method to get a person by their ID
	public Person getPersonById(int pid) {
		PersonDaoImpl daoImp = new PersonDaoImpl();
		Person person2 = daoImp.getPersonById(pid);
		if (person2 != null) {
			return person2;
		} else {
			return null;
		}
	}

	// Method to update an existing person by their ID
	public Person updatePersonById(int pid, Person person) {
		PersonDaoImpl daoImp = new PersonDaoImpl();
		Person person2 = daoImp.updatePersonById(pid, person);
		if (person2 != null) {
			return person2;
		} else {
			return null;
		}
	}

	// Method to delete a person by their ID
	public boolean deletePersonById(int pid) {
		PersonDaoImpl daoImp = new PersonDaoImpl();
		boolean flag = daoImp.deletePersonById(pid);
		if (flag) {
			System.out.println("Record Deleted Successfully");
			return true;
		} else {
			System.out.println("Record Not Deleted");
			return false;
		}
	}

	// Method to get a list of all persons
	public List<Person> getAllPerson() {
		PersonDaoImpl daoImp = new PersonDaoImpl();
		List<Person> persons = daoImp.getAllPerson();
		if (persons != null) {
			return persons;
		} else {
			return null;
		}
	}

	// Method to get a list of persons by gender
	public List<Person> getPersonByGender(String gender) {
		PersonDaoImpl daoImp = new PersonDaoImpl();
		List<Person> persons = daoImp.getPersonByGender(gender);
		if (persons != null) {
			return persons;
		} else {
			return null;
		}
	}

	// Method to get a list of persons by age
	public List<Person> getPersonByAge(int age) {
		PersonDaoImpl daoImp = new PersonDaoImpl();
		List<Person> persons = daoImp.getPersonByAge(age);
		if (persons != null) {
			return persons;
		} else {
			return null;
		}
	}

	// Method to get a list of persons by phone number
	public List<Person> getPersonByPhone(long phno) {
		PersonDaoImpl daoImp = new PersonDaoImpl();
		List<Person> persons = daoImp.getPersonByPhone(phno);
		if (persons != null) {
			return persons;
		} else {
			return null;
		}
	}
}
