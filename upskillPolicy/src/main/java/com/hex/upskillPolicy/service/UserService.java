package com.hex.upskillPolicy.service;


import lombok.AllArgsConstructor;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hex.upskillPolicy.exception.UsernameAlreadyExist;
import com.hex.upskillPolicy.model.User;
import com.hex.upskillPolicy.repository.UserRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
//public class UserService {

public class UserService implements UserDetailsService {



    private final UserRepository userRepository;

    public void checkUniqueness(String username) {
        Optional<User> optional = userRepository.findByUsername(username);
        if(optional.isPresent()){
            throw new UsernameAlreadyExist("Username needs to be unique");
        }
    }

    public User save(User user) {
        return userRepository.save(user);
    }
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user= userRepository.findByUsername(username)
                .orElseThrow(()->new UsernameNotFoundException("Invalid User!!"));
        return user;
    }
}