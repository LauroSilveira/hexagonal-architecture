package com.correia.hexagonal.application.usecase;

import com.correia.hexagonal.application.in.FindAllCustomersUseCase;
import com.correia.hexagonal.application.out.FindAllCustomersPort;
import com.correia.hexagonal.domain.customer.Customer;

import java.util.List;

public class FindAllCustomersUseCaseImpl implements FindAllCustomersUseCase {

    private final FindAllCustomersPort findAllCustomersPort;

    public FindAllCustomersUseCaseImpl(FindAllCustomersPort findAllCustomersPort) {
        this.findAllCustomersPort = findAllCustomersPort;
    }

    @Override
    public List<Customer> findAllCustomers() {
        return this.findAllCustomersPort.findAllCustomers();
    }
}
