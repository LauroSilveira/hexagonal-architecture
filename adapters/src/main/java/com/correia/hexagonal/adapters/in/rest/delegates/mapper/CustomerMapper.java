package com.correia.hexagonal.adapters.in.rest.delegates.mapper;


import com.correia.hexagonal.adapters.in.rest.delegates.dto.CustomerResponseDTO;
import com.correia.hexagonal.adapters.in.rest.delegates.dto.CustomerRequestDTO;
import com.correia.hexagonal.adapters.model.CustomerDto;
import com.correia.hexagonal.domain.customer.Customer;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface CustomerMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "address", ignore = true)
    @Mapping(target = "isValidDni", ignore = true)
    Customer mapToCustomerDomain(CustomerRequestDTO customerRequestDto);

    CustomerResponseDTO mapToCustomerResponse(Customer customer);

    CustomerDto mapToCustomerDto(Customer customer);

    List<CustomerResponseDTO> mapToCustomersResponse(List<Customer> customers);

    List<CustomerDto> mapToCustomersDto(List<Customer> customers);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "address", ignore = true)
    @Mapping(target = "isValidDni", ignore = true)
    Customer mapToCustomerDomain(CustomerDto customerDto);
}
