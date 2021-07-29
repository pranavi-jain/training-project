<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Courses | Learning Portal</title>
</head>
<body>
	<div align="right">
		<c:if test="${not empty message}">
			<p>${message}</p>
		</c:if>
	</div>
	<br/>
	<div align="center">
		<h3>Add New Course</h3>
		<form action="login" method="post">
			<table style="width: 60%">
				<tr>
					<td>Course ID </td>
					<td><input type="number" name="course_id"/></td>
				</tr>
				<tr>
					<td>Course Name </td>
					<td><input type="text" name="name"/></td>
				</tr>
				<tr>
					<td>Course Description </td>
					<td><input type="text" name="desp"/></td>
				</tr>
				<tr>
					<td>Course Fees </td>
					<td><input type="number" name="fees"/></td>
				</tr>
				<tr>
					<td>Course Resource </td>
					<td><input type="text" name="rescource"/></td>
				</tr>
			</table>
			<br/>
			<input type="submit" value="Add Course"/>
		</form>
	</div>
	
</body>
</html>