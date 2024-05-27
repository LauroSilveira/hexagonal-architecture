package com.correia.hexagonal.adapters.out;


import com.correia.hexagonal.adapters.out.repository.CustomerRepository;
import com.correia.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.correia.hexagonal.application.out.InsertCustomerPort;
import com.correia.hexagonal.domain.customer.Customer;
import org.springframework.stereotype.Component;

//Adapter (implementation) of InsertCustomerPort
@Component
public class InsertCustomerAdapter implements InsertCustomerPort {

    private final CustomerRepository customerRepository;
    private final CustomerEntityMapper customerEntityMapper;

    public InsertCustomerAdapter(CustomerRepository customerRepository,
                                 CustomerEntityMapper customerEntityMapper) {
        this.customerRepository = customerRepository;
        this.customerEntityMapper = customerEntityMapper;
    }

    @Override
    public void insert(final Customer customer) {
        final var customerEntity = this.customerEntityMapper.mapToCustomerEntity(customer);
        this.customerRepository.save(customerEntity);
    }
}
