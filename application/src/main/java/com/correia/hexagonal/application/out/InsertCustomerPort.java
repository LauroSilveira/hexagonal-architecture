package com.correia.hexagonal.application.out;


import com.correia.hexagonal.domain.customer.Customer;

public interface InsertCustomerPort {

    void insert(Customer customer);
}
