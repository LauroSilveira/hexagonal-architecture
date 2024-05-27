package com.correia.hexagonal.adapters.in.kafka.consumer.mapper;


import com.correia.hexagonal.adapters.in.kafka.consumer.message.CustomerMessage;
import com.correia.hexagonal.domain.customer.Customer;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface CustomerMessageMapper {

    @Mapping(target = "address", ignore = true)
    Customer toCustomer(CustomerMessage customerMessage);
}
