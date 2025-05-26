package com.rts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rts.model.Cart;
import com.rts.service.CartService;

@RestController
@RequestMapping("/api/cart/")
public class CartController {
	
	@Autowired   
	private CartService cartService;
	
	@PostMapping("/add")  
	public ResponseEntity<String> insertCart(@RequestBody Cart cart) {
		    cartService.addToCart(cart);
			return ResponseEntity.ok("added");
		}
	
	
	@GetMapping("/list")  
	public List<Cart> findAllCart() {
		return cartService.getAll();
	}
	
	@GetMapping("/list/{id}")  
	public Cart findCartId(@PathVariable int id) {
		return cartService.getById(id);
	}
	   
	
	
	
	
  
}
