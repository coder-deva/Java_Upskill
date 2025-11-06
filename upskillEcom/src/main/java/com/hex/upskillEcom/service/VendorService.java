package com.hex.upskillEcom.service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import com.hex.upskillEcom.exception.InvalidIdException;
import com.hex.upskillEcom.model.Vendor;
import com.hex.upskillEcom.repository.VendorRepository;

@Service
@AllArgsConstructor
public class VendorService {

    private final VendorRepository vendorRepository;

    public Vendor getById(long vendorId) {
        return vendorRepository.findById(vendorId)
                .orElseThrow(() -> new InvalidIdException("Vendor Id Invalid"));
    }
}
