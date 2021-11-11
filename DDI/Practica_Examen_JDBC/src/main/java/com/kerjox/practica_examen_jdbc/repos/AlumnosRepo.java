package com.kerjox.practica_examen_jdbc.repos;

import com.kerjox.practica_examen_jdbc.connection.AbstractConnection;
import com.kerjox.practica_examen_jdbc.connection.H2Connection;
import com.kerjox.practica_examen_jdbc.entities.Alumno;
import com.kerjox.practica_examen_jdbc.entities.Titulacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlumnosRepo {

	private static final String JDBC_URL = "jdbc:h2:file:./src/main/resources/test;INIT=RUNSCRIPT FROM 'classpath:/scripts/init.sql'";
	AbstractConnection manager = new H2Connection();

	public void insert(Alumno alumno) {

		Connection conn = manager.open(JDBC_URL);
		PreparedStatement statement = null;
		try {

			statement = conn.prepareStatement("INSERT INTO ALUMNOS SET NOMBRE = ?, EDAD = ?, TITULACION = ?;");
			statement.setString(1, alumno.getName());
			statement.setInt(2, alumno.getEdad());
			statement.setInt(3, alumno.getTitulacion().getId());

			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {

			manager.close(statement);
			manager.close(conn);
		}

	}

	public List<Alumno> findAll() {

		Connection conn = manager.open(JDBC_URL);
		PreparedStatement statement = null;
		List<Alumno> alumnosList = new ArrayList<>();

		try {
			statement = conn.prepareStatement("SELECT * FROM ALUMNOS");
			ResultSet rs = statement.executeQuery();

			TitulacionRepo titulacionRepo = new TitulacionRepo();

			while (rs.next()) {

				Alumno a = new Alumno();
				a.setId(rs.getInt("id"));
				a.setName(rs.getString("nombre"));
				a.setEdad(rs.getInt("edad"));
				a.setTitulacion(titulacionRepo.findById(rs.getInt("titulacion")));
				alumnosList.add(a);
			}

			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {

			manager.close(statement);
			manager.close(conn);
		}

		return alumnosList;
	}

	public void update(Titulacion titulacion) {

		Connection conn = manager.open(JDBC_URL);
		PreparedStatement statement = null;

		try {
			statement = conn.prepareStatement("UPDATE TITULACIONES SET TITULO = ? WHERE ID = ?");
			statement.setString(1, titulacion.getName());
			statement.setInt(2, titulacion.getId());

			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {

			manager.close(statement);
			manager.close(conn);
		}
	}

	public void delete(Integer id) {

		Connection conn = manager.open(JDBC_URL);
		PreparedStatement statement = null;

		try {
			statement = conn.prepareStatement("DELETE FROM TITULACIONES WHERE ID = ?");
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
