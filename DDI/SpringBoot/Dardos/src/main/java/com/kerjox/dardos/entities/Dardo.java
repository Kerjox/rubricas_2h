package com.kerjox.dardos.entities;

import java.util.Random;

public class Dardo {

	public static final int X2 = 2;
	public static final int X3 = 3;

	private Integer puntos;
	private Integer multiplicador;

	public Dardo() {

		int number = ((int) (Math.random() * 22)) + 1;

		if (number <= 20) {

			this.puntos = number;
			this.multiplicador = ((int) (Math.random() * 3)) + 1;
		} else if (number == 21) {

			this.puntos = 25;
			this.multiplicador = 1;
		} else if (number == 22) {

			this.puntos = 50;
			this.multiplicador = 1;
		}
	}

	public Integer getPoints() {

		return this.puntos * this.multiplicador ;
	}
}
