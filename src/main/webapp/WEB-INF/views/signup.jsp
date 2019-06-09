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
}


body {
    margin:50px 0px; padding:0px;
    text-align:center;
    align:center;
}

input[type=submit] {
  width: 100%;
  color: white;
  align:center;
  background-color: #008CBA;
  padding: 14px 20px;
  margin: 8px 1px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}
input[type=file], select {
  width: 50%;
  padding: 12px 20px;
  margin: 8px 1px;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}
form {
border : 5px solid #000;
padding : 10px;
padding : 10px;
align:center;
text-align:center;
margin-top: 10px;
margin-bottom: 400px;
margin-right: 400px;
margin-left: 400px;
}
</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Building Management System</title>
</head>
<body>
	<h1>User SingUp Page </h1>
	<c:set var="contextpath" value="${pageContext.request.contextPath}"></c:set>
	<form:form action="${contextpath}/signupuser" method="post"
		modelAttribute="user">
		<table>
			<tr>
				<td><form:label path="username">UserName</form:label></td><c:out value="${error}"/>
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
				<td><form:radiobutton path="role" value="Tenant"/>Tenant</td>
				<td><form:errors path="role" /></td>
			</tr>
			<tr>
				<td><form:label path="fname">First Name</form:label></td>
				<td><form:input path="fname" /></td>
				<td><form:errors path="fname" /></td>
			</tr>
			<tr>
				<td><form:label path="lname">Last Name</form:label></td>
				<td><form:input path="lname" /></td>
				<td><form:errors path="lname" /></td>
			</tr>
			<tr>
				<td><form:label path="DOB">Date of Birth</form:label></td>
				<td><form:input path="DOB" /></td>
				<td><form:errors path="DOB" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form:form>	
	<h3><a href="${pageContext.request.contextPath}/logout">LOGOUT</a></h3>
	
</body>
</html>
