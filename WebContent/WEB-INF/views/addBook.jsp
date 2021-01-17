<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<title>Add Book</title>
<style type="text/css">
body {
	font-family: Arial, Helvetica, sans-serif;
	background-color: Ivory !important;
	font-style: italic;
	background-image:
		url("https://static-cse.canva.com/blob/140234/Rainbow-Gradient-Pink-and-Purple-Zoom-Virtual-Background.png");
}

.form-inline {
	margin-left: 220px;
	border: 2px solid black;
	margin-top: 30px;
	margin-bottom: 10px;
	width: 60% !important;
}

.form-inline label {
	margin: 5px 10px 5px 0;
	width: 50% !important;
	display: inline-block;
	margin-left: 90px;
	margin-top: 50px;
	font-weight: bold !important;
}

.form-inline input {
	margin-top: -50px;
	margin-left: 280px;
	padding: 10px;
	background-color: #fff;
	width: 40% !important;
}

.form-inline button {
	padding: 10px 20px;
	background-color: dodgerblue;
	border: 1px solid #ddd;
	color: white;
	cursor: pointer;
	margin-top: 80px;
	width: 25%;
	margin-bottom: 20px;
	margin-left: -40% !important;
}

.form-inline button:hover {
	background-color: royalblue;
}

h3 {
	margin-top: 10px;
	margin-left: 40%;
	font-size: 30px;
	font-weight: bold !important;
}

#password {
	margin-top: -180px !important;
}
</style>



</head>
<body>
	<h3 class="text-info">ADD BOOK</h3>
	<form class="form-inline"
		action="http://localhost:8016/Java_Case_Study/bookAddSubmit"
		method="POST">


		<label for="bookName"><b> Book Name:</b></label> <input type="text"
			name="bookName" id="bookName" required> <label for="author"><b>Author:</b></label>
		<input type="text" name="author" id="author" required> <label
			for="publication"><b>Publication:</b></label> <input type="text"
			name="publication" id="publication" required> <label
			for="description"><b>Description:</b></label> <input type="text"
			name="description" id="description" required> <label
			for="totalQuantity"><b>Total Quantity:</b></label> <input
			type="number" name="totalQuantity" id="totalQuantity" required>

		<label for="publishDate"><b>Publish Date:</b></label> <input
			type="date" name="publishDate" id="publishDate" required> <label
			for="availableOn"><b>Available On:</b></label> <input type="date"
			name="availableOn" id="availableOn" required> <label
			for="bookType"><b>Book Type:</b></label> <input type="text"
			style="margin-top: -160px;" name="bookType" id="bookType" required>


		<button class="btn btn-primary" id="submitbutton" type="submit"
			value="Submit">Submit</button>
	</form>
</body>
</html>