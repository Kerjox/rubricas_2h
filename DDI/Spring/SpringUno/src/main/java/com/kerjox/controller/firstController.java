package com.kerjox.controller;

import com.kerjox.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.kerjox.service.MyDataBase;

@Controller
public class firstController {

	@Autowired
	//@Qualifier(value = "DataBaseService")
	private MyDataBase db;

	public MyDataBase getDb() {
		return db;
	}

	public void setDb(MyDataBase db) {
		this.db = db;
	}

	@GetMapping(value = "/")
	public ModelAndView index() {

		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("index");
		modelAndView.addObject("student", new Student());

		return modelAndView;
	}

	@GetMapping("/fin")
	public String fin(@RequestParam("age") Integer age) {

		System.out.println(age);
		return "fin";
	}

	@GetMapping("/student")
	public String student(Student student) {

		student.toString();
		db.insert(student);
		return "fin";
	}

	@GetMapping("/error")
	public String error() {

		return "error";
	}
}
