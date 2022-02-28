package com.kerjox.bloque5rubbrica8.repos;

import com.kerjox.bloque5rubbrica8.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class StudentJdbcRepo {
	@Autowired
	JdbcTemplate jdbctemplate;

	class StudentRowMapper implements RowMapper<Student> {

		@Override
		public Student mapRow(ResultSet rs, int rownum) throws SQLException {
			Student student = new Student();
			student.setid(rs.getLong("id"));
			student.setname(rs.getString("name"));
			student.setpassportnumber(rs.getString("passport_number"));
			return student;
		}
	}

	public List<Student> findall() {
		return jdbctemplate.query("select * from student", new StudentRowMapper());
	}

	public Student findbyid(long id) {
		return jdbctemplate.queryForObject("select * from student where id=?", new Object[] {
										id
						},
						new BeanPropertyRowMapper<Student> (Student.class));
	}

	public int deletebyid(long id) {
		return jdbctemplate.update("delete from student where id=?", new Object[] {id});
	}

	public int insert(Student student) {
		return jdbctemplate.update("insert into student (id, name, passport_number) " + "values(?,  ?, ?)",
						new Object[] {
										student.getid(), student.getname(), student.getpassportnumber()
						});
	}

	public int update(Student student) {
		return jdbctemplate.update("update student " + " set name = ?, passport_number = ? " + " where id = ?",
						new Object[] {
										student.getname(), student.getpassportnumber(), student.getid()
						});
	}
}
