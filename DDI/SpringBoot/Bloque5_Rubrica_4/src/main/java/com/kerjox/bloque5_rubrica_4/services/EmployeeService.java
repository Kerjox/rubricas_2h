package com.kerjox.bloque5_rubrica_4.services;

import com.kerjox.bloque5_rubrica_4.entities.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
	public List<Employee> getAllEmployee() {
		List<Employee> list = new ArrayList<>();
		list.add(new Employee(1, "Mahesh", "Varanasi"));
		list.add(new Employee(2, "Ram", "Ayodhya"));
		list.add(new Employee(3, "Krishna", "Mathura"));
		return list;
	}
}

