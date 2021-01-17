<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<style>

		body {font-family: Arial, Helvetica, sans-serif;
	background-color:Ivory!important;
		 font-style: italic;
		 background-image:url("https://static-cse.canva.com/blob/140234/Rainbow-Gradient-Pink-and-Purple-Zoom-Virtual-Background.png");
	}

</style>
</head>
<body>
<div class="card">

	<h1 class="card-header">Fine Collection Success!</h1>
	<div class="card-body">
		<h4>Book : <%=request.getAttribute("bookname") %></h4>
		<h4>User Id : <%=request.getAttribute("userid") %></h4>
		<h4>Name : <%=request.getAttribute("username") %></h4>
		<h4>Fine Amount: <%=request.getAttribute("fine") %></h4>
		<h4>Approver : <%=request.getAttribute("approver")%></h4>
		<h4>Status : Successfull</h4>
		
		<button class="btn btn-primary" onclick="location.href='http://localhost:8016/Java_Case_Study/">HOME</button>
	</div>
</div>
</body>
</html>