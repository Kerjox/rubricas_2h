package com.kerjox.ahorcado.services;

import com.kerjox.ahorcado.entities.Ahorcado;
import com.kerjox.ahorcado.levels.Level;
import com.kerjox.ahorcado.utils.WordGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.stream.Collectors;

@Service
public class AhorcadoService {

	@Autowired
	private Ahorcado ahorcado;

	@Autowired
	private WordGenerator wg;

	@Autowired
	private Level level;

	public void checkLetter(char letter) {

		if (ahorcado.getLettersChecked() == null) {
			initGame();
		}
		letter = Character.toUpperCase(letter);

		int i = 0;
		for (char l : ahorcado.getWord()) {

			if (l == letter && !ahorcado.getLettersChecked().contains(letter)) {

				ahorcado.getLettersChecked().add(letter);
			}
			i++;
		}

		System.out.printf("Letra %s\n", letter);
		System.out.println(ahorcado.getWord());
		System.out.println(ahorcado.getWordToShow());
		System.out.printf("%s - %s\n", ahorcado.getLettersChecked().size(), ahorcado.getWordLetters());
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

		word = Normalizer.normalize(word, Normalizer.Form.NFD)
						.toUpperCase().replaceAll("[^A-Z] ", "");

		ahorcado.setWord(word.toCharArray());
		ahorcado.setWordToShow(wordToShow.toCharArray());
		ahorcado.setTries(level.getTries());
		ahorcado.setLettersChecked(new ArrayList<>());
		ahorcado.setWordLetters(calcWordLetters(word));
	}

	private int calcWordLetters(String word) {

		word = word.replace(" ", "");

		HashSet<Character> letters =
						new HashSet<>(word.chars()
										.mapToObj(n -> (char) n)
										.collect(Collectors.toList()));

		return letters.size();
	}
}
