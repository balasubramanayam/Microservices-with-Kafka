package com.rts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rts.model.Order;
import com.rts.service.OrderService;

@RestController
@RequestMapping("/api/orders/")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@PostMapping("/add")
	public ResponseEntity<String> addToOrder(@RequestBody Order orderRequest) { 
		try {
			orderService.addToOrder(orderRequest);
			return ResponseEntity.ok("Order added successfully: " + orderRequest);
		} catch (IllegalArgumentException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/list")  
	public List<Order> getAllOrders() {
		return orderService.getAllOrders();
	}

}
