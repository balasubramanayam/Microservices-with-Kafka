package com.rts.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.rts.model.Products;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ProductsDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void saveProductsWithImage( Products products) {
        entityManager.persist(products);  
    }
    
    public List<Products> getAllProducts() {
        return entityManager.createQuery("FROM Products", Products.class).getResultList();
    }
    
    
    public Products getImageById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Products> query = currentSession.createQuery("from Products where id=:id", Products.class);
        query.setParameter("id", id);   
        return query.getSingleResult();
    }  

}
