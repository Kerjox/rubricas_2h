package com.kerjox.ahorcado.services;

import com.kerjox.ahorcado.entities.Ahorcado;
import com.kerjox.ahorcado.levels.Easy;
import com.kerjox.ahorcado.levels.Level;
import com.kerjox.ahorcado.utils.WordGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AhorcadoService {

	@Autowired
	private Ahorcado ahorcado;

	public void checkLetter(char letter) {

		letter = Character.toUpperCase(letter);

		int i = 0;
		for (char l : ahorcado.getWord()) {

			if (l == letter) {

				ahorcado.setTrueWordMask(i);
			}
			i++;
		}
	}

	public char[] getWord() {

		return ahorcado.getWord();
	}

	public char[] getWordToShow() {

		return ahorcado.getWordToShow();
	}

	public boolean[] getWordMask() {

		return ahorcado.getWordMask();
	}

	public Ahorcado getAhorcado() {

		return this.ahorcado;
	}

	public void setAhorcado(Ahorcado ahorcado) {
		this.ahorcado = ahorcado;
	}
}
