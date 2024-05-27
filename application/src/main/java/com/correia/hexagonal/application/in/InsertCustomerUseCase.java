package com.correia.hexagonal.application.in;


import com.correia.hexagonal.domain.customer.Customer;

public interface InsertCustomerUseCase {

    Customer insert(Customer customer, String zipCode);
}
