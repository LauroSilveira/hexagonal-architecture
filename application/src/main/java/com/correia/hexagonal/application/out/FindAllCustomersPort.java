package com.correia.hexagonal.application.out;

import com.correia.hexagonal.domain.customer.Customer;

import java.util.List;

public interface FindAllCustomersPort {

    List<Customer> findAllCustomers();
}
