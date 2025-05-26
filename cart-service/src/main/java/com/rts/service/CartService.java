package com.rts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rts.client.ProductClient;
import com.rts.client.UserClient;
import com.rts.dao.CartDao;
import com.rts.model.Cart;
import com.rts.model.Products;
import com.rts.model.User;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class CartService {
    
 
	@Autowired
    private UserClient userClient;
    
	@Autowired
    private ProductClient productClient;
    
	@Autowired 
    private CartDao cartDao; 
    

	public void addToCart(Cart cartRequest) {
        // Validate userId and productId
        Integer userId = cartRequest.getUserId();
        Integer productId = cartRequest.getProductId();
        
        if (userId == null || productId == null) {
            throw new IllegalArgumentException("UserId or ProductId is null in the cart request.");
        }

        // Fetch user and product details
        User user = userClient.getUserById(userId); 
        if (user == null) {   
            throw new IllegalArgumentException("User with ID " + userId + " not found.");
        }

        Products product = productClient.getProductById(productId);
        if (product == null) {
            throw new IllegalArgumentException("Product with ID " + productId + " not found.");
        }

        // Check if the product is already in the cart
        Cart existingCart = cartDao.checkProductInCart(productId);
        if (existingCart != null) {
            throw new IllegalStateException("Product is already in the cart.");
        }

        // Create and save the cart
        int quantity = cartRequest.getQuantity();
        double totalPrice = product.price() * quantity;

        Cart cart = new Cart();
        cart.setUserId(user.id());
        cart.setProductId(product.productId());
        cart.setQuantity(quantity);
        cart.setTotalPrice((int) totalPrice); 
        cart.setTotalGifts(quantity); 

        cartDao.insertCart(cart);
    }
	
	
	public Cart getById(int id) {

		return cartDao.findById(id);
	}
	
	public List<Cart> getAll() {
		return cartDao.getAll();
	}

}
