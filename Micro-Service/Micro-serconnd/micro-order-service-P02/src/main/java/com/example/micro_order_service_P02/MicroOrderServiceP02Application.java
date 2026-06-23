package com.example.micro_order_service_P02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class MicroOrderServiceP02Application {

	public static void main(String[] args) {
		SpringApplication.run(MicroOrderServiceP02Application.class, args);
	}

}
