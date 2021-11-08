package com.ubalde.bloque3_rubrica_5.repos;

import com.ubalde.bloque3_rubrica_5.connection.AbstractConnection;
import com.ubalde.bloque3_rubrica_5.connection.H2Connection;
import com.ubalde.bloque3_rubrica_5.entities.Persona;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonaRepo {

	private static final String JDBC_URL = "jdbc:h2:file:./src/main/resources/test;INIT=RUNSCRIPT FROM 'classpath:init.sql'";
	AbstractConnection manager = new H2Connection();

	public void Insert(Persona persona) {

		Connection conn = manager.open(JDBC_URL);
		PreparedStatement statement = null;
		try {

			statement = conn.prepareStatement("INSERT INTO PERSONAS SET name = ?, birthday = ?, age = ?, step = ?;");
			statement.setString(1, persona.getName());
			statement.setDate(2, persona.getBirthday());
			statement.setInt(3, persona.getAge());
			statement.setInt(4, persona.getStep());
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {

			manager.close(statement);
			manager.close(conn);
		}

	}

	public List<Persona> findAll() {

		Connection conn = manager.open(JDBC_URL);
		PreparedStatement statement = null;
		List<Persona> personas = new ArrayList<>();

		try {
			statement = conn.prepareStatement("SELECT * FROM PERSONAS");
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				Persona p = new Persona();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setAge(rs.getInt("age"));
				p.setBirthday(rs.getDate("birthday"));
				p.setStep(rs.getInt("step"));

				personas.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {

			manager.close(statement);
			manager.close(conn);
		}

		return personas;
	}

	public void update(Persona persona) {

		Connection conn = manager.open(JDBC_URL);
		PreparedStatement statement = null;

		try {
			statement = conn.prepareStatement("UPDATE PERSONAS SET NAME = ?, AGE = ?, BIRTHDAY = ?, STEP = ? WHERE ID = ?");
			statement.setString(1, persona.getName());
			statement.setInt(2, persona.getAge());
			statement.setDate(3, persona.getBirthday());
			statement.setInt(4, persona.getStep());
			statement.setInt(5, persona.getId());

			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {

			manager.close(statement);
			manager.close(conn);
		}
	}
}
