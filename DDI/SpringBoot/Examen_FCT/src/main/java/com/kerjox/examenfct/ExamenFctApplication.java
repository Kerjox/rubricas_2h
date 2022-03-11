package com.kerjox.examenfct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.kerjox.examenfct.*")
public class ExamenFctApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExamenFctApplication.class, args);
	}

}
