package com.correia.hexagonal.application.usecase;


import com.correia.hexagonal.application.in.UpdateCustomerUseCase;
import com.correia.hexagonal.application.out.FindAddressByZipCodePort;
import com.correia.hexagonal.application.out.FindCustomerByIdPort;
import com.correia.hexagonal.application.out.UpdateCustomerPort;
import com.correia.hexagonal.domain.customer.Customer;
import org.springframework.stereotype.Component;

@Component
public class UpdateCustomerUseCaseImpl implements UpdateCustomerUseCase {

    private final FindCustomerByIdPort findCustomerByIdPort;
    private final FindAddressByZipCodePort findAddressByZipCodePort;
    private final UpdateCustomerPort updateCustomerPort;

    public UpdateCustomerUseCaseImpl(final FindCustomerByIdPort findCustomerByIdPort,
                                     final FindAddressByZipCodePort findAddressByZipCodePort,
                                     final UpdateCustomerPort updateCustomerPort) {
        this.findCustomerByIdPort = findCustomerByIdPort;
        this.findAddressByZipCodePort = findAddressByZipCodePort;
        this.updateCustomerPort = updateCustomerPort;
    }

    @Override
    public Customer updateCustomer(final String id, final Customer customer, final String zipCode) {
        //find Customer
        this.findCustomerByIdPort.findById(id);
        //find customer Address
        final var address = this.findAddressByZipCodePort.findZipCode(zipCode);
        //Update fields with request
        final var customerToSave = Customer.builder()
                .id(id)
                .name(customer.name())
                .dni(customer.dni())
                .address(address)
                .isValidDni(customer.isValidDni())
                .build();
        //update on database
        return this.updateCustomerPort.updateCustomer(customerToSave);
    }
}
