package com.ssn.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/")
public class DefaultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public DefaultServlet() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//TODO: add title variable
		
		request.setAttribute("AppName", "SSD");
		request.setAttribute("pageName", "pages/home.jsp");
		request.getRequestDispatcher("layout.jsp").forward(request, response);
	}


}
