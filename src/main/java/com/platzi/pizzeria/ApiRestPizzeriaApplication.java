package com.platzi.pizzeria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ApiRestPizzeriaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiRestPizzeriaApplication.class, args);
	}

}
