<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


 <form method="POST" action='${pageContext.request.contextPath}/Users' name="frmAddUser">
            
            
            <% String action = request.getParameter("action");
                System.out.println(action);
            %>
            
            
            <% if (action.equalsIgnoreCase("edit")) {%>
            User Name : <input type="text" name="uname"
                               value="<c:out value="${user.uname}" />" /> <br /> 
            <%} else {%>
            
            User Name : <input type="text" name="uname"
                               value="" />" /> <br />
            <%}%>
            
            
             <input type="hidden" name="action" value="<%=action %>">
             <input type="hidden" name="userID" value="${user.uname}">
            
            Password : <input
                type="password" name="pass"
                value="<c:out value="${user.password}" />" /> <br /> 
            Email : <input
                type="text" name="email"
                value="<c:out value="${user.email}" />" /> <br /> 

           
            <input  type="submit" value="Submit" />
        </form>