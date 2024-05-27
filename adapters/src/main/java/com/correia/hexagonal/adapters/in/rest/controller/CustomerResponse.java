package com.correia.hexagonal.adapters.in.rest.controller;


import com.correia.hexagonal.adapters.out.feign.client.response.AddressResponse;

public record CustomerResponse(String id, String name, AddressResponse address, String dni, Boolean isValidDni) {
}
