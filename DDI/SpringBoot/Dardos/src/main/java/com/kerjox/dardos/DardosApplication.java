package com.kerjox.dardos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.kerjox.dardos.*")
public class DardosApplication {

	public static void main(String[] args) {
		SpringApplication.run(DardosApplication.class, args);
	}

}
