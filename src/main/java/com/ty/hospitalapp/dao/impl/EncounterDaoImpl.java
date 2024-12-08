package com.ty.hospitalapp.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospitalapp.dao.EncounterDao;
import com.ty.hospitalapp.dto.Branch;
import com.ty.hospitalapp.dto.Encounter;

public class EncounterDaoImpl implements EncounterDao {

	// Setting up EntityManagerFactory and EntityManager
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("joker");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	@Override
	public Encounter saveEncounter(int bid, Encounter encounter) {
		// Finding Branch by ID
		Branch branch = entityManager.find(Branch.class, bid);
		if (branch != null) {
			// Begin transaction and persist Encounter
			entityTransaction.begin();
			entityManager.persist(encounter);
			entityTransaction.commit();
			return encounter;
		} else {
			return null;
		}
	}

	@Override
	public Encounter getEncounterById(int eid) {
		// Finding Encounter by ID
		Encounter encounter = entityManager.find(Encounter.class, eid);
		if (encounter != null) {
			return encounter;
		} else {
			return null;
		}
	}

	@Override
	public Encounter updateEncounterById(int eid, Encounter encounter) {
		// Finding existing Encounter by ID
		Encounter encounter1 = entityManager.find(Encounter.class, eid);
		if (encounter1 != null) {
			// Updating fields with values from the provided Encounter object
			encounter1.setReason(encounter.getReason());
			encounter1.setDateOfJoin(encounter.getDateOfJoin());
			encounter1.setDischarge(encounter.getDischarge());
			// Begin transaction and merge updates
			entityTransaction.begin();
			entityManager.merge(encounter1);
			entityTransaction.commit();
			return encounter1;
		} else {
			return null;
		}
	}

	@Override
	public boolean deleteEncounterById(int eid) {
		// Finding Encounter by ID
		Encounter encounter1 = entityManager.find(Encounter.class, eid);
		if (encounter1 != null) {
			// Begin transaction and remove Encounter
			entityTransaction.begin();
			entityManager.remove(encounter1);
			entityTransaction.commit();
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<Encounter> getAllEncounter() {
		// Query to get all Encounters
		Query query = entityManager.createQuery("select e from Encounter e");
		@SuppressWarnings("unchecked")
		List<Encounter> encounters = query.getResultList();
		return encounters;
	}
}
