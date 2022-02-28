package com.kerjox.bloque5rubbrica8;

import com.kerjox.bloque5rubbrica8.entity.Student;
import com.kerjox.bloque5rubbrica8.repos.StudentJdbcRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Bloque5Rubbrica8Application implements CommandLineRunner {

	@Autowired
	StudentJdbcRepo repository;

	private Logger logger = LoggerFactory.getLogger("Kerjox Logger");

	public static void main(String[] args) {
		SpringApplication.run(Bloque5Rubbrica8Application.class, args);
	}

	@Override
	public void run(String...args) throws Exception {

		logger.info("student id 10001 -> {}", repository.findbyid(10001));

		logger.info("all users 1 -> {}", repository.findall());

		logger.info("inserting -> {}", repository.insert(new Student(10010, "john", "a1234657")));

		logger.info("update 10001 -> {}", repository.update(new Student(10001, "name-updated", "new-passport")));

		repository.deletebyid(10002);

		logger.info("all users 2 -> {}", repository.findall());

	}
}
