package com.kerjox.practica_examen_jdbc.entities;

import java.util.List;

public class Titulacion {

	private Integer id;
	private String name;
	private List<Alumno> alumnosList;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Alumno> getAlumnosList() {
		return alumnosList;
	}

	public void setAlumnosList(List<Alumno> alumnosList) {
		this.alumnosList = alumnosList;
	}
}
