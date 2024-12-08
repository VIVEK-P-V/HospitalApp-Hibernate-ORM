package com.ty.hospitalapp.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospitalapp.dao.UserDao;
import com.ty.hospitalapp.dto.User;

public class UserDaoImpl implements UserDao {

	// Setting up EntityManagerFactory and EntityManager
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("joker");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	@Override
	public User saveUser(User user) {
		// Begin transaction and persist User
		entityTransaction.begin();
		entityManager.persist(user);
		entityTransaction.commit();
		return user;
	}

	@Override
	public User getUser(int uid) {
		// Finding User by ID
		User user = entityManager.find(User.class, uid);
		if (user != null) {
			return user;
		} else {
			return null;
		}
	}

	@Override
	public User updateUser(int uid, User user) {
		// Finding existing User by ID
		User user1 = entityManager.find(User.class, uid);
		if (user1 != null) {
			// Updating fields with values from the provided User object
			user1.setName(user.getName());
			user1.setEmail(user.getEmail());
			user1.setPhno(user.getPhno());
			user1.setPass(user.getPass());
			user1.setRole(user.getRole());
			// Begin transaction and merge updates
			entityTransaction.begin();
			entityManager.merge(user1);
			entityTransaction.commit();
			return user1;
		} else {
			return null;
		}
	}

	@Override
	public boolean deleteUserById(int uid) {
		// Finding User by ID
		User user = entityManager.find(User.class, uid);
		if (user != null) {
			// Begin transaction and remove User
			entityTransaction.begin();
			entityManager.remove(user);
			entityTransaction.commit();
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<User> getAllUser() {
		// Query to get all Users
		Query query = entityManager.createQuery("SELECT u FROM User u");
		@SuppressWarnings("unchecked")
		List<User> users = query.getResultList();
		return users;
	}

	@Override
	public List<User> getAllUserByRole(String role) {
		// Query to get Users by role
		Query query = entityManager.createQuery("SELECT u FROM User u WHERE u.role = ?1");
		query.setParameter(1, role);
		@SuppressWarnings("unchecked")
		List<User> users = query.getResultList();
		return users;
	}
}
