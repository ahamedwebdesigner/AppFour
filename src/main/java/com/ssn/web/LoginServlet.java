package com.ssn.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public LoginServlet() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//TODO: add title variable
		
				request.setAttribute("AppName", "SSD");
				request.setAttribute("pageName", "pages/login.jsp");
				request.getRequestDispatcher("layout.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		request.setAttribute("AppName", "SSD");
		request.setAttribute("pageName", "pages/userDetails.jsp");
		
		
		request.getRequestDispatcher("layout.jsp").forward(request, response);
		
		
		/*System.out.println(request.getParameter("username"));
		System.out.println(request.getParameter("password"));
		//request.setAttribute("username", request.getParameter("username"));
		//request.setAttribute("password", request.getParameter("password"));
*/	}

}
