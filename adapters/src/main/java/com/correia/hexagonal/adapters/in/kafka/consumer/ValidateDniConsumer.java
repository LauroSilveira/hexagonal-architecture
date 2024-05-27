package com.correia.hexagonal.adapters.in.kafka.consumer;


import com.correia.hexagonal.adapters.in.kafka.consumer.mapper.CustomerMessageMapper;
import com.correia.hexagonal.adapters.in.kafka.consumer.message.CustomerMessage;
import com.correia.hexagonal.application.in.UpdateCustomerUseCase;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ValidateDniConsumer {

    private final UpdateCustomerUseCase updateCustomerUseCase;
    private final CustomerMessageMapper customerMessageMapper;

    public ValidateDniConsumer(UpdateCustomerUseCase updateCustomerUseCase,
                               CustomerMessageMapper customerMessageMapper) {
        this.updateCustomerUseCase = updateCustomerUseCase;
        this.customerMessageMapper = customerMessageMapper;
    }

    @KafkaListener(topics = "topic-dni-validated", groupId = "lauro")
    public void validateDni(final CustomerMessage customerMessage) {
        final var customer = this.customerMessageMapper.toCustomer(customerMessage);
        this.updateCustomerUseCase.updateCustomer(customer.id(), customer, customerMessage.zipCode());
    }
}
