package com.iscastillo.apidemo.service;

import java.util.List;

import com.iscastillo.apidemo.entity.Customer;

public interface CustomerService {

	List<Customer> findAll();
	
	Customer findById(Long customerId);
	
	Customer save(Customer customer);
	
	void delete(Customer customer);
	
}
