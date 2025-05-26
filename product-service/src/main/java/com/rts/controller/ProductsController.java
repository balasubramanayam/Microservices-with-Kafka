package com.rts.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.rts.model.Products;
import com.rts.service.ProductsService;

@RestController
@RequestMapping("/api/products")
public class ProductsController {
	
	@Autowired
	private ProductsService productsService;
	
	
	@PostMapping
	public ResponseEntity<Map<String, Object>> uploadWithImage(
	        @RequestParam("name") String name,
	        @RequestParam("price") int price,
	        @RequestParam("description") String description,
	        @RequestParam("stockAvailable") String stockAvailable,
	        @RequestParam("image") MultipartFile imageFile) {
	    Map<String, Object> response = new HashMap<>();
	    try {
	        productsService.saveProductsWithImage(name, price, description, stockAvailable, imageFile);
	        response.put("status", "success");
	        response.put("message", "Uploaded successfully!");
	        return ResponseEntity.ok(response);
	    } catch (IOException e) {
	        response.put("status", "error");
	        response.put("message", "An error occurred while uploading");
	        return ResponseEntity.internalServerError().body(response);
	    }
	}


	@GetMapping()
	public List<Products> getAll() {
	        List<Products> list = productsService.getAllProducts();
	        return list;
	   
	}
	
	 @GetMapping("/{id}")
	    public ResponseEntity<?> getImageById(@PathVariable int id) {
	        try {
	        	Products gift = productsService.getImageById(id);
	            if (gift != null) {
	                return ResponseEntity.ok(gift);
	            } else {
	                return ResponseEntity.notFound().build();   
	            }
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	        }
	    }


}
