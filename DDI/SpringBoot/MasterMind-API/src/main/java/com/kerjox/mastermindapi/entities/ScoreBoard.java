package com.kerjox.mastermindapi.entities;

public class ScoreBoard {

	private String initial;
	private String name;
	private int tries;

	public ScoreBoard() {

		this.initial = "JA";
		this.name = "Juan Apellaniz";
		this.tries = 10;
	}

	public String getInitial() {
		return initial;
	}

	public void setInitial(String initial) {
		this.initial = initial;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTries() {
		return tries;
	}

	public void setTries(int tries) {
		this.tries = tries;
	}
}
