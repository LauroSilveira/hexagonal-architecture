package com.correia.hexagonal.adapters.in.rest.delegates;

import com.correia.hexagonal.adapters.api.CustomerApiDelegate;
import com.correia.hexagonal.adapters.in.rest.delegates.mapper.CustomerMapper;
import com.correia.hexagonal.adapters.model.CustomerDto;
import com.correia.hexagonal.application.in.DeleteCustomerByIdUseCase;
import com.correia.hexagonal.application.in.FindAllCustomersUseCase;
import com.correia.hexagonal.application.in.FindCustomerByIdUseCase;
import com.correia.hexagonal.application.in.InsertCustomerUseCase;
import com.correia.hexagonal.application.in.UpdateCustomerUseCase;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class CustomerDelegate implements CustomerApiDelegate {

    private final FindAllCustomersUseCase findAllCustomersUseCase;
    private final FindCustomerByIdUseCase findCustomerByIdUseCase;
    private final InsertCustomerUseCase insertCustomerUseCase;
    private final UpdateCustomerUseCase updateCustomerUseCase;
    private final DeleteCustomerByIdUseCase deleteCustomerByIdUseCase;
    private final CustomerMapper customerMapper;


    @Override
    public ResponseEntity<Void> insert(CustomerDto customerDto) {
        final var customerDomain = this.customerMapper.mapToCustomerDomain(customerDto);
        insertCustomerUseCase.insert(customerDomain, customerDto.getZipCode());
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<CustomerDto> getConsumerById(String id) {
        final var customer = this.findCustomerByIdUseCase.findById(id);
        final var dto = this.customerMapper.mapToCustomerDto(customer);
        return ResponseEntity.ok(dto);
    }

    @Override
    public ResponseEntity<List<CustomerDto>> getConsumers() {
        final var customers = this.findAllCustomersUseCase.findAllCustomers();
        final var customersDto = this.customerMapper.mapToCustomersDto(customers);
        return ResponseEntity.ok(customersDto);
    }

    @Override
    public ResponseEntity<Void> update(String customerId, CustomerDto customerDto) {
        final var customerDomain = this.customerMapper.mapToCustomerDomain(customerDto);
        this.updateCustomerUseCase.updateCustomer(customerId, customerDomain, customerDto.getZipCode());
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> delete(String customerId) {
        this.deleteCustomerByIdUseCase.deleteCustomerById(customerId);
        return ResponseEntity.accepted().build();
    }
}
