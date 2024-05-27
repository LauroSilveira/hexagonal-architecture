package com.correia.hexagonal.domain.address;

import lombok.Builder;

@Builder
public record Address(String street, String city, String state) {

}
