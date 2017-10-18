package com.regeneration.springboot.servicewebapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan("com.regeneration.*")
public class ServiceWebAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceWebAppApplication.class, args);
	}
}
