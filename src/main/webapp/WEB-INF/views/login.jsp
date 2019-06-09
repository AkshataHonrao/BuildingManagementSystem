<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
.content {
  max-width: 500px;
  margin: auto;
  border:1px solid black;
}
body {
    margin:50px 0px; padding:0px;
    text-align:center;
    align:center;
}
</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Building Management System</title>
</head>
<body>
<div class="content">

	<h1>Building Management System</h1>
	<h2>Login Page</h2>
	
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<h3><c:out value="${Message}"></c:out></h3>
	<form:form id="login" action="${contextPath}/login" method="post"
		modelAttribute="user">
		<table>
			<tr>
				<td><form:label path="username">UserName</form:label></td>
				<td><form:input path="username" /></td>
				<td><form:errors path="username" /></td>
			</tr>
			<tr>
				<td><form:label path="password">Password</form:label></td>
				<td><form:password path="password" /></td>
				<td><form:errors path="password" /></td>
			</tr>
			<tr>
				<td><form:label path="role">role</form:label></td>
				<td><form:radiobutton path="role" value="Manager"/>Manager<form:radiobutton path="role" value="Tenant"/>Tenant</td>
				<td><form:errors path="role" /></td>
			</tr>
			<tr>
				<td><input type="submit" align="middle" value="login" /></td>
			</tr>
		</table>
	</form:form>
	
	
	
	<form id="signup" action="${contextPath}/signup.htm" method="post">
		<table>
			<tr>
				<td><input type="submit" align="middle" value="Signup" /></td>
			</tr>
		</table>
	</form>
	</div> 
</body>
</html>