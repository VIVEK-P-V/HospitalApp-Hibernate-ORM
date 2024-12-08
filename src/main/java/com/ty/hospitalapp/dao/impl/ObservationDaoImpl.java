package com.ty.hospitalapp.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospitalapp.dao.ObservationDao;
import com.ty.hospitalapp.dto.Encounter;
import com.ty.hospitalapp.dto.Observation;

public class ObservationDaoImpl implements ObservationDao {

	// Setting up EntityManagerFactory and EntityManager
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("joker");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	@Override
	public Observation saveObservation(int eid, Observation observation) {
		// Finding Encounter by ID
		Encounter encounter = entityManager.find(Encounter.class, eid);
		if (encounter != null) {
			// Begin transaction and persist Observation
			entityTransaction.begin();			
			entityManager.persist(observation);
			entityTransaction.commit();
			return observation;
		} else {
			return null;
		}
	}

	@Override
	public Observation getObservationById(int oid) {
		// Finding Observation by ID
		Observation observation = entityManager.find(Observation.class, oid);
		if (observation != null) {
			return observation;
		} else {
			return null;
		}
	}

	@Override
	public Observation updateObservationById(int oid, Observation observation) {
		// Finding existing Observation by ID
		Observation observation1 = entityManager.find(Observation.class, oid);
		if (observation1 != null) {
			// Updating fields with values from the provided Observation object
			observation1.setDname(observation.getDname());
			observation1.setrObservation(observation.getrObservation());
			// Begin transaction and merge updates
			entityTransaction.begin();
			entityManager.merge(observation1);
			entityTransaction.commit();
			return observation1;
		} else {
			return null;
		}
	}

	@Override
	public boolean deleteObservationById(int oid) {
		// Finding Observation by ID
		Observation observation = entityManager.find(Observation.class, oid);
		if (observation != null) {
			// Begin transaction and remove Observation
			entityTransaction.begin();
			entityManager.remove(observation);
			entityTransaction.commit();
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<Observation> getAllObservationByDoctorName(String dname) {
		// Query to get all Observations by doctor name
		Query query = entityManager.createQuery("SELECT s FROM Observation s WHERE s.dname = ?1");
		query.setParameter(1, dname);
		@SuppressWarnings("unchecked")
		List<Observation> observations = query.getResultList();
		return observations;
	}

}
