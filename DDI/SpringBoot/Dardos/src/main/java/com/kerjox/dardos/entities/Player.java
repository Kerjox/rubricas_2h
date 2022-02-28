package com.kerjox.dardos.entities;

import com.kerjox.dardos.modes.Mode;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class Player {

	@Autowired
	private Mode mode;

	private String name;
	private Integer puntos;
	private List<Tirada> tiradas;

	public Player(String name) {
		this.name = name;
		this.puntos = 0;
		this.tiradas = new ArrayList<>();
	}

	public Integer getPuntos() {
		return puntos;
	}

	public void setPuntos(Integer puntos) {
		this.puntos = puntos;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Tirada> getTiradas() {
		return tiradas;
	}

	public void setTiradas(List<Tirada> tiradas) {
		this.tiradas = tiradas;
	}

	public boolean tirar() {

		Tirada tirada = new Tirada();

		for (int i = 0; i < 3; i++) {

			int puntosJugador = tirada.tirarDardo() + puntos;

			if (puntosJugador > mode.getMaxPoints()) {

				return false;
			}

			if (puntosJugador == mode.getMaxPoints()) {

				this.tiradas.add(tirada);
				return true;
			}
		}

		this.tiradas.add(tirada);
		return false;
	}
}
