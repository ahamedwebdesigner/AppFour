package com.ssn.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Home() {
        super();
      
    }


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		// set header
		resp.setContentType("text/html");
		
		//conext params
	    PrintWriter printWriter  = resp.getWriter();
	    
	   
	    
	    printWriter.println("<h1>"+getServletContext().getInitParameter("AppName")+"</h1>");
	    printWriter.println("<h2>"+getServletContext().getInitParameter("description")+"</h2>");
	    printWriter.println("<h2>"+getInitParameter("Greetings")+"</h2>");
	    //init params
	    

	    
	}

    
    
}
