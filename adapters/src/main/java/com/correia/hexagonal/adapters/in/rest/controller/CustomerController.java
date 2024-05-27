package com.correia.hexagonal.adapters.in.rest.controller;


import com.correia.hexagonal.adapters.in.rest.controller.dto.CustomerRequest;
import com.correia.hexagonal.adapters.in.rest.controller.mapper.CustomerMapper;
import com.correia.hexagonal.application.in.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {
    private final FindAllCustomersUseCase findAllCustomersUseCase;
    private final FindCustomerByIdUseCase findCustomerByIdUseCase;
    private final InsertCustomerUseCase insertCustomerUseCase;
    private final UpdateCustomerUseCase updateCustomerUseCase;
    private final DeleteCustomerByIdUseCase deleteCustomerByIdUseCase;
    private final CustomerMapper customerMapper;

    @PostMapping
    public ResponseEntity<CustomerResponse> insert(@RequestBody @Valid final CustomerRequest customerRequest) {
        final var customerDomain = this.customerMapper.mapToCustomerDomain(customerRequest);
        final var customerResponse = this.customerMapper.mapToCustomerResponse(
                insertCustomerUseCase.insert(customerDomain, customerRequest.zipCode()));
        return ResponseEntity.ok(customerResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable final String id) {
        final var customer = this.findCustomerByIdUseCase.findById(id);
        final var customerResponse = this.customerMapper.mapToCustomerResponse(customer);
        return ResponseEntity.ok(customerResponse);
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponse>> findAll() {
        final var customers = this.findAllCustomersUseCase.findAllCustomers();
        return ResponseEntity.ok(this.customerMapper.mapToCustomersResponse(customers));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerResponse> update(@PathVariable final String id, @RequestBody @Valid final CustomerRequest customerRequest) {
        final var customerDomain = this.customerMapper.mapToCustomerDomain(customerRequest);
        final var updatedCustomer = this.updateCustomerUseCase.updateCustomer(id, customerDomain, customerRequest.zipCode());
        return ResponseEntity.ok(this.customerMapper.mapToCustomerResponse(updatedCustomer));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable final String id) {
        this.deleteCustomerByIdUseCase.deleteCustomerById(id);
        return ResponseEntity.noContent().build();
    }
}
