package com.ty.hospitalapp.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospitalapp.dao.AddressDao;
import com.ty.hospitalapp.dto.Address;
import com.ty.hospitalapp.dto.Branch;

public class AddressDaoImpl implements AddressDao {

	// Setting up EntityManagerFactory and EntityManager
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("joker");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	@Override
	public Address saveAddress(int bid, Address address) {
		// Finding Branch by ID
		Branch branch = entityManager.find(Branch.class, bid);
		if (branch != null) {
			// Begin transaction and persist Address
			entityTransaction.begin();
			entityManager.persist(address);
			entityTransaction.commit();
			return address;
		} else {
			return null;
		}
	}

	@Override
	public Address getAddressById(int aid) {
		// Finding Address by ID
		Address address = entityManager.find(Address.class, aid);
		return (address != null) ? address : null;
	}

	@Override
	public Address updateAddressById(int aid, Address address) {
		// Finding existing Address by ID
		Address address1 = entityManager.find(Address.class, aid);
		if (address1 != null) {
			// Updating fields with values from the provided Address object
			address1.setStreet(address.getStreet());
			address1.setCountry(address.getCountry());
			address1.setPin(address.getPin());
			// Begin transaction and merge updates
			entityTransaction.begin();
			entityManager.merge(address1);
			entityTransaction.commit();
			return address1;
		} else {
			return null;
		}
	}

	@Override
	public boolean deleteAddressById(int aid) {
		// Finding Address by ID
		Address address1 = entityManager.find(Address.class, aid);
		if (address1 != null) {
			// Begin transaction and remove Address
			entityTransaction.begin();
			entityManager.remove(address1);
			entityTransaction.commit();
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<Address> getAllAddress() {
		// Query to get all Addresses
		Query query = entityManager.createQuery("select s from Address s");
		@SuppressWarnings("unchecked")
		List<Address> address = query.getResultList();
		return address;
	}
}
