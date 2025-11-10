package com.hex.upskillPolicy.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hex.upskillPolicy.dto.CustomerDto;
import com.hex.upskillPolicy.service.CustomerService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/customer")
@AllArgsConstructor
public class CustomerController {

	private final CustomerService customerService;

	@PostMapping("/sign-up")
	public ResponseEntity<?> signUp(@RequestBody CustomerDto dto) {
		customerService.signUp(dto);
		return ResponseEntity.created(URI.create(""))
				             .body("Customer SignUp Success");
	}
}
