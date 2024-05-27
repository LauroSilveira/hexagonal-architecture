package com.correia.hexagonal.adapters.in.rest.controller.dto;

import jakarta.validation.constraints.NotBlank;

public record CustomerRequest(@NotBlank String name, @NotBlank String dni, @NotBlank String zipCode) {
}
