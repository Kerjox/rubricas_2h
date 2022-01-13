package com.ubalde.bloque3_rubrica_5.servlets;

import com.ubalde.bloque3_rubrica_5.entities.Persona;
import com.ubalde.bloque3_rubrica_5.repos.PersonaRepo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class listPersonas extends BaseServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doSomething(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doSomething(req, resp);
	}

	private void doSomething(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PersonaRepo repo = new PersonaRepo();
		List<Persona> personas = repo.findAll();

		req.setAttribute("personas", personas);
		redirect(req, resp, "/listPersonas.jsp");
	}
}
