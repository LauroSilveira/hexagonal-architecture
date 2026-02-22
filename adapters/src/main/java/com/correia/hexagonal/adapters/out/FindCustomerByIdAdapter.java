package com.correia.hexagonal.adapters.out;


import com.correia.hexagonal.adapters.out.repository.CustomerRepository;
import com.correia.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.correia.hexagonal.application.out.FindCustomerByIdPort;
import com.correia.hexagonal.domain.customer.Customer;
import com.correia.hexagonal.domain.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

//Adapter (implementation) of FindCustomerByIdPort
@Component
@RequiredArgsConstructor
public class FindCustomerByIdAdapter implements FindCustomerByIdPort {

    private final CustomerRepository customerRepository;
    private final CustomerEntityMapper customerEntityMapper;


    @Override
    public Customer findById(final String id) {
        return this.customerRepository.findById(id)
                .map(this.customerEntityMapper::mapToCustomer)
                .orElseThrow(() -> new BusinessException(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name()));
    }
}
