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

public class LibrosUsuarioRepo {

	private final AbstractConnection manager = new H2Connection();

	public void deleteByIdAutor(Integer autor_id) {

		Connection conn = manager.open();
		PreparedStatement statement = null;

		try {
			statement = conn.prepareStatement("DELETE FROM LIBROS_USUARIOS WHERE LIBRO_ID IN " +
							"(SELECT LIBRO_ID FROM LIBROS WHERE AUTOR_ID = ?)");
			statement.setInt(1, autor_id);

			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {

			manager.close(statement);
			manager.close(conn);
		}
	}


	public List<Libro> findByUsuario(Integer id) {

		Connection conn = manager.open();
		PreparedStatement statement = null;
		List<Libro> libroList = new ArrayList<>();

		try {
			statement = conn.prepareStatement("SELECT L.TITULO as titulo, L.DESCRIPCION AS descripcion, L.FECHA_CREACION AS fechaCreacion FROM LIBROS L " +
							"INNER JOIN LIBROS_USUARIOS LU on L.LIBRO_ID = LU.LIBRO_ID WHERE LU.USUARIO_ID = ?");
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				Libro libro = new Libro();
				libro.setTitulo(rs.getString("titulo"));
				libro.setDescripcion(rs.getString("descripcion"));
				libro.setFecha_creacion(rs.getDate("fechaCreacion"));
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
}
