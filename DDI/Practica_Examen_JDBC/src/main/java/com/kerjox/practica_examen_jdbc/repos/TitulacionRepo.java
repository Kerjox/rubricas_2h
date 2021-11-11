package com.kerjox.practica_examen_jdbc.repos;

import com.kerjox.practica_examen_jdbc.connection.AbstractConnection;
import com.kerjox.practica_examen_jdbc.connection.H2Connection;
import com.kerjox.practica_examen_jdbc.entities.Titulacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TitulacionRepo {

	private static final String JDBC_URL = "jdbc:h2:file:./src/main/resources/test;INIT=RUNSCRIPT FROM 'classpath:/scripts/init.sql'";
	AbstractConnection manager = new H2Connection();

	public void insert(Titulacion titulacion) {

		Connection conn = manager.open(JDBC_URL);
		PreparedStatement statement = null;
		try {

			statement = conn.prepareStatement("INSERT INTO TITULACIONES SET TITULO = ?;");
			statement.setString(1, titulacion.getName());
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {

			manager.close(statement);
			manager.close(conn);
		}

	}

	public List<Titulacion> findAll() {

		Connection conn = manager.open(JDBC_URL);
		PreparedStatement statement = null;
		List<Titulacion> titulacion = new ArrayList<>();

		try {
			statement = conn.prepareStatement("SELECT * FROM TITULACIONES");
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				Titulacion t = new Titulacion();
				t.setId(rs.getInt("id"));
				t.setName(rs.getString("titulo"));

				titulacion.add(t);
			}

			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {

			manager.close(statement);
			manager.close(conn);
		}

		return titulacion;
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

	public Titulacion findById(Integer id) {

		Connection conn = manager.open(JDBC_URL);
		PreparedStatement statement = null;
		Titulacion titulacion = new Titulacion();

		try {
			statement = conn.prepareStatement("SELECT * FROM TITULACIONES WHERE ID = ?");
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				titulacion.setId(rs.getInt("id"));
				titulacion.setName(rs.getString("titulo"));
			}

			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {

			manager.close(statement);
			manager.close(conn);
		}

		return titulacion;
	}
}