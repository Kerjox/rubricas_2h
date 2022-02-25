package com.kerjox.mastermindapi.controllers;

import com.kerjox.mastermindapi.entities.Key;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:8080/")
@RequestMapping("/api/")
public class MasterMindRestController {

	@GetMapping("generatekey")
	public ResponseEntity<Key> generateNewKey(@RequestBody Key key) {

		key.setGeneratedKey("Kerjox");
		return new ResponseEntity<>(key, HttpStatus.OK);
	}
}
