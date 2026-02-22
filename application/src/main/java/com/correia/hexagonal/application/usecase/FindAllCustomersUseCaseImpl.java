package com.correia.hexagonal.application.usecase;

import com.correia.hexagonal.application.in.FindAllCustomersUseCase;
import com.correia.hexagonal.application.out.FindAllCustomersPort;
import com.correia.hexagonal.domain.customer.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FindAllCustomersUseCaseImpl implements FindAllCustomersUseCase {

    private final FindAllCustomersPort findAllCustomersPort;

    @Override
    public List<Customer> findAllCustomers() {
        return this.findAllCustomersPort.findAllCustomers();
    }
}
