package com.kerjox.bloque5_rubrica_6springboot_simple_post.repos;

import com.kerjox.bloque5_rubrica_6springboot_simple_post.dto.PersonDTO;

public interface PersonRepository {

	void persist(PersonDTO personDTO);
}
