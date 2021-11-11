package com.kerjox.practica_examen_jdbc.servlets;

import com.kerjox.practica_examen_jdbc.entities.Titulacion;
import com.kerjox.practica_examen_jdbc.repos.TitulacionRepo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class FormInsertAlumnoServletDao extends BaseServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doSomething(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doSomething(req, resp);
	}

	private void doSomething(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		TitulacionRepo repo = new TitulacionRepo();

		List<Titulacion> titulacionList = repo.findAll();
		req.setAttribute("titulaciones", titulacionList);

		redirect(req, resp, "/insertAlumno.jsp");
	}
}
