package com.correia.hexagonal.adapters.out;


import com.correia.hexagonal.adapters.out.repository.CustomerRepository;
import com.correia.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.correia.hexagonal.application.out.FindCustomerByIdPort;
import com.correia.hexagonal.domain.customer.Customer;
import org.springframework.stereotype.Component;

//Adapter (implementation) of FindCustomerByIdPort
@Component
public class FindCustomerByIdAdapter implements FindCustomerByIdPort {

    private final CustomerRepository customerRepository;
    private final CustomerEntityMapper customerEntityMapper;

    public FindCustomerByIdAdapter(CustomerRepository customerRepository, CustomerEntityMapper customerEntityMapper) {
        this.customerRepository = customerRepository;
        this.customerEntityMapper = customerEntityMapper;
    }

    @Override
    public Customer findById(final String id) {
        return this.customerRepository.findById(id)
                .map(this.customerEntityMapper::mapToCustomer)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
    }
}
