package com.kerjox.service;

import com.kerjox.entity.Student;
import com.kerjox.repository.StudentRepo;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service(value = "DataBaseService")
@Profile(value = "Production")
public class DataBaseService implements MyDataBase {

	@Autowired
	private com.kerjox.repository.StudentRepo StudentRepo;

	public StudentRepo getStudentRepo() {
		return StudentRepo;
	}

	public void setStudentRepo(StudentRepo studentRepo) {
		this.StudentRepo = studentRepo;
	}

	@Override
	public void insert(Student student) {

		System.out.println("Inserccion simulada desde 'DataBaseService'");
		StudentRepo.insert(student);
	}

	@Override
	public void delete() {

	}
}


