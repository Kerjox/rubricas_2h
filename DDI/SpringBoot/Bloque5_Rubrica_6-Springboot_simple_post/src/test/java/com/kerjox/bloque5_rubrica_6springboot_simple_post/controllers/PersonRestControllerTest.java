package com.kerjox.bloque5_rubrica_6springboot_simple_post.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kerjox.bloque5_rubrica_6springboot_simple_post.dto.PersonDTO;
import com.kerjox.bloque5_rubrica_6springboot_simple_post.repos.PersonRepository;
import com.kerjox.bloque5_rubrica_6springboot_simple_post.service.PersonService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.io.IOException;

import static org.mockito.BDDMockito.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class PersonRestControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@MockBean
	private PersonService personService;

	@MockBean
	private PersonRepository personRepository;

	private JacksonTester<PersonDTO> jsonTester;

	private PersonDTO personDTO;

	@Before
	public void setup() {
		JacksonTester.initFields(this, objectMapper);
		personDTO = new PersonDTO();
	}

	@Test
	void persistPerson_IsValid_PersonPersisted() {

		String personDTOJson = "";
		try {
			personDTOJson = jsonTester.write(personDTO).getJson();
		} catch (IOException e) {
			e.printStackTrace();
		}
		given(personService.isValid(any(PersonDTO.class))).willReturn(true);
		try {
			mockMvc
							.perform(post("/persistPerson").content(personDTOJson).contentType(APPLICATION_JSON_UTF8))
							.andExpect(status().isCreated());
		} catch (Exception e) {
			e.printStackTrace();
		}
		verify(personRepository).persist(any(PersonDTO.class));
	}

	@Test
	public void persistPerson_IsNotValid_PersonNotPersisted() throws Exception {
		final String personDTOJson = jsonTester.write(personDTO).getJson();
		given(personService.isValid(any(PersonDTO.class))).willReturn(false);
		mockMvc
						.perform(post("/persistPerson").content(personDTOJson).contentType(APPLICATION_JSON_UTF8))
						.andExpect(status().isIAmATeapot());
		verify(personRepository, times(0)).persist(any(PersonDTO.class));
	}
}