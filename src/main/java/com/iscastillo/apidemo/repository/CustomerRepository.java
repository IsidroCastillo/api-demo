package com.iscastillo.apidemo.repository;

import org.springframework.data.repository.CrudRepository;

import com.iscastillo.apidemo.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
