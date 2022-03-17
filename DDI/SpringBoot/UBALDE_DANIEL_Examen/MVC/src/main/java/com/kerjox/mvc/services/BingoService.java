package com.kerjox.mvc.services;

import com.kerjox.mvc.entities.Carton;
import com.kerjox.mvc.utils.BingoUtils;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
@Getter
@Setter
public class BingoService {

	private Carton carton;
	private HashSet<Integer> numerosSacados;
	private Integer lastNumber;
	private boolean stop;

	public BingoService() {

		this.stop = false;
		this.carton = new Carton();
		this.numerosSacados = new HashSet<>();
	}

	public void autoPlay() {

		while (!this.stop) {

			play();
		}
	}

	public void play() {

		if (stop) return;

		Integer randomNumber = sacarBola();

		if (carton.getNumeros().contains(randomNumber)) {

			carton.aumentarNumerosAcertados();
			checkWin();
		}

	}

	protected void checkWin() {
		if (carton.getNumerosAcertados().equals(15))
			this.stop = true;
	}

	protected Integer sacarBola() {

		Integer random;

		do {
			random = BingoUtils.generateRandom(1, 90);

		} while (!numerosSacados.add(random));

		this.lastNumber = random;
		return random;
	}
}
