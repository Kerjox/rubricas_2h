package com.kerjox.ahorcado.entities;

import jdk.jfr.Unsigned;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.management.ConstructorParameters;
import java.util.Arrays;
import java.util.List;

public class Ahorcado {

	private char[] word;
	private boolean[] wordMask;

	@Unsigned
 	private int tries;
	private List<Character> lettersChecked;

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

	public Ahorcado(String word, int tries) {

		this.tries = tries;
		this.word = word.toUpperCase().toCharArray();
		this.wordMask = new boolean[word.length()];

		Arrays.fill(this.wordMask, false);
	}

	public void setTrueWordMask(int i) {

		this.wordMask[i] = true;
	}
}
