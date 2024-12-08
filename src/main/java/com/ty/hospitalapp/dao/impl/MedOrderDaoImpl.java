package com.ty.hospitalapp.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospitalapp.dao.MedOrderDao;
import com.ty.hospitalapp.dto.Encounter;
import com.ty.hospitalapp.dto.MedOrder;

public class MedOrderDaoImpl implements MedOrderDao {

	// Setting up EntityManagerFactory and EntityManager
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("joker");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	@Override
	public MedOrder saveMedOrder(int eid, MedOrder medOrder) {
		// Finding Encounter by ID
		Encounter encounter = entityManager.find(Encounter.class, eid);
		if (encounter != null) {
			// Begin transaction and persist MedOrder
			entityTransaction.begin();
			entityManager.persist(medOrder);
			entityTransaction.commit();
			return medOrder;
		} else {
			return null;
		}
	}

	@Override
	public MedOrder getMedOrderById(int mid) {
		// Finding MedOrder by ID
		MedOrder medOrder = entityManager.find(MedOrder.class, mid);
		return (medOrder != null) ? medOrder : null;
	}

	@Override
	public MedOrder updateMedOrderById(int mid, MedOrder medOrder) {
		// Finding existing MedOrder by ID
		MedOrder medOrder1 = entityManager.find(MedOrder.class, mid);
		if (medOrder1 != null) {
			// Updating fields with values from the provided MedOrder object
			medOrder1.setDname(medOrder.getDname());
			medOrder1.setOrderDate(medOrder.getOrderDate());
			// Begin transaction and merge updates
			entityTransaction.begin();
			entityManager.merge(medOrder1);
			entityTransaction.commit();
			return medOrder1;
		}
		return null;
	}

	@Override
	public boolean deleteMedOrderById(int mid) {
		// Finding MedOrder by ID
		MedOrder medOrder1 = entityManager.find(MedOrder.class, mid);
		if (medOrder1 != null) {
			// Begin transaction and remove MedOrder
			entityTransaction.begin();
			entityManager.remove(medOrder1);
			entityTransaction.commit();
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<MedOrder> getAllMedOrder() {
		// Query to get all MedOrders
		Query query = entityManager.createQuery("select s from MedOrder s");
		@SuppressWarnings("unchecked")
		List<MedOrder> medOrder = query.getResultList();
		return medOrder;
	}

	@Override
	public List<MedOrder> getMedOrderByDoctorName(String dname) {
		// Query to get MedOrders by doctor name
		Query query = entityManager.createQuery("SELECT s FROM MedOrder s WHERE s.dname = ?1");
		query.setParameter(1, dname);
		@SuppressWarnings("unchecked")
		List<MedOrder> medOrder = query.getResultList();
		return medOrder;
	}
}
