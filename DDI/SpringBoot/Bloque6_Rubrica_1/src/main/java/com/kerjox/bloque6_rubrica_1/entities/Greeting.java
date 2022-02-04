package com.kerjox.bloque6_rubrica_1.entities;

public class Greeting {

	private String player;
	private String message;

	public Greeting(String player, String message) {
		this.player = player;
		this.message = message;
	}

	public String getPlayer() {
		return player;
	}

	public void setPlayer(String player) {
		this.player = player;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
