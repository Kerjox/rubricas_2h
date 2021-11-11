package com.kerjox.practica_examen_jdbc.servlets;

import com.kerjox.practica_examen_jdbc.entities.Titulacion;
import com.kerjox.practica_examen_jdbc.repos.Repo;
import com.kerjox.practica_examen_jdbc.repos.TitulacionRepo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class InsertTitulacionServlet extends BaseServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doSomething(req, resp);
	}

	private void doSomething(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Titulacion t = getTitulacionFromRequest(req);
		Repo<Titulacion> titulacionRepo = new TitulacionRepo();

		titulacionRepo.insert(t);

		redirect(req, resp, "/index.jsp");
	}
}
