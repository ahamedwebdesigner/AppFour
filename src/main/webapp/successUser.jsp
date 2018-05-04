<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
     <% String action = request.getParameter("action");
                System.out.println(action);
            %>
            
<h1> ${user.uname} success fully <%= action %> </h1>

