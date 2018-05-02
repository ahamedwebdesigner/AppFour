package com.ssn.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database1 {

	public static void main(String[] args) {
		String query = "SELECT VERSION()";
		
		
		String url = "jdbc:mysql://localhost:3306/AppFour?useSSL=false";
		
		try {
			Connection con = DriverManager.getConnection(url, "AppFourAdmin", "AppFourAdmin123456");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			if (rs.next()) {
				System.out.println(rs.getString(1));
			}

			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

}
