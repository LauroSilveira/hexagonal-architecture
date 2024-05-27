package com.correia.hexagonal.adapters.out.repository.mapper;


import com.correia.hexagonal.adapters.out.repository.entity.CustomerEntity;
import com.correia.hexagonal.domain.customer.Customer;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface CustomerEntityMapper {
    @Mapping(target = "addressEntity", source = "address")
    CustomerEntity mapToCustomerEntity(Customer customer);

    @Mapping(target = "address", source = "addressEntity")
    Customer mapToCustomer(CustomerEntity customerEntity);
}
