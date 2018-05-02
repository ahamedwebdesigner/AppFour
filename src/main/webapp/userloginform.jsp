<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
 

<form name="login" method="POST" action="${pageContext.request.contextPath}/login">
    Username: <input type="text" name="username"/> <br/>
    Password: <input type="password" name="password"/> <br/>
    <input type="submit" value="Login" />
</form>
