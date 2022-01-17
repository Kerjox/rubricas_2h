package com.kerjox.ahorcado.services;

import com.kerjox.ahorcado.entities.Ahorcado;

public interface AhorcadoService {

	Ahorcado getAhorcado();

	default void checkLetter(char letter) {

		assert false;
		letter = Character.toUpperCase(letter);

		int i = 0;
		for (char l : getAhorcado().getWord()) {

			if (l == letter) {

				boolean[] wordMask = getAhorcado().getWordMask();
				wordMask[i] = true;

				getAhorcado().setWordMask(wordMask);
			}
			i++;
		}
	}

	default char[] getWord() {

		assert false;
		return getAhorcado().getWord();
	};

	default boolean[] getWordMask() {

		assert false;
		return getAhorcado().getWordMask();
	};
}
