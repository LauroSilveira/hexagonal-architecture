package com.correia.hexagonal.application.config;


import com.correia.hexagonal.application.out.FindAddressByZipCodePort;
import com.correia.hexagonal.application.out.FindCustomerByIdPort;
import com.correia.hexagonal.application.out.UpdateCustomerPort;
import com.correia.hexagonal.application.usecase.UpdateCustomerUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Return a new instantiate of InsertCustomerUseCase
 */
@Configuration
public class UpdateCustomerConfig {

    @Bean
    public UpdateCustomerUseCaseImpl updateCustomerUseCase(final FindCustomerByIdPort findCustomerByIdPort,
                                                           final FindAddressByZipCodePort findAddressByZipCodePort,
                                                           final UpdateCustomerPort updateCustomerPort) {
        return new UpdateCustomerUseCaseImpl(findCustomerByIdPort, findAddressByZipCodePort, updateCustomerPort);
    }
}
