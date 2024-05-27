package com.correia.hexagonal.bootstrap;


import com.correia.hexagonal.adapters.out.feign.client.FindAddressFeignClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableFeignClients(clients = FindAddressFeignClient.class)
@SpringBootApplication(scanBasePackages = {"com.correia.hexagonal.adapters", "com.correia.hexagonal.application"})
@EnableMongoRepositories(basePackages = "com.correia.hexagonal.adapters")
public class HexagonalArchitectureApplication {

	public static void main(String[] args) {
		SpringApplication.run(HexagonalArchitectureApplication.class, args);
	}

}
