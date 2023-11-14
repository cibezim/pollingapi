package com.polling.pollingapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"com.polling.pollingapi.models"})
public class PollingapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PollingapiApplication.class, args);
	}

}
