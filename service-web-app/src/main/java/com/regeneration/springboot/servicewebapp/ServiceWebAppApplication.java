package com.regeneration.springboot.servicewebapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

@EntityScan(basePackageClasses = {ServiceWebAppApplication.class, Jsr310JpaConverters.class})
@SpringBootApplication
@ComponentScan("com.regeneration.*")
public class ServiceWebAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceWebAppApplication.class, args);
	}
}
