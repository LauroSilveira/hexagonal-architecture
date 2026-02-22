package com.correia.hexagonal.adapters.in.rest.delegates.dto;

import jakarta.validation.constraints.NotBlank;

public record CustomerRequestDTO(@NotBlank String name, @NotBlank String dni, @NotBlank String zipCode) {
}
