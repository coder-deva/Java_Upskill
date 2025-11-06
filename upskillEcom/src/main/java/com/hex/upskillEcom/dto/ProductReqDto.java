package com.hex.upskillEcom.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ProductReqDto(

        @NotNull(message = "title cannot be null")
        @NotBlank(message = "title needs a value")
        @Size(max = 255, message = "title should be less than 255 characters")
        String title,

        @NotNull(message = "description cannot be null")
        @NotBlank(message = "description needs a value")
        @Size(max = 1000, message = "description should be less than 1000 characters")
        String description,

        @NotNull(message = "price cannot be null")
        Double price,

        @NotNull(message = "category cannot be null")
        @NotBlank(message = "category needs a value")
        String category
) {}
