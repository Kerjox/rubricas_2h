package com.kerjox.service;

import com.kerjox.entity.Student;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service(value = "AnotherDataBaseService")
@Profile(value = "Testing")
public class anotherDatabaseService implements MyDataBase {

	@Override
	public void insert(Student student) {
		System.out.println("Executing 'anotherDatabaseService' repo");
	}

	@Override
	public void delete() {

	}
}
