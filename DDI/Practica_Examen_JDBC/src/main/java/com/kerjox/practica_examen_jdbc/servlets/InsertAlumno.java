package com.kerjox.practica_examen_jdbc.servlets;

import com.kerjox.practica_examen_jdbc.entities.Alumno;
import com.kerjox.practica_examen_jdbc.repos.AlumnosRepo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class InsertAlumno extends BaseServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doSomething(req, resp);
	}

	private void doSomething(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Alumno alumno = getAlumnoFromRequest(req);
		AlumnosRepo alumnosRepo = new AlumnosRepo();
		alumnosRepo.insert(alumno);

		redirect(req, resp, "/index.jsp");
	}
}
