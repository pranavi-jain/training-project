<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login | Learning Portal</title>
</head>
<body>
<div align="right">
	<c:if test="${not empty message}">
		<p>${message}</p>
	</c:if>
</div>
<div align="center">
	<form action="login" method="post">
		<table style="float: center">
			<tr>
				<td>Email </td>
				<td><input type="text" name="email"/></td>
			</tr>
			<tr>
				<td>Password </td>
				<td><input type="password" name="password"/></td>
			</tr>
			<tr>
                <td>User Role </td>
                <td><select name="user_role">
                        <option>Learner</option>
                        <option>Admin</option>
                </select></td>
            </tr>
		</table>
		<br/>
		<input type="submit" value="Login"/>
	</form>
	<br/>
	<!-- <a href="register"><button type="button">Register New User</button></a> -->
</div>
</body>
</html>