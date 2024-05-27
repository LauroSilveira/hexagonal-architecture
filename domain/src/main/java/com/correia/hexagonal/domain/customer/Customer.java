package com.correia.hexagonal.domain.customer;


import com.correia.hexagonal.domain.address.Address;
import lombok.Builder;

@Builder
public record Customer(String id, String name, Address address, String dni, Boolean isValidDni) {
}
