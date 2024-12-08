package com.ty.hospitalapp.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospitalapp.dao.PersonDao;
import com.ty.hospitalapp.dto.Encounter;
import com.ty.hospitalapp.dto.Person;

public class PersonDaoImpl implements PersonDao {

	// Setting up EntityManagerFactory and EntityManager
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("joker");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	@Override
	public Person savePerson(int eid, Person person) {
		// Finding Encounter by ID
		Encounter encounter = entityManager.find(Encounter.class, eid);
		if (encounter != null) {
			// Begin transaction and persist Person
			entityTransaction.begin();
			person.setEncounter(encounter);
			entityManager.persist(person);
			entityTransaction.commit();
			return person;
		} else {
			return null;
		}
	}

	@Override
	public Person getPersonById(int pid) {
		// Finding Person by ID
		Person person = entityManager.find(Person.class, pid);
		if (person != null) {
			return person;
		} else {
			return null;
		}
	}

	@Override
	public Person updatePersonById(int pid, Person person) {
		// Finding Person by ID
		Person person1 = entityManager.find(Person.class, pid);
		if (person1 != null) {
			// Updating fields with values from the provided Person object
			person1.setName(person.getName());
			person1.setAge(person.getAge());
			person1.setGender(person.getGender());
			person1.setDob(person.getDob());
			person1.setEmail(person.getEmail());
			// Begin transaction and merge updates
			entityTransaction.begin();
			entityManager.merge(person1);
			entityTransaction.commit();
			return person1;
		} else {
			return null;
		}
	}

	@Override
	public boolean deletePersonById(int pid) {
		// Finding Person by ID
		Person person = entityManager.find(Person.class, pid);
		if (person != null) {
			// Begin transaction and remove Person
			entityTransaction.begin();
			entityManager.remove(person);
			entityTransaction.commit();
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<Person> getAllPerson() {
		// Query to get all Persons
		Query query = entityManager.createQuery("SELECT p FROM Person p");
		@SuppressWarnings("unchecked")
		List<Person> persons = query.getResultList();
		return persons;
	}

	@Override
	public List<Person> getPersonByGender(String gender) {
		// Query to get Persons by gender
		Query query = entityManager.createQuery("SELECT p FROM Person p WHERE p.gender = ?1");
		query.setParameter(1, gender);
		@SuppressWarnings("unchecked")
		List<Person> persons = query.getResultList();
		return persons;
	}

	@Override
	public List<Person> getPersonByAge(int age) {
		// Query to get Persons by age
		Query query = entityManager.createQuery("SELECT p FROM Person p WHERE p.age = ?1");
		query.setParameter(1, age);
		@SuppressWarnings("unchecked")
		List<Person> persons = query.getResultList();
		return persons;
	}

	@Override
	public List<Person> getPersonByPhone(long phno) {
		// Query to get Persons by phone number
		Query query = entityManager.createQuery("SELECT p FROM Person p WHERE p.phno = ?1");
		query.setParameter(1, phno);
		@SuppressWarnings("unchecked")
		List<Person> persons = query.getResultList();
		return persons;
	}

}