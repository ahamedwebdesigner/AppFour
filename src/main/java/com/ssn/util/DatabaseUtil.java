package com.ssn.util;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DatabaseUtil {
	public static Connection getConnection() {

        Properties props = new Properties();
        try {
        	
 
        	 ClassLoader classLoader = DatabaseUtil.class.getClassLoader();// 1 get class loader form the current class
        	 URL resource = classLoader.getResource("db.properties");//2 using class loader get resource
        	 props.load(new FileReader(new File(resource.getFile())));//3 formclass loader -> create file object -> create file reader -> load properties
        	
           } catch (IOException e1) {
			e1.printStackTrace();
			System.out.println(e1.getMessage());
		} 
        
        
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        	 con = DriverManager.getConnection(props.getProperty("db.url"),props.getProperty("db.user"),props.getProperty("db.passwd"));
			
        }catch (Exception e) {
			
		}
        return con;
	}
	
	 public static void close(Connection con) {
         try  {
             con.close();
         }
         catch(Exception ex) {
         }
     }
}
