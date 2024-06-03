package com.correia.hexagonal.adapters.in.rest.delegates.dto;


import com.correia.hexagonal.adapters.out.feign.client.response.AddressResponse;

public record CustomerResponseDto(String id, String name, AddressResponse address, String dni, boolean isValidDni) {
}
