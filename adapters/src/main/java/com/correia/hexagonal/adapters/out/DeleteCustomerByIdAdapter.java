package com.correia.hexagonal.adapters.out;


import com.correia.hexagonal.adapters.out.repository.CustomerRepository;
import com.correia.hexagonal.application.out.DeleteCustomerByIdPort;
import org.springframework.stereotype.Component;

//Adapter (implementation) of DeleteCustomerByIdPort
@Component
public class DeleteCustomerByIdAdapter implements DeleteCustomerByIdPort {

    private final CustomerRepository customerRepository;

    public DeleteCustomerByIdAdapter(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void deleteCustomerById(final String id) {
        this.customerRepository.deleteById(id);
    }
}
