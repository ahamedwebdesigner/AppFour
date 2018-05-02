package com.ssn.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database3 {

	public static void main(String[] args) {
		String query = "INSERT INTO `user`(`username`, `email`, `password`) VALUES (?,?,?)";

		
		
		String url = "jdbc:mysql://localhost:3306/AppFour?useSSL=false";
		
		try {
			Connection con = DriverManager.getConnection(url, "AppFourAdmin", "AppFourAdmin123456");
	        PreparedStatement pst = con.prepareStatement(query);                  // prepate statement

	         pst.setString(1, "mustaq");                                            // set the peramaters
	         pst.setString(2, "mustaq@gmail.com");
	         pst.setString(3, "3456");
	         int res= pst.executeUpdate();
			System.out.println("No of rows modified : "+res);

			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

}
