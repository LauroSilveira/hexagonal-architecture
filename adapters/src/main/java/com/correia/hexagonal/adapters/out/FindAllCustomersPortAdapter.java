package com.correia.hexagonal.adapters.out;

import com.correia.hexagonal.adapters.out.repository.CustomerRepository;
import com.correia.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.correia.hexagonal.application.out.FindAllCustomersPort;
import com.correia.hexagonal.domain.customer.Customer;
import org.springframework.stereotype.Component;

import java.util.List;

//Adapter (implementation) of FindAllCustomersPort
@Component
public class FindAllCustomersPortAdapter implements FindAllCustomersPort {

    private final CustomerRepository customerRepository;
    private final CustomerEntityMapper customerEntityMapper;

    public FindAllCustomersPortAdapter(CustomerRepository customerRepository,
                                       CustomerEntityMapper customerEntityMapper) {
        this.customerRepository = customerRepository;
        this.customerEntityMapper = customerEntityMapper;
    }

    @Override
    public List<Customer> findAllCustomers() {
        return this.customerRepository.findAll()
                .stream()
                .map(this.customerEntityMapper::mapToCustomer)
                .toList();
    }
}
