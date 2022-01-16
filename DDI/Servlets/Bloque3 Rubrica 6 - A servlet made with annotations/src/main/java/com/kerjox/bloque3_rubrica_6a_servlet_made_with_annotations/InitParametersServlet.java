package com.kerjox.bloque3_rubrica_6a_servlet_made_with_annotations;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(
				urlPatterns = "/imageUpload",
				initParams = {
								@WebInitParam(name = "saveDir", value = "D:/FileUpload"),
								@WebInitParam(name = "allowedTypes", value = "jpg, jpeg, gif, png")
				})
public class InitParametersServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String saveDir = getInitParameter("saveDir"),
						fileTypes = getInitParameter("allowedTypes");

		PrintWriter writerObj = resp.getWriter();
		writerObj.println("saveDir?= " + saveDir);
		writerObj.println("fileTypes?= " + fileTypes);
	}
}
