package com.ssn.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssn.util.DatabaseUtil;


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
		
		
		
		
		///1) loading property file form the web application deployed in server
		
        
        
        
    	String query = "INSERT INTO `user`(`username`, `email`, `password`) VALUES (?,?,?)";

       
        try {
        
        	Connection con = DatabaseUtil.getConnection();
        	//Connection con = DriverManager.getConnection(url, "AppFourAdmin", "AppFourAdmin123456");
        	PreparedStatement pst = con.prepareStatement(query); 
			 pst.setString(1,  request.getParameter("username"));                                            // set the peramaters
	         pst.setString(2, request.getParameter("email"));
	         pst.setString(3, request.getParameter("password"));
	         int res= pst.executeUpdate();
	         
	          
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		
		}
        
        
        
        
        
	
		
		
	}

}
