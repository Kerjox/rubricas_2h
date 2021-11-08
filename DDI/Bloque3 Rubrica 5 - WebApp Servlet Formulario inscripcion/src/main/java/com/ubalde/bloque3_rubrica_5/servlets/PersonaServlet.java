package com.ubalde.bloque3_rubrica_5.servlets;

import com.ubalde.bloque3_rubrica_5.entities.Persona;
import com.ubalde.bloque3_rubrica_5.repos.PersonaRepo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PersonaServlet extends BaseServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doSomething(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doSomething(req, resp);
	}

	private void doSomething(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PersonaRepo repo = new PersonaRepo();
		Persona persona = getPersonaFromRequest(req);
		repo.Insert(persona);
		req.setAttribute("persona", persona);
		redirect(req, resp, "prueba.jsp");
	}
}
