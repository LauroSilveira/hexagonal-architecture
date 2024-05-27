package com.correia.hexagonal.application.usecase;


import com.correia.hexagonal.application.in.DeleteCustomerByIdUseCase;
import com.correia.hexagonal.application.out.DeleteCustomerByIdPort;
import com.correia.hexagonal.application.out.FindCustomerByIdPort;
import org.springframework.stereotype.Component;

@Component
public class DeleteCustomerByIdUseCaseImpl implements DeleteCustomerByIdUseCase {

    private final FindCustomerByIdPort findCustomerByIdPort;
    private final DeleteCustomerByIdPort deleteCustomerByIdPort;

    public DeleteCustomerByIdUseCaseImpl(final FindCustomerByIdPort findCustomerByIdPort,
                                         final DeleteCustomerByIdPort deleteCustomerByIdPort) {
        this.findCustomerByIdPort = findCustomerByIdPort;
        this.deleteCustomerByIdPort = deleteCustomerByIdPort;
    }

    @Override
    public void deleteCustomerById(final String id) {
        this.findCustomerByIdPort.findById(id);
        this.deleteCustomerByIdPort.deleteCustomerById(id);
    }
}
