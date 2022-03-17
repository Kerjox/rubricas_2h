package com.kerjox.mvc.entities;

import com.kerjox.mvc.utils.BingoUtils;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;


@Getter
@Setter
public class Carton {

	private HashSet<Integer> numeros;
	private Integer numerosAcertados;

	public Carton() {

		this.numerosAcertados = 0;
		this.numeros = new HashSet<>();

		while (numeros.size() < 15) {

			numeros.add(BingoUtils.generateRandom(1, 90));
		}
	}

	@Override
	public String toString() {
		return "Carton{" + "numeros=" + numeros + ", numerosAcertados=" + numerosAcertados + '}';
	}

	public void aumentarNumerosAcertados() {

		this.numerosAcertados++;
	}
}
