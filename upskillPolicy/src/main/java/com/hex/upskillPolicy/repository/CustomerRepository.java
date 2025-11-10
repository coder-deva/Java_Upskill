package com.hex.upskillPolicy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hex.upskillPolicy.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
}
