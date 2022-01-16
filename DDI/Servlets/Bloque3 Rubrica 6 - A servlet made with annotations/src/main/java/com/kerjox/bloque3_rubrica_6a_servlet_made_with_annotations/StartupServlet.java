package com.kerjox.bloque3_rubrica_6a_servlet_made_with_annotations;

import javax.servlet.ServletConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(
				urlPatterns = {"/startupServlet"},
				loadOnStartup = 1,
				asyncSupported = true
)
public class StartupServlet extends HttpServlet {
	
	public void init(ServletConfig config) {
		System.out.println("My Servlet Has Been Initialized ….!");
	}
}
