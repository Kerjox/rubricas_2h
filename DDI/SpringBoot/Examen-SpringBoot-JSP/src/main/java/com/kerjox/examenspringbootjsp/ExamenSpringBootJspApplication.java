package com.kerjox.examenspringbootjsp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.kerjox.examenspringbootjsp.*")
public class ExamenSpringBootJspApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExamenSpringBootJspApplication.class, args);
	}

}
