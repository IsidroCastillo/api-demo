package com.iscastillo.apidemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iscastillo.apidemo.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
