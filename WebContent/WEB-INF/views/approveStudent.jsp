<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Approve Student</title>


<style>
body {
	font-family: Arial, Helvetica, sans-serif;
	background-color: Ivory !important;
	font-style: italic;
	background-image:
		url("https://static-cse.canva.com/blob/140234/Rainbow-Gradient-Pink-and-Purple-Zoom-Virtual-Background.png");
}

h3 {
	margin-top: 50px;
	margin-left: 40%;
	font-size: 35px;
	font-weight: bold !important;
	color: #1F5480;
}

td {
	color: #5DD87C !important;
	font-size: 15px;
	font-weight: bold;
	text-align: center;
}

input {
	width: 500px !important;
	text-align: center !important;
	height: 40px !important;
	margin-left: 400px;
	margin-top: 0px;
}

table {
	margin-left: 90px;
	width: 90% !important;
	margin-top: -20px;
	margin-right: 10px;
}

button {
	padding: 10px 20px;
	background-color: dodgerblue;
	border: 1px solid #ddd;
	color: white;
	cursor: pointer;
	text-align: center;
	margin-top: 0px;
	width: 100% !important;
	padding-bottom: 5px !important;
	margin-left: 0px !important;
}
</style>
</head>
<body>

	<div class="row">
		<div class="col-md-12">
			<h3>APPORVE STUDENT</h3>
		</div>
	</div>
	</br>
	</br>
	<table class="table table-striped" border=1, cellpadding="5">
		<thead class="thead-dark">
			<tr>
				<th>User Id</th>
				<th>Name</th>
				<th>Role</th>
				<th>Admission Date</th>
				<th>Release Date</th>
				<th>Address</th>
				<th>Contact Number</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${studentData}" var="student">
				<tr>
					<td class="text-primary"><c:out value="${student.userId}" /></td>
					<td class="text-primary"><c:out value="${student.name}" /></td>
					<td class="text-primary"><c:out value="${student.role}" /></td>
					<td class="text-primary"><c:out
							value="${student.admissionDate}" /></td>
					<td class="text-primary"><c:out
							value="${student.releaseDate}" /></td>
					<td class="text-primary"><c:out value="${student.address}" /></td>
					<td class="text-primary"><c:out
							value="${student.contactNumber}" /></td>
					<td><a class="text-primary"
						href="<c:url value='/approveStudentRegistration/${student.userId}'/>">Approve</a></td>
				</tr>

			</c:forEach>

		</tbody>



	</table>




</body>
</html>