package com.hex.trs.service;

import com.hex.trs.exception.InvalidIdException;
import com.hex.trs.model.Customer;
import com.hex.trs.repository.CustomerRepository;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService {
	
	@Autowired
    private CustomerRepository customerRepository;
	
	

    public Customer getById(long customerId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(()-> new InvalidIdException("Customer Id Invalid"));
        return customer;
    }
}