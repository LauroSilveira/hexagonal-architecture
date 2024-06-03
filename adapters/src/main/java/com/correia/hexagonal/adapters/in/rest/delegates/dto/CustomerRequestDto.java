package com.correia.hexagonal.adapters.in.rest.delegates.dto;

import jakarta.validation.constraints.NotBlank;

public record CustomerRequestDto(@NotBlank String name, @NotBlank String dni, @NotBlank String zipCode) {
}
