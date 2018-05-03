package com.ssn.jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Database1 {

	public static void main(String[] args) {
		String query = "SELECT VERSION()";
		
		//style1
		String url = "jdbc:mysql://localhost:3306/AppFour?useSSL=false";
		
		//ii) method two
		String url2 = "jdbc:mysql://localhost:3306/AppFour?user=AppFourAdmin&password=AppFourAdmin123456&useSSL=false";
		
		
		// iii) thred method
        String url3 = "jdbc:mysql://localhost:3306/AppFour";
        Properties DbInfoinfo = new Properties();
        DbInfoinfo.put("user", "AppFourAdmin");
        DbInfoinfo.put("password", "AppFourAdmin123456");
        DbInfoinfo.put("useSSL", "false");
        
        String fileName = "src/main/resources/db.properties";
        Properties props = new Properties();
        try {
			FileInputStream in = new FileInputStream(fileName);
			 props.load(in);
		} catch (IOException e1) {
			e1.printStackTrace();
		} 
        
        
		try {
			//Connection con = DriverManager.getConnection(url, "AppFourAdmin", "AppFourAdmin123456");
			//Connection con = DriverManager.getConnection(url2);
			//Connection con = DriverManager.getConnection(url3, DbInfoinfo);	
			Connection con = DriverManager.getConnection(props.getProperty("db.url"),props.getProperty("db.user"),props.getProperty("db.passwd"));	  //iV)
			
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
