package com.hex.upskillPolicy.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hex.upskillPolicy.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
    Optional<User> findByUsername(String username);
    
}