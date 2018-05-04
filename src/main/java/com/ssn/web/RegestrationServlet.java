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
		
        String fileName = "src/main/resources/db.properties";
        Properties props = new Properties();
        try {
        	
        	//In case of console base application we can load properties using FileInputStream class
        	//But in webbased application it is different because web application loads in servlet container
        	//we have to load properties file form the servlet container directory as followes
        	//steps: 
        	 ClassLoader classLoader = getClass().getClassLoader();// 1 get class loader form the current class
        	 URL resource = classLoader.getResource("db.properties");//2 using class loader get resource
        	 props.load(new FileReader(new File(resource.getFile())));//3 formclass loader -> create file object -> create file reader -> load properties
        	
           } catch (IOException e1) {
			e1.printStackTrace();
			System.out.println(e1.getMessage());
		} 
        
        System.out.println(props.toString());
        
    	String query = "INSERT INTO `user`(`username`, `email`, `password`) VALUES (?,?,?)";

       
        try {
        
        	//1) keep mysql-connector-java-8.0.11.jar in WEB-INF/lib directry  to make mysql class avalable in servlet
        	//2) create connection object using driver manager
        	//3) create prepare statement with insert query having ? palce holders
        	//4) add the values for the plae holders
        	//5) excuide the query at get the result
        	Class.forName("com.mysql.jdbc.Driver").newInstance();
        	
			Connection con = DriverManager.getConnection(props.getProperty("db.url"),props.getProperty("db.user"),props.getProperty("db.passwd"));
        	//Connection con = DriverManager.getConnection(url, "AppFourAdmin", "AppFourAdmin123456");
        	PreparedStatement pst = con.prepareStatement(query); 
			 pst.setString(1,  request.getParameter("username"));                                            // set the peramaters
	         pst.setString(2, request.getParameter("email"));
	         pst.setString(3, request.getParameter("password"));
	         int res= pst.executeUpdate();
	         
	        
	      
	         
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		
		} catch (InstantiationException e) {
			
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
        
        
        
        
        
	
		
		
	}

}
