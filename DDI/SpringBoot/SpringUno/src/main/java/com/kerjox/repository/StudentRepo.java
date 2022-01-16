package com.kerjox.repository;

import com.kerjox.connection.AbstractConnection;
import com.kerjox.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class StudentRepo {

	@Autowired
	private AbstractConnection manager;

	public AbstractConnection getManager() {
		return manager;
	}

	public void setManager(AbstractConnection manager) {
		this.manager = manager;
	}

	@Value("${app.jdbcurl}")
	private String jdbcurl;

	public void insert(Student student) {

		Connection conn = manager.open(jdbcurl);
		PreparedStatement statement = null;
		try {
			statement = conn.prepareStatement("INSERT INTO students (name, age) VALUES (?, ?)");
			statement.setString(1, student.getName());
			statement.setInt(2, student.getAge());

			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		manager.close(statement);
		manager.close(conn);
		System.out.println("Insertando en base de datos H2 simulada");
	}
}
