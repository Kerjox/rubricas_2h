package com.kerjox.ubalde_danielexamen.Repos;

import com.kerjox.ubalde_danielexamen.Entities.Autor;
import com.kerjox.ubalde_danielexamen.Entities.Usuario;
import com.kerjox.ubalde_danielexamen.connection.AbstractConnection;
import com.kerjox.ubalde_danielexamen.connection.H2Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioRepo {

	private final AbstractConnection manager = new H2Connection();


	public Usuario findByNombreOrApellido(String nombre, String apellido) {

		Connection conn = manager.open();
		PreparedStatement statement = null;
		Usuario usuario = new Usuario();

		try {
			statement = conn.prepareStatement("SELECT * FROM USUARIOS WHERE NOMBRE = ? OR APELLIDOS = ?");
			statement.setString(1, nombre);
			statement.setString(2, apellido);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				usuario.setId(rs.getInt("usuario_id"));
				usuario.setNombre(rs.getString("nombre"));
				usuario.setApellido(rs.getString("apellidos"));
			}

			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {

			manager.close(statement);
			manager.close(conn);
		}

		return usuario;
	}
}
