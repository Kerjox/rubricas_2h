package com.kerjox.mvc.utils;

public class BingoUtils {

	public static Integer generateRandom(Integer min, Integer max) {

		return (int) (Math.random() * max) + min;
	}
}
