package com.correia.hexagonal.adapters.out.feign.client.mapper;


import com.correia.hexagonal.adapters.out.feign.client.response.AddressResponse;
import com.correia.hexagonal.domain.address.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressResponseMapper {

    Address toAddress(AddressResponse addressResponse);
}
