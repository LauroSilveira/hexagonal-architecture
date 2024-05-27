package com.correia.hexagonal.application.config;


import com.correia.hexagonal.application.out.DeleteCustomerByIdPort;
import com.correia.hexagonal.application.out.FindCustomerByIdPort;
import com.correia.hexagonal.application.usecase.DeleteCustomerByIdUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Return a new instantiate of DeleteCustomerByIdUseCase
 */
@Configuration
public class DeleteCustomerConfig {

    @Bean
    public DeleteCustomerByIdUseCaseImpl deleteCustomerByIdUseCase(final FindCustomerByIdPort findCustomerByIdPort,
                                                                   final DeleteCustomerByIdPort deleteCustomerByIdPort) {
        return new DeleteCustomerByIdUseCaseImpl(findCustomerByIdPort, deleteCustomerByIdPort);
    }
}
