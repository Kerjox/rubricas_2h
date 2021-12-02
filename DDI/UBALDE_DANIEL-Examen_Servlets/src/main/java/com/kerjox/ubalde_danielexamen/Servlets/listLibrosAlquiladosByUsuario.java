package com.kerjox.ubalde_danielexamen.Servlets;

import com.kerjox.ubalde_danielexamen.Entities.Libro;
import com.kerjox.ubalde_danielexamen.Repos.AutorRepo;
import com.kerjox.ubalde_danielexamen.Repos.LibrosUsuarioRepo;
import com.kerjox.ubalde_danielexamen.Repos.UsuarioRepo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "listLibrosByUser", value = "/libros/listByUsuario")
public class listLibrosAlquiladosByUsuario extends BaseServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doSomething(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doSomething(req, resp);
	}

	private void doSomething(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		UsuarioRepo usuarioRepo = new UsuarioRepo();

		String nombre = req.getParameter("nombre");
		String apellido = req.getParameter("apellido");

		Integer id = usuarioRepo.findByNombreOrApellido(nombre, apellido).getId();

		LibrosUsuarioRepo librosUsuarioRepo = new LibrosUsuarioRepo();

		List<Libro> librosList = librosUsuarioRepo.findByUsuario(id);

		req.setAttribute("librosList", librosList);

		redirect(req, resp, "/libros/listLibrosAlquiladosByUsuario.jsp");
	}
}
