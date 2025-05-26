package com.rts.dao;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.rts.model.Order;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class OrderDao {

	@PersistenceContext
	private EntityManager entityManager;

	public void insertOrder(Order order) {
		entityManager.persist(order);
	}
	
	public List<Order> getAllOrders() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Order> query = currentSession.createQuery("from Order", Order.class);
		List<Order> list = query.getResultList();
		return list;
	}

	


}