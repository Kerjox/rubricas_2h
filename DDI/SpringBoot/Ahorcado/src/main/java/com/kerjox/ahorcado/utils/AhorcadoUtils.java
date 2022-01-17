package com.kerjox.ahorcado.utils;

public class AhorcadoUtils {

	public static String getRandomWord(String[] words) {

		return words[(int) (Math.random() * words.length)];
	}

	public static char[] getAlphabet() {

		return "abcdefghijklmnñopqrstuvwxyz".toUpperCase().toCharArray();
	}
}
