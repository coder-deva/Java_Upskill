package com.hex.upskillPolicy.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hex.upskillPolicy.dto.PolicyDto;
import com.hex.upskillPolicy.model.Policy;
import com.hex.upskillPolicy.service.PolicyService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/policy")
@AllArgsConstructor
public class PolicyController {

    private final PolicyService policyService;

    @PostMapping("/add/{companyId}")
    public ResponseEntity<?> addPolicy(@RequestBody PolicyDto dto, @PathVariable long companyId) {
        policyService.addPolicy(dto, companyId);
        return ResponseEntity.created(URI.create(""))
        		             .body("Policy Added Successfully");
    }
}