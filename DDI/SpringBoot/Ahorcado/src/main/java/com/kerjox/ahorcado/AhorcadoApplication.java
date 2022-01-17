package com.kerjox.ahorcado;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.kerjox.ahorcado.*"})
public class AhorcadoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AhorcadoApplication.class, args);
	}

}
