package com.kerjox.practica_examen_jdbc.servlets;

import com.kerjox.practica_examen_jdbc.entities.Alumno;
import com.kerjox.practica_examen_jdbc.entities.Titulacion;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public abstract class BaseServlet extends HttpServlet {

	protected Titulacion getTitulacionFromRequest(HttpServletRequest req) {

		Titulacion t = new Titulacion();

		t.setName(req.getParameter("name"));

		return t;
	}

	protected Alumno getAlumnoFromRequest(HttpServletRequest req) {

		Alumno a = new Alumno();
		Titulacion t = new Titulacion();

		t.setId(Integer.valueOf(req.getParameter("titulacion")));

		a.setName(req.getParameter("name"));
		a.setEdad(Integer.valueOf(req.getParameter("age")));
		a.setTitulacion(t);
		return a;
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp, String jsp) throws ServletException, IOException {

		req.getRequestDispatcher(jsp).forward(req, resp);
	}
}
