package com.correia.hexagonal.adapters.out.feign.client;


import com.correia.hexagonal.adapters.out.feign.client.response.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "FindAddressFeignClient", url = "${client.addresses.url}")
public interface FindAddressFeignClient {

    @GetMapping("/{zipCode}")
    AddressResponse findAddressByZipCode(@PathVariable("zipCode") String zipCode);

}
