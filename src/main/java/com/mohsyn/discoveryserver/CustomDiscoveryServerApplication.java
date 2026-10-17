package com.mohsyn.discoveryserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CustomDiscoveryServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomDiscoveryServerApplication.class, args);
	}

}
