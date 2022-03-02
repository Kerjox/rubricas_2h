package com.kerjox.mastermindapi.controllers;

import com.kerjox.mastermindapi.entities.Answer;
import com.kerjox.mastermindapi.entities.Key;
import com.kerjox.mastermindapi.entities.ScoreBoard;
import com.kerjox.mastermindapi.entities.Tries;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:8080/")
@RequestMapping("/api/")
public class MasterMindRestController {

	@GetMapping("generateKey")
	public ResponseEntity<Key> generateNewKey(@RequestBody Key key) {

		key.setGeneratedKey("Kerjox");
		return new ResponseEntity<>(key, HttpStatus.OK);
	}

	@GetMapping("changeTries")
	public ResponseEntity<Tries> changeTries(@RequestParam("tries") int newTries) {

		Tries tries = new Tries();

		tries.setTries(newTries);

		return new ResponseEntity<>(tries, HttpStatus.OK);
	}

	@GetMapping("answerSize/{size}")
	public ResponseEntity<Key> answerSize(@PathVariable int size) {

		Key key = new Key();

		key.setSize(size);

		if (size == 3) {

			key.setGeneratedKey("rojo,azul,naranja");
		}

		if (size == 5) {

			key.setGeneratedKey("rojo,azul,naranja,rosa,verde");
		}

		if (size == 7) {

			key.setGeneratedKey("rojo,azul,naranja,rosa,verde,amarillo,gris");
		}

		return new ResponseEntity<>(key, HttpStatus.OK);
	}

	@GetMapping("checkAnswer")
	public ResponseEntity<Answer> checkAnswer(@RequestBody Answer answer) {

		answer.setMessage("CORRECT");
		return new ResponseEntity<>(answer, HttpStatus.ACCEPTED);
	}

	@PostMapping("checkTries")
	public ResponseEntity<Tries> checkTries() {

		Tries tries = new Tries();

		tries.setLefttries(5);
		return new ResponseEntity<>(tries, HttpStatus.CREATED);
	}

	@PostMapping("saveRecordScore")
	public ResponseEntity<Key> saveRecordScore() {

		Key key = new Key();

		return new ResponseEntity<>(key, HttpStatus.CREATED);
	}

	@GetMapping("listScoreboard")
	public ResponseEntity<List<ScoreBoard>> listScoreboard(@RequestParam("maxSize") int maxSize) {

		List<ScoreBoard> scoreBoards = new ArrayList<>();

		for (int i = 0; i < maxSize; i++) {

			scoreBoards.add(new ScoreBoard());
		}

		return new ResponseEntity<>(scoreBoards, HttpStatus.OK);
	}
}
