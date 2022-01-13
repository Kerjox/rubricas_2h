package com.kerjox.ubalde_danielexamen.Repos;

import com.kerjox.ubalde_danielexamen.Entities.Libro;
import com.kerjox.ubalde_danielexamen.connection.AbstractConnection;
import com.kerjox.ubalde_danielexamen.connection.H2Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LibrosRepo {

	private final AbstractConnection manager = new H2Connection();


	public List<Libro> findByAutorNombreOrApellido(String nombre, String apellido) {

		Connection conn = manager.open();
		PreparedStatement statement = null;
		List<Libro> libroList = new ArrayList<>();

		try {
			statement = conn.prepareStatement("SELECT L.TITULO as titulo, L.DESCRIPCION AS descripcion FROM LIBROS L " +
							"INNER JOIN AUTORES A on A.AUTOR_ID = L.AUTOR_ID WHERE A.NOMBRE = ? OR A.APELLIDO = ?");
			statement.setString(1, nombre);
			statement.setString(2, apellido);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				Libro libro = new Libro();
				libro.setTitulo(rs.getString("titulo"));
				libro.setDescripcion(rs.getString("descripcion"));
				libroList.add(libro);
			}

			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {

			manager.close(statement);
			manager.close(conn);
		}

		return libroList;
	}

	public void deleteAllLibrosAutor(Integer id) {

		Connection conn = manager.open();
		PreparedStatement statement = null;

		try {
			statement = conn.prepareStatement("DELETE FROM LIBROS WHERE AUTOR_ID = ?");
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
