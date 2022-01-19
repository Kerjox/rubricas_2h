package com.kerjox.ahorcado.utils;


public abstract class AhorcadoUtils {

	public static char[] getVocals() {

		return "aeiou".toUpperCase().toCharArray();
	}

	public static char[] getAlphabet(boolean includeVocals) {

		if (includeVocals) {

			return "abcdefghijklmnñopqrstuvwxyz".toUpperCase().toCharArray();
		} else {

			return "bcdfghjklmnñpqrstvwxyz".toUpperCase().toCharArray();
		}
	}

	public static char[] getAlphabet() {

			return "abcdefghijklmnñopqrstuvwxyz".toUpperCase().toCharArray();
	}
}
