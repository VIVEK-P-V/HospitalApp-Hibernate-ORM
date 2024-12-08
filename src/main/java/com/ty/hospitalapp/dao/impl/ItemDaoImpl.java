package com.ty.hospitalapp.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospitalapp.dao.ItemDao;
import com.ty.hospitalapp.dto.Item;
import com.ty.hospitalapp.dto.MedOrder;

public class ItemDaoImpl implements ItemDao {

	// Setting up EntityManagerFactory and EntityManager
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("joker");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	@Override
	public Item saveItem(int mid, Item item) {
		// Finding MedOrder by ID
		MedOrder medOrder = entityManager.find(MedOrder.class, mid);
		if (medOrder != null) {
			// Begin transaction and persist Item
			entityTransaction.begin();
			entityManager.persist(item);
			entityTransaction.commit();
			return item;
		} else {
			return null;
		}
	}

	@Override
	public Item getItemById(int id) {
		// Finding Item by ID
		Item item = entityManager.find(Item.class, id);
		return (item != null) ? item : null;
	}

	@Override
	public Item updateItemById(int id, Item item) {
		// Finding existing Item by ID
		Item item1 = entityManager.find(Item.class, id);
		if (item1 != null) {
			// Updating fields with values from the provided Item object
			item1.setItemName(item.getItemName());
			item1.setCost(item.getCost());
			item1.setQuantity(item.getQuantity());
			// Begin transaction and merge updates
			entityTransaction.begin();
			entityManager.merge(item1);
			entityTransaction.commit();
			return item1;
		} else {
			return null;
		}
	}

	@Override
	public boolean deleteItemById(int id) {
		// Finding Item by ID
		Item item1 = entityManager.find(Item.class, id);
		if (item1 != null) {
			// Begin transaction and remove Item
			entityTransaction.begin();
			entityManager.remove(item1);
			entityTransaction.commit();
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<Item> getAllItem() {
		// Query to get all Items
		Query query = entityManager.createQuery("select s from Item s");
		@SuppressWarnings("unchecked")
		List<Item> item = query.getResultList();
		return item;
	}
}
