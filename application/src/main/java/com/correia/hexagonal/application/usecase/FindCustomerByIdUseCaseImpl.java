package com.correia.hexagonal.application.usecase;


import com.correia.hexagonal.application.in.FindCustomerByIdUseCase;
import com.correia.hexagonal.application.out.FindCustomerByIdPort;
import com.correia.hexagonal.domain.customer.Customer;
import org.springframework.stereotype.Service;

@Service
public class FindCustomerByIdUseCaseImpl implements FindCustomerByIdUseCase {

    private final FindCustomerByIdPort findCustomerByIdPort;

    public FindCustomerByIdUseCaseImpl(final FindCustomerByIdPort findCustomerByIdPort) {
        this.findCustomerByIdPort = findCustomerByIdPort;
    }

    @Override
    public Customer findById(final String id) {
        return this.findCustomerByIdPort.findById(id);
    }
}
