package com.hex.upskillEcom;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class UpskillEcomApplication {

	public static void main(String[] args) {
		SpringApplication.run(UpskillEcomApplication.class, args);
	}

}
