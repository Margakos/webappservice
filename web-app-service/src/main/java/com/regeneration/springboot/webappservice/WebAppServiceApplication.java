package com.regeneration.springboot.webappservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.regeneration.springboot.webappservice")
public class WebAppServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebAppServiceApplication.class, args);
	}
}
