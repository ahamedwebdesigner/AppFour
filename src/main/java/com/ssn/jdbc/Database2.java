package com.ssn.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database2 {

	public static void main(String[] args) {
		String query = "INSERT INTO `user`(`username`, `email`, `password`) VALUES ('syed','syed123@gmail.com','123')";

		
		
		String url = "jdbc:mysql://localhost:3306/AppFour?useSSL=false";
		
		try {
			Connection con = DriverManager.getConnection(url, "AppFourAdmin", "AppFourAdmin123456");
			Statement st = con.createStatement();
			int rs = st.executeUpdate(query);
			
			System.out.println("No of rows modified"+rs);

			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

}
