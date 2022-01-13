package com.ubalde.bloque3_rubrica_5.repos;

import com.ubalde.bloque3_rubrica_5.connection.AbstractConnection;
import com.ubalde.bloque3_rubrica_5.connection.H2Connection;
import com.ubalde.bloque3_rubrica_5.entities.Persona;
import com.ubalde.bloque3_rubrica_5.utils.Utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonaRepo {

	private static final String JDBC_URL = "jdbc:h2:file:./src/main/resources/test;INIT=RUNSCRIPT FROM 'classpath:init.sql'";
	AbstractConnection manager = new H2Connection();

	public void insert(Persona persona) {

		Connection conn = manager.open(JDBC_URL);
		PreparedStatement statement = null;
		try {

			statement = conn.prepareStatement("INSERT INTO PERSONAS SET name = ?, birthday = ?, step = ?;");
			statement.setString(1, persona.getName());
			statement.setDate(2, persona.getBirthday());
			statement.setInt(3, persona.getStep());
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
				p.setBirthday(rs.getDate("birthday"));
				p.setAge(Utils.getAge(p.getBirthday()));
				p.setStep(rs.getInt("step"));

				personas.add(p);
			}

			rs.close();
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
			statement = conn.prepareStatement("UPDATE PERSONAS SET NAME = ?, BIRTHDAY = ?, STEP = ? WHERE ID = ?");
			statement.setString(1, persona.getName());
			statement.setDate(2, persona.getBirthday());
			statement.setInt(3, persona.getStep());
			statement.setInt(4, persona.getId());

			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {

			manager.close(statement);
			manager.close(conn);
		}
	}

	public void insertOrUpdate(Persona persona) {

		Persona personaDb = findByName(persona.getName());
		if (personaDb != null) {

			persona.setId(personaDb.getId());
			update(persona);

		} else {

			insert(persona);
		}
	}

	public Persona findByName(String name) {

		if (name == null) {

			throw new RuntimeException("No name provided on findByName");
		}

		Connection conn = manager.open(JDBC_URL);
		PreparedStatement statement = null;
		Persona persona = new Persona();

		try {
			statement = conn.prepareStatement("SELECT * FROM PERSONAS WHERE NAME = ?");
			statement.setString(1, name);

			ResultSet rs = statement.executeQuery();
			Integer i = 0;
			while (rs.next()) {

				persona.setId(rs.getInt("id"));
				persona.setName(rs.getString("name"));
				persona.setBirthday(rs.getDate("birthday"));
				persona.setAge(Utils.getAge(persona.getBirthday()));
				persona.setStep(rs.getInt("step"));
				i++;
			}

			rs.close();

			if (i == 0) {
				persona = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {

			manager.close(statement);
			manager.close(conn);
		}

		return persona;
	}

	public void delete(Integer id) {

		Connection conn = manager.open(JDBC_URL);
		PreparedStatement statement = null;

		try {
			statement = conn.prepareStatement("DELETE FROM PERSONAS WHERE ID = ?");
			statement.setInt(1, id);

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
