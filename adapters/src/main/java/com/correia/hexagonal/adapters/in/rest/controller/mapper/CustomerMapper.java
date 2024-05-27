package com.correia.hexagonal.adapters.in.rest.controller.mapper;


import com.correia.hexagonal.adapters.in.rest.controller.CustomerResponse;
import com.correia.hexagonal.adapters.in.rest.controller.dto.CustomerRequest;
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
    Customer mapToCustomerDomain(CustomerRequest customerRequest);

    CustomerResponse mapToCustomerResponse(Customer customer);

    List<CustomerResponse> mapToCustomersResponse(List<Customer> customers);
}
