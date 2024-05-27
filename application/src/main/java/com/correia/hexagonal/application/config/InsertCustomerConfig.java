package com.correia.hexagonal.application.config;

import com.correia.hexagonal.application.out.SendDniValidationPort;
import com.correia.hexagonal.application.out.FindAddressByZipCodePort;
import com.correia.hexagonal.application.out.InsertCustomerPort;
import com.correia.hexagonal.application.usecase.InsertCustomerUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Return a new instantiate of InsertCustomerUseCase
 */
@Configuration
public class InsertCustomerConfig {

    @Bean
    public InsertCustomerUseCaseImpl insertCustomerUseCase(final FindAddressByZipCodePort findAddressByZipCodePort,
                                                           final InsertCustomerPort insertCustomerPort,
                                                           final SendDniValidationPort sendDniValidationPort) {
        return new InsertCustomerUseCaseImpl(findAddressByZipCodePort, insertCustomerPort, sendDniValidationPort);
    }
}
