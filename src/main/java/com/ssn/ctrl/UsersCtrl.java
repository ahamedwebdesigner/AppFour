package com.ssn.ctrl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssn.dao.UserDao;
import com.ssn.model.User;


@WebServlet("/Users")
public class UsersCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UserDao dao; 
	
    public UsersCtrl() {
        super();
        dao = new UserDao();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("AppName", "SSD");
		
		// defining action
		String action=null;
		
		if(request.getParameter("action") == null){
			 action ="listUser";
		}else {
			 action = request.getParameter("action");
		}
		
		if (action.equalsIgnoreCase("listUser")) {
			request.setAttribute("pageName", "listusers.jsp");
			request.setAttribute("users", dao.getAllUsers());
		}else if (action.equalsIgnoreCase("edit")) {
			String userId = request.getParameter("userId");
			User user = dao.getUserById(userId);
			 request.setAttribute("user", user);
			request.setAttribute("pageName", "userForm.jsp");
			
			
		}else if (action.equalsIgnoreCase("insert")) {
			
			request.setAttribute("pageName", "userForm.jsp");
			
			
		}else if (action.equalsIgnoreCase("delete")) {
			String userID = request.getParameter("userID");
			User user = dao.getUserById(userID);
			 request.setAttribute("user", user);
			 int res = dao.deleteUser(userID);
			 
			 if(res > 0 ) {
				 request.setAttribute("pageName", "successUser.jsp");
			 }
			 
			 request.setAttribute("pageName", "successUser.jsp");
			
			
			
		}
		
		
		
		
		
		
		
		
		
		request.getRequestDispatcher("layout.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
		int res =0;
		String userID = request.getParameter("userID");
		User user = new User();
        user.setUname(request.getParameter("uname"));
        user.setPassword(request.getParameter("pass"));
        user.setEmail(request.getParameter("email"));
        
    	System.out.println(user);
    	System.out.println(userID);
       if( request.getParameter("action").equalsIgnoreCase("edit")) {
    	   // if action is edit
    	   request.setAttribute("pageName", "successUser.jsp");
    	   res= dao.updateUser(user,userID);
       }else {
    	   // else add new user
    	   request.setAttribute("pageName", "successUser.jsp"); 
    	   res= dao.addUser(user);
       }
       
       if(res > 0 ) {
    	   request.setAttribute("pageName", "successUser.jsp");
       }
       
       request.getRequestDispatcher("layout.jsp").forward(request, response);
       
	}

}
