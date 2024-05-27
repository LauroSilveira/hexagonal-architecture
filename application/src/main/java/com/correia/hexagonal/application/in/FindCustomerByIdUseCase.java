package com.correia.hexagonal.application.in;


import com.correia.hexagonal.domain.customer.Customer;

public interface FindCustomerByIdUseCase {

    Customer findById(String id);
}
