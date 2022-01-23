package com.kerjox.ahorcado.entities;

import jdk.jfr.Unsigned;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Ahorcado {

	private char[] word;
	private char[] wordToShow;
	@Unsigned
	private int tries;
	private List<Character> lettersChecked;
	private int wordLetters;

	public int getWordLetters() {
		return wordLetters;
	}

	public void setWordLetters(int wordLetters) {
		this.wordLetters = wordLetters;
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
}
