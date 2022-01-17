package com.kerjox.ahorcado.entities;

import jdk.jfr.Unsigned;

import java.text.Normalizer;
import java.util.Arrays;
import java.util.List;

public class Ahorcado {

	private char[] word;
	private char[] wordToShow;
	private boolean[] wordMask;
	@Unsigned
	private int tries;
	private List<Character> lettersChecked;

	public Ahorcado(String word, int tries) {
		word = "Ciudad Real";

		this.tries = tries;
		this.wordToShow = word.toUpperCase().replaceAll("[^A-Z] ", "").toCharArray();
		this.wordMask = new boolean[word.length()];
		this.word = Normalizer.normalize(word, Normalizer.Form.NFD)
						.toUpperCase()
						.replaceAll("[^A-Z] ", "")
						.toCharArray();

		Arrays.fill(this.wordMask, false);
		markSpacesToTrue();
	}

	private void markSpacesToTrue() {

		for (int i = 0; i < this.wordMask.length; i++) {

			if (this.word[i] == ' ') {

				this.wordMask[i] = true;
			}
		}
	}

	public char[] getWordToShow() {
		return wordToShow;
	}

	public void setWordToShow(char[] wordToShow) {
		this.wordToShow = wordToShow;
	}

	public List<Character> getLettersChecked() {
		return lettersChecked;
	}

	public void setLettersChecked(List<Character> lettersChecked) {
		this.lettersChecked = lettersChecked;
	}

	public int getTries() {
		return tries;
	}

	public void setTries(int tries) {
		this.tries = tries;
	}

	public char[] getWord() {
		return word;
	}

	public void setWord(char[] word) {
		this.word = word;
	}

	public boolean[] getWordMask() {
		return wordMask;
	}

	public void setWordMask(boolean[] wordMask) {
		this.wordMask = wordMask;
	}

	public void setTrueWordMask(int i) {

		this.wordMask[i] = true;
	}
}
