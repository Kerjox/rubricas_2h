package com.kerjox.mastermindapi.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Key {

	private int size;
	private int tries;
	private int lefttries;
	private String generatedKey;

	public int getSize() {
		return size;
	}
}
