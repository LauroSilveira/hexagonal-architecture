package com.correia.hexagonal.application.out;


import com.correia.hexagonal.domain.address.Address;

public interface FindAddressByZipCodePort {

    Address findZipCode(String zipCode);
}
