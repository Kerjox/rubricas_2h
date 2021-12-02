package com.kerjox.ubalde_danielexamen.Servlets;

import com.kerjox.ubalde_danielexamen.Entities.Autor;
import com.kerjox.ubalde_danielexamen.Entities.Libro;
import com.kerjox.ubalde_danielexamen.Repos.AutorRepo;
import com.kerjox.ubalde_danielexamen.Repos.LibrosRepo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "findLibroByAutor", value = "/libros/findByAutoNombreOrApellido")
public class findLibrosByAutorNombreOrApellido extends BaseServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doSomething(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doSomething(req, resp);
	}

	private void doSomething(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String nombre = req.getParameter("nombre");
		String apellido = req.getParameter("apellido");
		LibrosRepo repo = new LibrosRepo();

		List<Libro> librosList = repo.findByAutorNombreOrApellido(nombre, apellido);

		req.setAttribute("librosList", librosList);

		redirect(req, resp, "/libros/listLibrosByAutorNombreOrApellido.jsp");
	}
}
