package com.kerjox.practica_examen_jdbc.servlets;

import com.kerjox.practica_examen_jdbc.entities.Alumno;
import com.kerjox.practica_examen_jdbc.entities.Titulacion;
import com.kerjox.practica_examen_jdbc.repos.AlumnosRepo;
import com.kerjox.practica_examen_jdbc.repos.TitulacionRepo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class EditAlumnoServletDao extends BaseServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doSomething(req, resp);
	}

	private void doSomething(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Integer id = Integer.valueOf(req.getParameter("id"));
		AlumnosRepo alumnosRepo = new AlumnosRepo();
		TitulacionRepo titulacionRepo = new TitulacionRepo();
		List<Titulacion> titulacionesList = titulacionRepo.findAll();

		Alumno alumno = alumnosRepo.findById(id);
		req.setAttribute("alumno", alumno);
		req.setAttribute("titulaciones", titulacionesList);

		redirect(req, resp, "/editAlumno.jsp");
	}
}
