package com.hex.upskillPolicy.service;

import org.springframework.stereotype.Service;

import com.hex.upskillPolicy.dto.PolicyDto;
import com.hex.upskillPolicy.enums.PolicyType;
import com.hex.upskillPolicy.model.Company;
import com.hex.upskillPolicy.model.Policy;
import com.hex.upskillPolicy.repository.CompanyRepository;
import com.hex.upskillPolicy.repository.PolicyRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PolicyService {

    private final PolicyRepository policyRepository;
    private final CompanyRepository companyRepository; // Inject repo instead of service

    public Policy addPolicy(PolicyDto dto, long companyId) {
        Company company = companyRepository.findById(companyId)
                .orElseThrow(() -> new RuntimeException("Company Id Invalid"));

        Policy policy = new Policy();
        policy.setTitle(dto.title());
        policy.setPremium(dto.premium());
        policy.setTenure(dto.tenure());
        policy.setType(PolicyType.valueOf(dto.type()));
        policy.setCompany(company);

        return policyRepository.save(policy);
    }
    
    public Policy getById(long id) {
        return policyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Policy Id Invalid"));
    }
}
