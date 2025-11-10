package com.hex.upskillPolicy.dto;

import java.time.LocalDate;

public record CustomerPolicyDto(
        long customerId,
        long policyId,
        LocalDate dateOfIssue,
        LocalDate dateOfExpiry
) {}