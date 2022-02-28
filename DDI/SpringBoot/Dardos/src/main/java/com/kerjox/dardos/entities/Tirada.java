package com.kerjox.dardos.entities;

import java.util.ArrayList;
import java.util.List;

public class Tirada {

	private List<Dardo> dardos;

	public Tirada() {

		this.dardos = new ArrayList<>();
	}

	public int tirarDardo() {

		Dardo dardo = new Dardo();
		dardos.add(dardo);

		return dardo.getPoints();
	}
}
