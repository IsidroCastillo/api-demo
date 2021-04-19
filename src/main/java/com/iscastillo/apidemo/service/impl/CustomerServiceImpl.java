package com.iscastillo.apidemo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iscastillo.apidemo.entity.Customer;
import com.iscastillo.apidemo.repository.CustomerRepository;
import com.iscastillo.apidemo.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public List<Customer> findAll() {
		return (List<Customer>) customerRepository.findAll();
	}

	@Override
	public Customer findById(Long customerId) {
		return customerRepository.findById(customerId).orElse(null);
	}

	@Override
	public Customer save(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public void delete(Customer customer) {
		customerRepository.delete(customer);
	}

}
