package com.hex.upskillPolicy.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hex.upskillPolicy.dto.CustomerPolicyDto;
import com.hex.upskillPolicy.service.CustomerPolicyService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/customer-policy")
@AllArgsConstructor
public class CustomerPolicyController {

    private final CustomerPolicyService customerPolicyService;

    @PostMapping("/purchase")
    public ResponseEntity<?> purchasePolicy(@RequestBody CustomerPolicyDto dto) {
        customerPolicyService.purchasePolicy(dto);
        return ResponseEntity.created(URI.create(""))
        		        	 .body("Policy Purchased Successfully");
    }
}