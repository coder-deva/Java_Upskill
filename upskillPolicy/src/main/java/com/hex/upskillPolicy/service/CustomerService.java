package com.hex.upskillPolicy.service;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hex.upskillPolicy.dto.CustomerDto;
import com.hex.upskillPolicy.enums.Role;
import com.hex.upskillPolicy.model.Customer;
import com.hex.upskillPolicy.model.User;
import com.hex.upskillPolicy.repository.CustomerRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public void signUp(CustomerDto dto) {
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] decodedBytes = decoder.decode(dto.authcode());
        String clearText = new String(decodedBytes, StandardCharsets.UTF_8);

        String username = clearText.split(":")[0];
        String password = clearText.split(":")[1];

        userService.checkUniqueness(username);
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setRole(Role.CUSTOMER);

        user = userService.save(user);

        Customer customer = new Customer();
        customer.setName(dto.name());
        customer.setAge(dto.age());
        customer.setUser(user);

        customerRepository.save(customer);
    }

    public Customer getById(long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Invalid Customer Id"));
    }
}
