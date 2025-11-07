package com.hex.trs.dto;

public record PlanDto(
        long planId,
        String planName,
        double planPrice,
        long subscriberCount
) {}
