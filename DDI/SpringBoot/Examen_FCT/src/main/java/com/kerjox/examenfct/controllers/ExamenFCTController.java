package com.kerjox.examenfct.controllers;

import com.kerjox.examenfct.entities.Alumno;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:8080")
@RequestMapping("/api/")
public class ExamenFCTController {

	private List<Alumno> alumnos = new ArrayList<>();

	@PostMapping("ALUMNOS/LIST")
	public ResponseEntity<List<Alumno>> listAlumnos() {

		return new ResponseEntity(alumnos, HttpStatus.OK);
	}

	@PostMapping("ALUMNOS/INSERT")
	public ResponseEntity<Alumno> insertAlumno(@RequestBody Alumno alumno) {

		alumnos.add(alumno);

		return new ResponseEntity<Alumno>(alumno, HttpStatus.CREATED);
	}

	@GetMapping("ALUMNOS/DELETE")
	public ResponseEntity deleteAlumno(@RequestParam("id") Integer id) {

		alumnos.remove(id);

		if (id == 0) {

			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(HttpStatus.OK);
	}

	@GetMapping("ALUMNOS/UPDATE/{id}")
	public ResponseEntity<Alumno> updateAlumno(@PathVariable("id") Integer id, @RequestParam String fct) {

		if (id == 0) {

			return new ResponseEntity<Alumno>(new Alumno(), HttpStatus.CONFLICT);
		}

		id = id - 1;
		Alumno alumno = alumnos.get(id);
		alumno.setFct(fct);



		return new ResponseEntity<Alumno>(alumno, HttpStatus.ACCEPTED);
	}

	@GetMapping("ALUMNOS/DELETEALL")
	public ResponseEntity<Alumno> deleteAll() {

		alumnos.clear();

		return new ResponseEntity<Alumno>(new Alumno(), HttpStatus.OK);
	}
}
