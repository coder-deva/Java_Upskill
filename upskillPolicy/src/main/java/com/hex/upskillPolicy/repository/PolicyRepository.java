package com.hex.upskillPolicy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hex.upskillPolicy.model.Policy;

public interface PolicyRepository extends JpaRepository<Policy, Long> {
	
}