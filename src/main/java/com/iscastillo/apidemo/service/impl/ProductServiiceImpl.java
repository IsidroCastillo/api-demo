package com.iscastillo.apidemo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iscastillo.apidemo.entity.Product;
import com.iscastillo.apidemo.repository.ProductRepository;
import com.iscastillo.apidemo.service.ProductService;

@Service
public class ProductServiiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> findAllProducts() {
		return this.productRepository.findAll();
	}

	@Override
	public Product findById(Long productId) {
		return this.productRepository.findById(productId).orElse(null);
	}

	@Override
	public Product insertProduct(Product product) {
		return this.productRepository.save(product);
	}

	@Override
	public Product updateProduct(Product product) {
		return this.productRepository.save(product);
	}

	@Override
	public void deleteProduct(Long productId) {
		this.productRepository.deleteById(productId);
	}

}
