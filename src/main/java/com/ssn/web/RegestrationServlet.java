package com.ssn.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/register")
public class RegestrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public RegestrationServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("AppName", "SSD");
		request.setAttribute("pageName", "pages/register.jsp");
		request.getRequestDispatcher("layout.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		request.setAttribute("AppName", "SSD");
		request.setAttribute("pageName", "pages/userDetails.jsp");
		
		//post data
		request.setAttribute("username", request.getParameter("username"));
		request.setAttribute("email", request.getParameter("email"));
		request.setAttribute("password", request.getParameter("password"));
		
		
		
		
		request.getRequestDispatcher("layout.jsp").forward(request, response);
		
		
	}

}
