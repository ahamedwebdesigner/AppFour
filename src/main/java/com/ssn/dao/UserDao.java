package com.ssn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ssn.model.User;
import com.ssn.util.DatabaseUtil;

public class UserDao {
	private Connection connection;
	
	   public UserDao() {
	        connection = DatabaseUtil.getConnection();
	    }
	   

	   
	   // return all the users
	   public List<User> getAllUsers() {
	        List<User> users = new ArrayList<User>();
	        try {
	            Statement statement = connection.createStatement();
	            ResultSet rs = statement.executeQuery("select * from user");
	            
	            while (rs.next()) {
	                User user = new User(rs.getString("username"), rs.getString("password"), rs.getString("email"));
	                users.add(user);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return users;
	    }

	   
	    public User getUserById(String userId) {
	        User user = new User();
	        try {
	            PreparedStatement preparedStatement = connection.prepareStatement("select * from user where username=?");
	            preparedStatement.setString(1, userId);
	            ResultSet rs = preparedStatement.executeQuery();

	            if (rs.next()) {
	                user.setUname(rs.getString("username"));
	                user.setPassword(rs.getString("password"));
	                user.setEmail(rs.getString("email"));
	              }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return user;
	    }



	    // 1) add user
	    public int updateUser(User user, String userID) {
	      try {
	            PreparedStatement preparedStatement = connection.prepareStatement("update user set username=?,password=?, email=? where username=?");
	            // Parameters start with 1
	            preparedStatement.setString(1, user.getUname());
	            preparedStatement.setString(2, user.getPassword());
	            preparedStatement.setString(3, user.getEmail());  
	            preparedStatement.setString(4, userID);
	            
	            int res = preparedStatement.executeUpdate();
	            System.out.println("output is " + res);
	            return  res;
	 
	        } catch (SQLException e) {
	           System.out.println(e.getMessage());
	        }
			return 0;
	    }



	    // 1) add user
	    public int addUser(User user) {
	        try {
	            PreparedStatement preparedStatement = connection.prepareStatement("insert into user(username, password, email) values (?, ?, ? )");
	            // Parameters start with 1
	            preparedStatement.setString(1, user.getUname());
	            preparedStatement.setString(2, user.getPassword());
	            preparedStatement.setString(3, user.getEmail());            
	         
	          return  preparedStatement.executeUpdate();
	 
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
			return 0;
	    }
	    
	    public int deleteUser(String userId) {
	    	
	        try {
	            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM user WHERE username = ?");
	            // Parameters start with 1
	            preparedStatement.setString(1, userId);
	            
	            int res = preparedStatement.executeUpdate();
	
	            return res;
	        } catch (SQLException e) {
	            e.printStackTrace();
	            System.out.println(e.getMessage());
	        }
			return 0;
	    }


}
