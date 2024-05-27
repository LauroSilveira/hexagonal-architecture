package com.correia.hexagonal.application.in;

import com.correia.hexagonal.domain.customer.Customer;

import java.util.List;

public interface FindAllCustomersUseCase {

    List<Customer> findAllCustomers();
}
