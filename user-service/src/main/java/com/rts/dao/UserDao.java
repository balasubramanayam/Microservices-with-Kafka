package com.rts.dao;



import java.util.List;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.rts.model.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.NonUniqueResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class UserDao  {
	
	@PersistenceContext
	private EntityManager entityManager;

	public User add(User user) {
	    entityManager.persist(user); 
	    return user;
	}
 
	
	public List<User> findAllUsers() {
	    TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u", User.class);
	    return query.getResultList();
	}


	public User getById(int id) {
	    try {
	        TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u WHERE u.id = :id", User.class);
	        query.setParameter("id", id);
	        return query.getSingleResult();
	    } catch (NoResultException e) {
	        throw new IllegalStateException("No User found with ID: " + id, e);
	    } catch (NonUniqueResultException e) {
	        throw new IllegalStateException("More than one User found with ID: " + id, e);
	    }
	}



}
     