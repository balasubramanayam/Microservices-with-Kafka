package com.rts.model;

import java.time.LocalDateTime;

public record Order(int id,
	String status,
	LocalDateTime orderDate,
	int cartId) {
}
