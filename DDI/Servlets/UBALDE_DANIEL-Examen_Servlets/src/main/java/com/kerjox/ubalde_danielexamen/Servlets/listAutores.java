package com.kerjox.ubalde_danielexamen.Servlets;

import com.kerjox.ubalde_danielexamen.Entities.Autor;
import com.kerjox.ubalde_danielexamen.Repos.AutorRepo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "listAutores", value = "/autores/list")
public class listAutores extends BaseServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doSomething(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doSomething(req, resp);
	}

	private void doSomething(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		AutorRepo repo = new AutorRepo();

		List<Autor> autorList = repo.findAll();

		req.setAttribute("autoresList", autorList);

		redirect(req, resp, "/autores/listAutores.jsp");
	}
}
