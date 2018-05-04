 <%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
 <table border=1>
        <thead>
            <tr>
                <th>User Name</th>
                <th>Email</th>
                <th>password</th>
                <th colspan=2>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td><c:out value="${user.uname}" /></td>
                    <td><c:out value="${user.email}" /></td>
                  
                    <td><a href="${pageContext.request.contextPath}/Users?action=edit&userId=<c:out value="${user.uname}"/>">Update</a></td>
                    <td><a href="${pageContext.request.contextPath}/Users?action=delete&userId=<c:out value="${user.uname}"/>">Delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <p><a href="${pageContext.request.contextPath}/Users?action=insert">Add User</a></p>