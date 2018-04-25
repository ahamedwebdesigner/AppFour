package com.ssn.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet(
        urlPatterns = "/servlettwo",
        initParams =
        {
            @WebInitParam(name = "saveDir", value = "D:/FileUpload"),
            @WebInitParam(name = "allowedTypes", value = "jpg,jpeg,gif,png")
        }
)



public class AnnotationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, 
						HttpServletResponse response) 
								throws ServletException, IOException {
		response.getWriter()
				.append("<h1>Hellow from second servlet</h1> ")
				.append("<h1>"+getServletContext().getInitParameter("AppName")+"</h1>")
				.append("<h1>"+getInitParameter("saveDir")+"</h1>")
				
				.append(request.getContextPath());
	}

}
