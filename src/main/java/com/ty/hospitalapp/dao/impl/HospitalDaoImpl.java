package com.ty.hospitalapp.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospitalapp.dao.HospitalDao;
import com.ty.hospitalapp.dto.Hospital;

public class HospitalDaoImpl implements HospitalDao {

	// Setting up EntityManagerFactory and EntityManager
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("joker");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	@Override
	public Hospital saveHospital(Hospital hospital) {
		// Begin transaction and persist Hospital
		entityTransaction.begin();
		entityManager.persist(hospital);
		entityTransaction.commit();
		return hospital;
	}

	@Override
	public Hospital getHospitalById(int hid) {
		// Finding Hospital by ID
		Hospital hospital = entityManager.find(Hospital.class, hid);
		return (hospital != null) ? hospital : null;
	}

	@Override
	public Hospital updateHospitalById(int hid, Hospital hospital) {
		// Finding existing Hospital by ID
		Hospital hospital1 = entityManager.find(Hospital.class, hid);
		if (hospital1 != null) {
			// Updating fields with values from the provided Hospital object
			hospital1.setName(hospital.getName());
			hospital1.setWebsite(hospital.getWebsite());
			// Begin transaction and merge updates
			entityTransaction.begin();
			entityManager.merge(hospital1);
			entityTransaction.commit();
			return hospital1;
		} else {
			return null;
		}
	}

	@Override
	public boolean deleteHospital(int hid) {
		// Finding Hospital by ID
		Hospital hospital = entityManager.find(Hospital.class, hid);
		if (hospital != null) {
			// Begin transaction and remove Hospital
			entityTransaction.begin();
			entityManager.remove(hospital);
			entityTransaction.commit();
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<Hospital> getAllHospital() {
		// Query to get all Hospitals
		Query query = entityManager.createQuery("select s from Hospital s");
		@SuppressWarnings("unchecked")
		List<Hospital> hospital = query.getResultList();
		return hospital;
	}
}
