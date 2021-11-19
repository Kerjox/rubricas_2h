package com.kerjox.practica_examen_jdbc.repos;

import java.util.List;

public interface Repo<T> {

	String JDBC_URL = "jdbc:h2:file:./src/main/resources/test;INIT=RUNSCRIPT FROM 'classpath:/scripts/init.sql'";

	void insert(T t);
	List<T> findAll();
	void delete(Integer i);
	void update(T t);
	T findById(Integer i);
}
