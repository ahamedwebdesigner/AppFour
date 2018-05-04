<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

  <!DOCTYPE html>
<html lang="en">
   <html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

		<!-- Latest compiled and minified CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css"  type="text/css" />

    <title>appforu</title>
</head>
<body>

 <div class="container">
 
       <div class="header clearfix">
      
		   <nav>
	          <ul class="nav nav-pills pull-right">
	            <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/">Home</a></li>
	            <li role="presentation"><a href="${pageContext.request.contextPath}/login">Login</a></li>
	            <li role="presentation"><a href="${pageContext.request.contextPath}/register">Register</a></li>
	            <li role="presentation"><a href="${pageContext.request.contextPath}/Users">Users</a></li>
	          </ul>
	        </nav>
	        <h1 class="text-muted">${AppName}</h1>
      
      </div>
      
      <jsp:include page="${pageName}"  flush="true"/>
      
      

 </div>

 <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>


</body>