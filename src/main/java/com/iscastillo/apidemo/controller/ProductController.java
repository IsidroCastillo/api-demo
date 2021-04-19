package com.iscastillo.apidemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iscastillo.apidemo.entity.Product;
import com.iscastillo.apidemo.service.ProductService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/v1/products/")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping("findAll")
	public ResponseEntity<?> findAllProducts() {
		List<Product> listProduct = this.productService.findAllProducts();
		return ResponseEntity.ok(listProduct);
	}

	@PostMapping("save")
	public ResponseEntity<?> save(/* @Valid */ @RequestBody Product product, BindingResult result) {
		Product productSave = this.productService.insertProduct(product);
		return ResponseEntity.status(HttpStatus.CREATED).body(productSave);
	}

	@PutMapping("update")
	public ResponseEntity<?> update(/* @Valid */ @RequestBody Product product, BindingResult result) {
		Product productUpdate = this.productService.insertProduct(product);
		return ResponseEntity.status(HttpStatus.CREATED).body(productUpdate);
	}

	@DeleteMapping("delete/{productId}")
	public ResponseEntity<?> delete(@PathVariable Long productId) {
		this.productService.deleteProduct(productId);
		return ResponseEntity.ok().build();
	}
}
