package com.kerjox.bloque5rubbrica8.repos;

import com.kerjox.bloque5rubbrica8.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.swing.tree.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class StudentJdbcRepo {
	@Autowired
	jdbctemplate jdbctemplate;

	class studentrowmapper implements RowMapper<Student> {
		@Override
		public Student maprow(ResultSet rs, int rownum) throws SQLException {
			Student student = new Student();
			student.setid(rs.getLong("id"));
			student.setname(rs.getString("name"));
			student.setpassportnumber(rs.getString("passport_number"));
			return student;
		}

	}

	public List<Student> findall() {
		return jdbctemplate.query("select * from student", new studentrowmapper());
	}

	public Student findbyid(long id) {
		return jdbctemplate.queryforobject("select * from student where id=?", new Object[] {
										id
						},
						new beanpropertyrowmapper <Student> (student.class));
	}

	public int deletebyid(long id) {
		return jdbctemplate.update("delete from student where id=?", new Object[] {
						id
		});
	}

	public int insert(student student) {
		return jdbctemplate.update("insert into student (id, name, passport_number) " + "values(?,  ?, ?)",
						new Object[] {
										student.getId(), student.getName(), student.getpassportnumber()
						});
	}

	public int update(student student) {
		return jdbctemplate.update("update student " + " set name = ?, passport_number = ? " + " where id = ?",
						new object[] {
										student.getname(), student.getpassportnumber(), student.getid()
						});
	}
