package com.kerjox.bloque5_rubrica_6springboot_simple_post.service;

import com.kerjox.bloque5_rubrica_6springboot_simple_post.dto.PersonDTO;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {
	@Override
	public boolean isValid(PersonDTO personDTO) {
		return personDTO != null
						&& personDTO.getProfession() != null
						&& personDTO.getProfession().equals("Software Developer");
	}
}
