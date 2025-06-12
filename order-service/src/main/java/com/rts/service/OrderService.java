package com.rts.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.rts.client.CartClient;
import com.rts.dao.OrderDao;
import com.rts.model.Cart;
import com.rts.model.Order;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class OrderService {

	@Autowired
	private CartClient cartClient;

	@Autowired
	private OrderDao orderDao;
	
	//bin\windows>zookeeper-server-start.bat C:\kafka\kafka\config\zookeeper.properties
	//bin\windows\kafka-server-start.bat C:\kafka\kafka\config\server.properties
	
	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;

	@SuppressWarnings("unused")
	public void addToOrder(Order orderRequest) {

	
	    Integer cartId = orderRequest.getCartId();
	    if (cartId == null) {
	        throw new IllegalArgumentException("CartId is null.");
	    }

	
	    Cart cart = cartClient.findCartId(cartId); 
	    System.out.println(cart.cartId());  
	    if (cart == null) {
	        throw new IllegalArgumentException("Cart not found for CartId: " + cartId);
	    }   

	 
	    Order order = new Order();
	    order.setCartId(cart.cartId()); 
	    order.setOrderDate(orderRequest.getOrderDate());
	    order.setStatus(orderRequest.getStatus());

	    
	    orderDao.insertOrder(order);
	    kafkaTemplate.send("order-topic", order);
	    System.out.println("Produce order:: "+ order); 
	}


	public List<Order> getAllOrders() {
		return orderDao.getAllOrders();
	}   
}
