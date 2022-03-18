package com.kerjox.dardos.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Tirada {

	private final List<Dardo> dardos;
	private final Integer id;
	private Integer puntosTirada;

	public Tirada(int id) {

		this.id = id;
		this.dardos = new ArrayList<>();
		this.puntosTirada = 0;
	}

	public void tirarDardo() {

		Dardo dardo = new Dardo();
		dardos.add(dardo);
		puntosTirada += dardo.getPoints();
	}
}
