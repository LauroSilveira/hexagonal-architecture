package com.correia.hexagonal.application.config;



import com.correia.hexagonal.application.out.FindAllCustomersPort;
import com.correia.hexagonal.application.out.FindCustomerByIdPort;
import com.correia.hexagonal.application.usecase.FindAllCustomersUseCaseImpl;
import com.correia.hexagonal.application.usecase.FindCustomerByIdUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Return a new instantiate of FindCustomerByIdUseCase and FindAllCustomers
 */
@Configuration
public class FindCustomerConfig {

    @Bean
    public FindCustomerByIdUseCaseImpl findCustomerByIdUseCase(final FindCustomerByIdPort findCustomerByIdPort) {
        return new FindCustomerByIdUseCaseImpl(findCustomerByIdPort);
    }
    @Bean
    public FindAllCustomersUseCaseImpl findAllCustomersUseCase(final FindAllCustomersPort findAllCustomersPort){
        return new FindAllCustomersUseCaseImpl(findAllCustomersPort);
    }
}
