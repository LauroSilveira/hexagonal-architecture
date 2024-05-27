package com.correia.hexagonal.application.in;


import com.correia.hexagonal.domain.customer.Customer;

public interface UpdateCustomerUseCase {

    Customer updateCustomer(String id, Customer customer, String zipCode);
}
