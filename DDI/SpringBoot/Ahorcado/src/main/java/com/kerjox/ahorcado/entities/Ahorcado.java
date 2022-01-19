package com.kerjox.ahorcado.entities;

import jdk.jfr.Unsigned;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Ahorcado {

	private char[] word;
	private char[] wordToShow;
	private boolean[] wordMask;
	@Unsigned
	private int tries;
	private List<Character> lettersChecked;

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
