<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home | Learning Portal</title>
</head>
<body>
	<div align="right">
		<c:if test="${not empty message}">
			<p>${message}</p>
		</c:if>
	</div>
	<h2>Hello Learner: ${user.getName() }</h2>
	<h3>Email logged in: ${user.getEmail() }</h3>
	<hr/>
	<h3>Enrolled Courses</h3>
	<div align="justify">
		<table style="width: 85%">
			<tr>      
				<th>Course ID</th>
				<th>Course Name</th>
				<th>Course Description</th>
				<th>Course Fee</th>
				<th>Course Resources</th>
				<th></th>
			</tr>
			<c:forEach items="${enrolled}" var="course">
			    <tr>      
			        <td>${course.getCourseId() }</td>
			        <td>${course.getCName() }</td>
			        <td>${course.getCDesc() }</td>
			        <td>${course.getCFees() }</td>
			        <td>${course.getCResc() }</td>
			        <td>
						<a href="enroll?unenroll=${course.getCourseId()}"><button type="button">Unenroll</button></a>
			        </td>
			    </tr>
			</c:forEach>
		</table>
	</div>
	<br/>
	<h3>Other Courses in Catalog</h3>
	<div align="justify">
		<table style="width: 85%">
			<tr>      
				<th>Course ID</th>
				<th>Course Name</th>
				<th>Course Description</th>
				<th>Course Fee</th>
				<th>Course Resources</th>
				<th></th>
			</tr>
			<c:forEach items="${other_courses}" var="course">
			    <tr>      
			        <td>${course.getCourseId() }</td>
			        <td>${course.getCName() }</td>
			        <td>${course.getCDesc() }</td>
			        <td>${course.getCFees() }</td>
			        <td>${course.getCResc() }</td>
			        <td>
						<a href="enroll?enroll=${course.getCourseId()}"><button type="button">Enroll</button></a>
			        </td>
			        
			    </tr>
			</c:forEach>
		</table>
	</div>
	<br/>
	<!-- 
	<h3>All Courses</h3>
	<div align="justify">
		<table style="width: 85%">
			<tr>      
				<th>Course ID</th>
				<th>Course Name</th>
				<th>Course Description</th>
				<th>Course Fee</th>
				<th>Course Resources</th>  
			</tr>
			<c:forEach items="${courses}" var="course">
			    <tr>      
			        <td>${course.getCourseId() }</td>
			        <td>${course.getCName() }</td>
			        <td>${course.getCDesc() }</td>
			        <td>${course.getCFees() }</td>
			        <td>${course.getCResc() }</td>  
			    </tr>
			</c:forEach>
		</table>
	</div>
	 -->
	<hr/>
	<div align="center">
		<form action="logout" method="post">
			<input type="submit" value="Logout"/>
		</form>
	</div>
</body>
</html>