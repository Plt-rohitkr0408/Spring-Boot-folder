package com.example.micro_eureka_service_P02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MicroEurekaServiceP02Application {

	public static void main(String[] args) {
		SpringApplication.run(MicroEurekaServiceP02Application.class, args);
	}

}
