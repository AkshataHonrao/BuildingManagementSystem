package com.example.rentalapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan("com.example.rentalapp.models")
public class RentalappApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentalappApplication.class, args);
	}

}
