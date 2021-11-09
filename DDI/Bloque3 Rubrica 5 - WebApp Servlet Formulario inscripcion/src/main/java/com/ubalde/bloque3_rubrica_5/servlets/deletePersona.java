package com.ubalde.bloque3_rubrica_5.servlets;

import com.ubalde.bloque3_rubrica_5.repos.PersonaRepo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class deletePersona extends BaseServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doSomething(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doSomething(req, resp);
	}

	private void doSomething(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Integer id = Integer.valueOf(req.getParameter("id"));
		PersonaRepo repo = new PersonaRepo();

		repo.delete(id);
		req.setAttribute("removed", Boolean.TRUE	);
		redirect(req, resp, "/index.jsp");
	}
}
