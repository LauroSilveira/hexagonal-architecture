package com.correia.hexagonal.adapters.out;


import com.correia.hexagonal.adapters.out.repository.CustomerRepository;
import com.correia.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.correia.hexagonal.application.out.UpdateCustomerPort;
import com.correia.hexagonal.domain.customer.Customer;
import org.springframework.stereotype.Component;

//Adapter (implementation) of UpdateCustomerPort

@Component
public class UpdateCustomerAdapter implements UpdateCustomerPort {

    private final CustomerRepository customerRepository;
    private final CustomerEntityMapper customerEntityMapper;

    public UpdateCustomerAdapter(CustomerRepository customerRepository,
                                 CustomerEntityMapper customerEntityMapper) {
        this.customerRepository = customerRepository;
        this.customerEntityMapper = customerEntityMapper;
    }


    @Override
    public Customer updateCustomer(final Customer customer) {
        final var customerEntity = this.customerEntityMapper.mapToCustomerEntity(customer);
        final var customerUpdated = this.customerRepository.save(customerEntity);
        return this.customerEntityMapper.mapToCustomer(customerUpdated);
    }
}
