<h1>register</h1>

<hr />
<form action="${pageContext.request.contextPath}/register" method="post">
	
	<label>username</label>
	<input type="text" name="username">  <br/>
	<label>email</label>
	<input type="text"
		name="email"> <br/>
		<label>password</label>
		<input type="password" name="password"><br/>
	<input type="submit" value="submit">

</form>