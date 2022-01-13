package com.kerjox.ubalde_danielexamen.Servlets;

import com.kerjox.ubalde_danielexamen.Entities.Autor;
import com.kerjox.ubalde_danielexamen.Repos.AutorRepo;

import java.io.*;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "listAutoresByNombreOrApellido", value = "/autores/byNombreOrApellido")
public class findAutoresByNombreOrApellido extends BaseServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doSomething(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doSomething(req, resp);
	}

	private void doSomething(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String nombre = req.getParameter("nombre");
		String apellido = req.getParameter("apellido");
		AutorRepo repo = new AutorRepo();

		List<Autor> autoresList = repo.findByNombreOrApellido(nombre, apellido);

		req.setAttribute("autoresList", autoresList);

		redirect(req, resp, "/autores/listAutoresFindByNombreOrApellido.jsp");
	}
}
