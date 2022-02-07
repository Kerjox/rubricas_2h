package com.kerjox.bloque5_rubrica_6springboot_simple_post.repos;

import com.kerjox.bloque5_rubrica_6springboot_simple_post.dto.PersonDTO;
import org.springframework.stereotype.Repository;

@Repository
public class PersonRepositoryImpl implements PersonRepository {

	@Override
	public void persist(final PersonDTO personDTO) {
		// implementation of persisting to database
	}
}
