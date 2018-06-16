package com.fibonacci.spring.profiles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({ "com.fibonacci.service", "com.fibonacci.service.impl", "com.fibonacci.controller" })
public class SpringProfilesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringProfilesApplication.class, args);
	}
}
