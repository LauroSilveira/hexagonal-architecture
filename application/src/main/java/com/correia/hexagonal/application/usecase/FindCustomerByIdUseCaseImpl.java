package com.correia.hexagonal.application.usecase;


import com.correia.hexagonal.application.in.FindCustomerByIdUseCase;
import com.correia.hexagonal.application.out.FindCustomerByIdPort;
import com.correia.hexagonal.domain.customer.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindCustomerByIdUseCaseImpl implements FindCustomerByIdUseCase {

    private final FindCustomerByIdPort findCustomerByIdPort;

    @Override
    public Customer findById(final String id) {
        return this.findCustomerByIdPort.findById(id);
    }
}
