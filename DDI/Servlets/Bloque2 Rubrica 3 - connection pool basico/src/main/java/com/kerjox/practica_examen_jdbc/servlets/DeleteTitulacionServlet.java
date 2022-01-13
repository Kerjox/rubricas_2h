package com.kerjox.practica_examen_jdbc.servlets;

import com.kerjox.practica_examen_jdbc.entities.Alumno;
import com.kerjox.practica_examen_jdbc.entities.Titulacion;
import com.kerjox.practica_examen_jdbc.repos.AlumnosRepo;
import com.kerjox.practica_examen_jdbc.repos.Repo;
import com.kerjox.practica_examen_jdbc.repos.TitulacionRepo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class DeleteTitulacionServlet extends BaseServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doSomething(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doSomething(req, resp);
	}

	private void doSomething(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Integer idTitulacion = Integer.valueOf(req.getParameter("id"));
		Repo<Titulacion> titulacionRepo = new TitulacionRepo();
		AlumnosRepo alumnoRepo = new AlumnosRepo();
		List<Alumno> alumnosToDelete = alumnoRepo.findByTitulacion(idTitulacion);

		for (Alumno a : alumnosToDelete) {

			alumnoRepo.delete(a.getId());
		}

		titulacionRepo.delete(idTitulacion);

		redirect(req, resp, "/titulacion/list");
	}
}
