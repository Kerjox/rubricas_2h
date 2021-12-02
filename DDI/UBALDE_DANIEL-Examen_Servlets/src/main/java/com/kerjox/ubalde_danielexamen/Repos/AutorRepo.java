package com.kerjox.ubalde_danielexamen.Repos;

import com.kerjox.ubalde_danielexamen.Entities.Autor;
import com.kerjox.ubalde_danielexamen.connection.AbstractConnection;
import com.kerjox.ubalde_danielexamen.connection.H2Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AutorRepo {

	private final AbstractConnection manager = new H2Connection();

	public List<Autor> findAll() {

		Connection conn = manager.open();
		PreparedStatement statement = null;
		List<Autor> autorList = new ArrayList<>();

		try {
			statement = conn.prepareStatement("SELECT * FROM autores");
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				Autor a = new Autor();
				a.setId(rs.getInt("autor_id"));
				a.setNombre(rs.getString("nombre"));
				a.setApellido(rs.getString("apellido"));
				a.setSeudonimo(rs.getString("seudonimo"));
				autorList.add(a);
			}

			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {

			manager.close(statement);
			manager.close(conn);
		}

		return autorList;
	}

	public List<Autor> findByNombreOrApellido(String nombre, String apellido) {

		Connection conn = manager.open();
		PreparedStatement statement = null;
		List<Autor> autorList = new ArrayList<>();

		try {
			statement = conn.prepareStatement("SELECT * FROM autores WHERE NOMBRE = ? OR APELLIDO = ?");
			statement.setString(1, nombre);
			statement.setString(2, apellido);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				Autor a = new Autor();
				a.setId(rs.getInt("autor_id"));
				a.setNombre(rs.getString("nombre"));
				a.setApellido(rs.getString("apellido"));
				a.setSeudonimo(rs.getString("seudonimo"));
				autorList.add(a);
			}

			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {

			manager.close(statement);
			manager.close(conn);
		}

		return autorList;
	}

	public Autor findById(Integer id) {

		Connection conn = manager.open();
		PreparedStatement statement = null;
		Autor autor = new Autor();

		try {
			statement = conn.prepareStatement("SELECT * FROM autores WHERE AUTOR_ID = ?");
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				autor.setId(rs.getInt("autor_id"));
				autor.setSeudonimo(rs.getString("seudonimo"));
			}

			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {

			manager.close(statement);
			manager.close(conn);
		}

		return autor;
	}

	public void updateSeudonimo(Integer id, String seudonimo) {

		Connection conn = manager.open();
		PreparedStatement statement = null;

		try {
			statement = conn.prepareStatement("UPDATE AUTORES SET SEUDONIMO = ? WHERE AUTOR_ID = ?");
			statement.setString(1, seudonimo);
			statement.setInt(2, id);

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

		// Borramos los libros alquilados del autor
		LibrosUsuarioRepo librosUsuarioRepo = new LibrosUsuarioRepo();
		librosUsuarioRepo.deleteByIdAutor(id);

		// Borramos los libros del autor
		LibrosRepo librosRepo = new LibrosRepo();
		librosRepo.deleteAllLibrosAutor(id);


		Connection conn = manager.open();
		PreparedStatement statement = null;

		try {
			statement = conn.prepareStatement("DELETE FROM AUTORES WHERE AUTOR_ID = ?");
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
