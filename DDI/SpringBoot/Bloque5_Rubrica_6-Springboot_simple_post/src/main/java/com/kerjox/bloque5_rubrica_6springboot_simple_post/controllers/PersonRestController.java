package com.kerjox.bloque5_rubrica_6springboot_simple_post.controllers;

import com.kerjox.bloque5_rubrica_6springboot_simple_post.dto.PersonDTO;
import com.kerjox.bloque5_rubrica_6springboot_simple_post.repos.PersonRepository;
import com.kerjox.bloque5_rubrica_6springboot_simple_post.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonRestController {

	@Autowired
	private PersonService personService;

	@Autowired
	private PersonRepository personRepository;

	@RequestMapping(value = "/persistPerson", method = RequestMethod.POST)
	public ResponseEntity <String> persistPerson(@RequestBody PersonDTO person) {

		if (personService.isValid(person)) {

			personRepository.persist(person);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		}
		return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
	}
}
