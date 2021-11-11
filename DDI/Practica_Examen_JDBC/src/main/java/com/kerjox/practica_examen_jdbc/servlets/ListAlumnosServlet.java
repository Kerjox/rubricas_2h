package com.kerjox.practica_examen_jdbc.servlets;

import com.kerjox.practica_examen_jdbc.entities.Alumno;
import com.kerjox.practica_examen_jdbc.repos.AlumnosRepo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListAlumnosServlet extends BaseServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doSomething(req, resp);
	}

	private void doSomething(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		AlumnosRepo alumnosRepo = new AlumnosRepo();
		List<Alumno> alumnosList = alumnosRepo.findAll();
		req.setAttribute("alumnos", alumnosList);

		redirect(req, resp, "/listAlumnos.jsp");
	}
}
