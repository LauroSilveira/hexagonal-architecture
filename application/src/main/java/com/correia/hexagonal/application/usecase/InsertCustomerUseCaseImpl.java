package com.correia.hexagonal.application.usecase;


import com.correia.hexagonal.application.in.InsertCustomerUseCase;
import com.correia.hexagonal.application.out.SendDniValidationPort;
import com.correia.hexagonal.application.out.FindAddressByZipCodePort;
import com.correia.hexagonal.application.out.InsertCustomerPort;
import com.correia.hexagonal.domain.customer.Customer;
import org.springframework.stereotype.Component;

@Component
public class InsertCustomerUseCaseImpl implements InsertCustomerUseCase {

    private final FindAddressByZipCodePort findAddressByZipCodePort;
    private final InsertCustomerPort insertCustomerPortOutPort;
    private final SendDniValidationPort sendDniValidationPort;

    public InsertCustomerUseCaseImpl(final FindAddressByZipCodePort findAddressByZipCodePort,
                                     final InsertCustomerPort insertCustomerPortOutPort,
                                     final SendDniValidationPort sendDniValidationPort) {
        this.findAddressByZipCodePort = findAddressByZipCodePort;
        this.insertCustomerPortOutPort = insertCustomerPortOutPort;
        this.sendDniValidationPort = sendDniValidationPort;
    }

    @Override
    public Customer insert(final Customer customer, final String zipCode) {
        final var address = this.findAddressByZipCodePort.findZipCode(zipCode);
        final var customerAddressUpdated = Customer.builder()
                .id(customer.id())
                .dni(customer.dni())
                .address(address)
                .name(customer.name())
                .isValidDni(customer.isValidDni()).build();
        //Insert on database
        this.insertCustomerPortOutPort.insert(customerAddressUpdated);
        //Send to Kafka
        this.sendDniValidationPort.send(customer.dni());
        return customerAddressUpdated;
    }
}
