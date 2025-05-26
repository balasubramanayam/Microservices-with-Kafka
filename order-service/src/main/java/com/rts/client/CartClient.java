package com.rts.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.rts.model.Cart;

@FeignClient(name = "cart-service")
public interface CartClient {
	@GetMapping("/api/cart/list/{id}")
	Cart findCartId(@PathVariable("id") Integer id);   
}
   