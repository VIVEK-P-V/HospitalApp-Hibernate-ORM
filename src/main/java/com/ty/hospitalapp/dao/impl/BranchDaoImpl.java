package com.ty.hospitalapp.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospitalapp.dao.BranchDao;
import com.ty.hospitalapp.dto.Branch;
import com.ty.hospitalapp.dto.Hospital;

public class BranchDaoImpl implements BranchDao {

	// Setting up EntityManagerFactory and EntityManager
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("joker");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	@Override
	public Branch saveBranch(int hid, Branch branch) {
		// Finding Hospital by ID
		Hospital hospital = entityManager.find(Hospital.class, hid);
		if (hospital != null) {
			// Begin transaction and persist Branch
			entityTransaction.begin();
			entityManager.persist(branch);
			entityTransaction.commit();
			return branch;
		} else {
			return null;
		}
	}

	@Override
	public Branch getBranchById(int bid) {
		// Finding Branch by ID
		Branch branch = entityManager.find(Branch.class, bid);
		return (branch != null) ? branch : null;
	}

	@Override
	public Branch updateBranchById(int bid, Branch branch) {
		// Finding existing Branch by ID
		Branch branch1 = entityManager.find(Branch.class, bid);
		if (branch1 != null) {
			// Updating fields with values from the provided Branch object
			branch1.setName(branch.getName());
			branch1.setPhno(branch.getPhno());
			branch1.setEmail(branch.getEmail());
			// Begin transaction and merge updates
			entityTransaction.begin();
			entityManager.merge(branch1);
			entityTransaction.commit();
			return branch1;
		} else {
			return null;
		}
	}

	@Override
	public boolean deleteBranch(int bid) {
		// Finding Branch by ID
		Branch branch1 = entityManager.find(Branch.class, bid);
		if (branch1 != null) {
			// Begin transaction and remove Branch
			entityTransaction.begin();
			entityManager.remove(branch1);
			entityTransaction.commit();
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<Branch> getAllBranch() {
		// Query to get all Branches
		Query query = entityManager.createQuery("select s from Branch s");
		@SuppressWarnings("unchecked")
		List<Branch> branch = query.getResultList();
		return branch;
	}
}
