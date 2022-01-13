package com.kerjox.ubalde_danielexamen.Servlets;

import com.kerjox.ubalde_danielexamen.Repos.AutorRepo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "updateSeudonimoAutor", value = "/autores/editSeudonimo")
public class UpdateSeudonimoAutor extends BaseServlet {

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
		String seudonimo = req.getParameter("seudonimo");

		AutorRepo repo = new AutorRepo();
		repo.updateSeudonimo(id, seudonimo);

		redirect(req, resp, "/");
	}
}
