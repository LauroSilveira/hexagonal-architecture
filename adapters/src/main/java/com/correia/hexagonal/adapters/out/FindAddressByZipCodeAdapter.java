package com.correia.hexagonal.adapters.out;


import com.correia.hexagonal.adapters.out.feign.client.FindAddressFeignClient;
import com.correia.hexagonal.adapters.out.feign.client.mapper.AddressResponseMapper;
import com.correia.hexagonal.application.out.FindAddressByZipCodePort;
import com.correia.hexagonal.domain.address.Address;
import com.correia.hexagonal.domain.exception.FeignClientException;
import feign.FeignException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Component;

//Adapter (implementation) of FindAddressByZipCodePort
@Component
public class FindAddressByZipCodeAdapter implements FindAddressByZipCodePort {

    private final FindAddressFeignClient findAddressFeignClient;
    private final AddressResponseMapper addressResponseMapper;

    public FindAddressByZipCodeAdapter(FindAddressFeignClient findAddressFeignClient,
                                       AddressResponseMapper addressResponseMapper) {
        this.findAddressFeignClient = findAddressFeignClient;
        this.addressResponseMapper = addressResponseMapper;
    }

    @CircuitBreaker(name = "findZipCode", fallbackMethod = "zipCodeFallBack")
    @Override
    public Address findZipCode(final String zipCode) {
        final var response = this.findAddressFeignClient.findAddressByZipCode(zipCode);
        return this.addressResponseMapper.toAddress(response);
    }
    //FallBack method should have same return from original method
    private Address zipCodeFallBack(final String zipCode, FeignException ex)  {
         throw new FeignClientException("Error calling feign client ZipCodeService", ex.status());
    }
}
