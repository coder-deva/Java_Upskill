package com.hex.upskillPolicy.dto;

public record PolicyDto(
        String title,
        double premium,
        int tenure,
        String type
) {}