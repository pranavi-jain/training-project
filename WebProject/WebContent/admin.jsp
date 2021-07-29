<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin View | Learning Portal</title>
</head>
<body>	
	<h2>Hello Admin: ${admin.getName() }</h2>
	<h3>Email logged in: ${admin.getEmail() }</h3>
	<hr/>
	<div align="justify">
		<form action="" method="post">
			<input type="submit" value="Add New Course"/>
		</form>
	</div>
	<br/>
	<h3>All Courses in Catalog</h3>
	<div align="justify">
		<table style="width: 85%">
			<tr>      
				<th>Course ID</th>
				<th>Course Name</th>
				<th>Course Description</th>
				<th>Course Fee</th>
				<th>Course Resources</th>
				<th></th>
				<th></th>
			</tr>
			<c:forEach items="${courses}" var="course">
			    <tr>      
			        <td>${course.getCourseId() }</td>
			        <td>${course.getCName() }</td>
			        <td>${course.getCDesc() }</td>
			        <td>${course.getCFees() }</td>
			        <td>${course.getCResc() }</td>
			        <td>
						<form action="" method="post">
							<input type="submit" value="Edit Course"/>
						</form>
			        </td>
			        <td>
						<form action="" method="post">
							<input type="submit" value="Delete Course"/>
						</form>
			        </td>
			    </tr>
			</c:forEach>
		</table>
	</div>
	<hr/>
	<div align="center">
		<form action="logout" method="post">
			<input type="submit" value="Logout"/>
		</form>
	</div>
</body>
</html>