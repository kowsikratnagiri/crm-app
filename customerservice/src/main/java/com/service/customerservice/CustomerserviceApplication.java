package com.service.customerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.logging.Logger;

@SpringBootApplication
public class CustomerserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerserviceApplication.class, args);
		System.out.println("started again");
	}

}
