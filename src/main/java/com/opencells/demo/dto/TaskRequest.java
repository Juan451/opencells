package com.opencells.demo.dto;

import jakarta.validation.constraints.NotBlank;

public record TaskRequest(
        @NotBlank(message = "El título es obligatorio")
        String title
) {
}