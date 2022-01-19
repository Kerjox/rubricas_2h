package com.kerjox.ahorcado.services;

import com.kerjox.ahorcado.entities.Ahorcado;
import com.kerjox.ahorcado.levels.Level;
import com.kerjox.ahorcado.utils.WordGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.Normalizer;
import java.util.Arrays;

@Service
public class AhorcadoService {

	@Autowired
	private Ahorcado ahorcado;

	@Autowired
	private WordGenerator wg;

	@Autowired
	private Level level;

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

	public void initGame() {

		String word = wg.generateNewWord(level.getMinLength(), level.getMaxLength());
		String wordToShow = word.toUpperCase().replaceAll("[^A-Z] ", "");

		word = Normalizer.normalize(word, Normalizer.Form.NFD).toUpperCase().replaceAll("[^A-Z] ", "");

		ahorcado.setWord(word.toCharArray());
		ahorcado.setWordToShow(wordToShow.toCharArray());
		ahorcado.setTries(level.getTries());
		ahorcado.setWordMask(generateMaskForWord(word.toCharArray()));
	}

	private boolean[] generateMaskForWord(char[] word) {

		boolean[] mask = new boolean[word.length];
		Arrays.fill(mask, false);

		for (int i = 0; i < mask.length; i++) {

			if (word[i] == ' ' || word[i] == '-') {

				mask[i] = true;
			}
		}

		return mask;
	}
}
