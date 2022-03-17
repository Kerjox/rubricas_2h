package com.kerjox.dardos.entities;

import com.kerjox.dardos.modes.Mode;

import java.util.ArrayList;
import java.util.List;


public class Player {

	private Mode mode;
	private String name;
	private Integer idTirada;
	private Integer puntos;
	private boolean winner;
	private List<Tirada> tiradas;
	private Tirada tiradaActual;

	public Player() {

		this.idTirada = 1;
		this.puntos = 0;
	}

	public Player(String name, Mode mode) {

		this.idTirada = 1;
		this.name = name;
		this.puntos = 0;
		this.mode = mode;
		this.winner = false;
		this.tiradas = new ArrayList<>();
	}

	public Mode getMode() {
		return mode;
	}

	public void setMode(Mode mode) {
		this.mode = mode;
	}

	public Tirada getTiradaActual() {
		return tiradaActual;
	}

	public void setTiradaActual(Tirada tiradaActual) {
		this.tiradaActual = tiradaActual;
	}

	public boolean isWinner() {
		return winner;
	}

	public void setWinner(boolean winner) {
		this.winner = winner;
	}

	public Integer getIdTirada() {
		return idTirada;
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

	public void tirar() {

		Tirada tirada = new Tirada(idTirada);

		for (int i = 0; i < 3; i++) {

			tirada.tirarDardo();
			Integer puntosJugador = tirada.getPuntosTirada() + puntos;

			if (puntosJugador > mode.getMaxPoints()) {

				this.idTirada++;
				return;
			}

			if (puntosJugador.equals(mode.getMaxPoints())) {

				this.winner = true;
				break;
			}
		}

		puntos += tirada.getPuntosTirada();
		this.tiradas.add(tirada);
		this.idTirada++;
	}
}
