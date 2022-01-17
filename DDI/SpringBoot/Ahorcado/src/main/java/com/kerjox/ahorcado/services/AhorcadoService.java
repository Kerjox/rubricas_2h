package com.kerjox.ahorcado.services;

import com.kerjox.ahorcado.entities.Ahorcado;
import com.kerjox.ahorcado.levels.Easy;
import com.kerjox.ahorcado.levels.Level;
import com.kerjox.ahorcado.utils.WordGenerator;
import org.springframework.stereotype.Service;

@Service
public class AhorcadoService {

	private Ahorcado ahorcado;

	private final WordGenerator wordGenerator;

	private final Level level;

	public AhorcadoService() {

		this.level = new Easy();
		this.wordGenerator = new WordGenerator();
		this.ahorcado = new Ahorcado(wordGenerator.getWord(level.getMaxLength()), level.getTries());
	}

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
