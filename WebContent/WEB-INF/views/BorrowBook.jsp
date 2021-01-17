<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Issue Book</title>
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
	position: fixed !important;
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
	margin-left: 85px;
	width: 90% !important;
	margin-top: 200px;
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
			<h3>BORROW BOOK</h3>
		</div>
	</div>
	<table class="table table-stripped" border=1, cellpadding="5">
		<thead class="thead-dark">
			<tr>

				<th>Book Id</th>
				<th>Book Name</th>
				<th>Book Type</th>
				<th>Book Author</th>
				<th>Book Publication</th>
				<th>Available Quantity</th>
				<th>Total Quantity</th>
				<th>Description</th>
				<th>Action</th>

			</tr>
		</thead>
		<tbody>
			<c:forEach items="${books}" var="book">
				<tr>
					<td class="text-primary"><c:out value="${book.bookId}" /></td>
					<td class="text-primary"><c:out value="${book.bookName}" /></td>
					<td class="text-primary"><c:out value="${book.bookType}" /></td>
					<td class="text-primary"><c:out value="${book.author}" /></td>
					<td class="text-primary"><c:out value="${book.publication}" /></td>
					<td class="text-primary"><c:out
							value="${book.availableQuantity}" /></td>
					<td class="text-primary"><c:out value="${book.totalQuantity}" /></td>
					<td class="text-primary"><c:out value="${book.description}" /></td>
					<td><a class="btn btn-success"
						href="<c:url value='/borrow/${book.bookId}' />">Issue Book</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>