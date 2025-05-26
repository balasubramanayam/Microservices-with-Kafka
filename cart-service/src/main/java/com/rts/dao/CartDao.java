package com.rts.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.rts.model.Cart;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;


@Transactional
@Repository
public class CartDao {

		@PersistenceContext
		private EntityManager entityManager;

		public void insertCart(Cart cart) {
			entityManager.persist(cart);
		}
   

		public List<Cart> getAll() {
			Session currentSession = entityManager.unwrap(Session.class);
			Query<Cart> query = currentSession.createQuery("from Cart", Cart.class);
			List<Cart> list = query.getResultList();
			return list;
		}
		
		
		 public Cart checkProductInCart(int productId) {
		        // Use JPQL query to fetch cart by productId
		        Cart existingCart = entityManager
		                .createQuery("SELECT c FROM Cart c WHERE c.productId = :productId", Cart.class)
		                .setParameter("productId", productId)
		                .getResultStream() // Optional to return stream for flexibility
		                .findFirst()       // Retrieve first match if it exists
		                .orElse(null);     // Handle null case safely

		        if (existingCart != null) {
		            throw new IllegalStateException("Product is already in the cart.");
		        }
				return existingCart;
		    }
		 
		   
		 public Cart findById(int id) {
				Session currentSession = entityManager.unwrap(Session.class);
				Cart cart = currentSession.get(Cart.class, id);
				return cart;
			}



}
