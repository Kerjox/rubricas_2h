package com.kerjox.mastermindapi.controllers;

import com.kerjox.mastermindapi.entities.Answer;
import com.kerjox.mastermindapi.entities.Key;
import com.kerjox.mastermindapi.entities.ScoreBoard;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:8080/")
@RequestMapping("/api/")
public class MasterMindRestController {

	private Key key = new Key();

	@GetMapping("generateKey")
	public ResponseEntity<Key> generateNewKey(@RequestBody Key key) {

		key.setGeneratedKey("rojo,azul,naranja,rosa,verde");
		return new ResponseEntity<>(key, HttpStatus.OK);
	}

	@GetMapping("changeTries")
	public ResponseEntity<Key> changeTries(@RequestParam("tries") int newTries) {

		key.setTries(newTries);

		return new ResponseEntity<>(key, HttpStatus.OK);
	}

	@GetMapping("answerSize/{size}")
	public ResponseEntity<Key> answerSize(@PathVariable int size) {

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

		String[] generatedKey = key.getGeneratedKey().split(",");

		if (generatedKey.length != answer.getAnswer().length) {

			return new ResponseEntity<>(Answer.builder().message("answer size invalid").reason("answer size invalid").build(), HttpStatus.ACCEPTED);
		}

		if (Arrays.equals(generatedKey, answer.getAnswer())) {

			return new ResponseEntity<>(Answer.builder().message("answer correct").build(), HttpStatus.ACCEPTED);
		} else {

			return new ResponseEntity<>(Answer.builder().message("answer incorrect").build(), HttpStatus.ACCEPTED);
		}
	}

	@PostMapping("checkTries")
	public ResponseEntity<Key> checkTries() {

		key.setLefttries(key.getTries());
		return new ResponseEntity<>(key, HttpStatus.CREATED);
	}

	@PostMapping("saveRecordScore")
	public ResponseEntity saveRecordScore() {

		return new ResponseEntity(HttpStatus.CREATED);
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
