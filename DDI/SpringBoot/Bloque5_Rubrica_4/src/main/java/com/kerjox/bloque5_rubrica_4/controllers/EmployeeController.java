package com.kerjox.bloque5_rubrica_4.controllers;

import com.kerjox.bloque5_rubrica_4.entities.Employee;
import com.kerjox.bloque5_rubrica_4.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@RequestMapping("home")
	public List<Employee> showData() {
		List<Employee> list = service.getAllEmployee();
		return list;
	}
}

