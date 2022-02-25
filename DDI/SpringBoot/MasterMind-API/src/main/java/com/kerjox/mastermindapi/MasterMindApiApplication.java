package com.kerjox.mastermindapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.kerjox.mastermindapi.*")
public class MasterMindApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MasterMindApiApplication.class, args);
	}

}
