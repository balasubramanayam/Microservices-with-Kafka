package com.rts.model;

public record Products(
	    int productId,
	    String name,
	    String description,
	    double price,
	    String stockAvailable,
	    byte[] image
	) {}
