package com.example.microserviceconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class MicroServiceConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServiceConfigApplication.class, args);
	}

}
