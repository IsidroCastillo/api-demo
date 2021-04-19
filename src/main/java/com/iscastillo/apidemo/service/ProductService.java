package com.iscastillo.apidemo.service;

import java.util.List;

import com.iscastillo.apidemo.entity.Product;

public interface ProductService {

	List<Product> findAllProducts();

	Product findById(Long productId);

	Product insertProduct(Product product);

	Product updateProduct(Product product);

	void deleteProduct(Long productId);

}
