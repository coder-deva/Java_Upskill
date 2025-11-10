package com.hex.upskillPolicy.service;

import org.springframework.stereotype.Service;

import com.hex.upskillPolicy.dto.CustomerPolicyDto;
import com.hex.upskillPolicy.model.Customer;
import com.hex.upskillPolicy.model.CustomerPolicy;
import com.hex.upskillPolicy.model.Policy;
import com.hex.upskillPolicy.repository.CustomerPolicyRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomerPolicyService {

    private final CustomerService customerService;
    private final PolicyService policyService;
    private final CustomerPolicyRepository repository;

    public CustomerPolicy purchasePolicy(CustomerPolicyDto dto) {
        Customer customer = customerService.getById(dto.customerId());
        Policy policy = policyService.getById(dto.policyId());

        CustomerPolicy cp = new CustomerPolicy();
        cp.setCustomer(customer);
        cp.setPolicy(policy);
        cp.setDateOfIssue(dto.dateOfIssue());
        cp.setDateOfExpiry(dto.dateOfExpiry());

        return repository.save(cp);
    }
}

