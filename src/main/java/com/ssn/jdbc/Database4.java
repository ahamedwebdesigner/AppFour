package com.ssn.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database4 {

	public static void main(String[] args) {
		String query = "SELECT * fROM user";
		String url = "jdbc:mysql://localhost:3306/AppFour?useSSL=false";
		
		try {
			Connection con = DriverManager.getConnection(url, "AppFourAdmin", "AppFourAdmin123456");
			PreparedStatement pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
		
            while (rs.next()) {
                System.out.print(rs.getInt(1) + " - ");
                System.out.print(rs.getString(2)+ " - ");
                System.out.print(rs.getString(3)+ " - ");
                System.out.println(rs.getString(4)+ " - ");
            }
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

}
