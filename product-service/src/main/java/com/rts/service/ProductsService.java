package com.rts.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.rts.dao.ProductsDao;
import com.rts.model.Products;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductsService {
	
	@Autowired
	private ProductsDao productsDao;
	
	
	public void saveProductsWithImage(String name, int price, String description,String stockAvailable, MultipartFile imageFile)
			throws IOException {
		Products gift = new Products();
		gift.setName(name);
		gift.setPrice(price);
		gift.setDescription(description);
		gift.setImage(imageFile.getBytes());
		gift.setStockAvailable(stockAvailable);

		productsDao.saveProductsWithImage(gift);
	}

	public List<Products> getAllProducts() {
		return productsDao.getAllProducts();
	}
	
	
	public Products getImageById(int id) {
		return productsDao.getImageById(id);
	}

}
