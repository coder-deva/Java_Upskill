package com.hex.upskillEcom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hex.upskillEcom.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
