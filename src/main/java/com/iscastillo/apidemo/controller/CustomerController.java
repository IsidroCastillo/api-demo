package com.iscastillo.apidemo.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.iscastillo.apidemo.entity.Customer;
import com.iscastillo.apidemo.service.CustomerService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping
//	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public List<Customer> findAllCustomers(){
		return customerService.findAll();
	}
	
	@GetMapping("/{customerId}")
//	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public Customer findById(@PathVariable("customerId")Long customerId) {
		return customerService.findById(customerId);
	}
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public Customer create(@RequestBody Customer customer) {
		customer.setCreatedAt(LocalDate.now());
		this.customerService.save(customer);
		return customer;
	}
	
	@PutMapping("/{customerId}")
	@ResponseStatus(HttpStatus.CREATED)
	public Customer update(@RequestBody Customer customer, @PathVariable("customerId") Long customerId) {
		Customer currentCustomer= this.customerService.findById(customerId);
		currentCustomer.setNames(customer.getNames());
		currentCustomer.setFirstLastName(customer.getFirstLastName());
		currentCustomer.setSecondLastName(customer.getSecondLastName());
		currentCustomer.setEmail(customer.getEmail());
		currentCustomer.setBirthDate(customer.getBirthDate());
		this.customerService.save(currentCustomer);
		return currentCustomer;
	}
	
	@DeleteMapping("/{customerId}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("customerId") Long customerId) {
		Customer currentCliente = this.customerService.findById(customerId);
		this.customerService.delete(currentCliente);
	}
}
