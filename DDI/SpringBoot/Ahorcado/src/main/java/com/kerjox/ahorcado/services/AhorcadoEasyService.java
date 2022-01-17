package com.kerjox.ahorcado.services;

import com.kerjox.ahorcado.entities.Ahorcado;
import com.kerjox.ahorcado.utils.AhorcadoUtils;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service("ahorcado")
@Profile(value = "easy")
public class AhorcadoEasyService implements AhorcadoService {

	private final Ahorcado ahorcadoEntity;

	@Override
	public Ahorcado getAhorcado() {
		return ahorcadoEntity;
	}

	public AhorcadoEasyService() {

		String[] words = {"hola", "alcachofa"};


		this.ahorcadoEntity = new Ahorcado(AhorcadoUtils.getRandomWord(words).toUpperCase(), 10);

	}
}
