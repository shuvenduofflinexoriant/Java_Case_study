<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book Fine</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<style>

	body {

	
			font-family: cursive;
			background-color: rgba(218, 247, 166 );
			font-style: italic;
			background-image:url("https://www.xmple.com/wallpaper/linear-gradient-violet-pink-2560x1440-c2-d5caf0-f0cad9-a-255-f-14.svg")
}
		 
</style>
</head>
<body>
<div class="container">
	<div  class="card">
		<h2 class="card-header">This book is Due with Due Date!!</h2>
		<div class="card-body">
			<h4>Book : <%=request.getAttribute("bookname") %></h4>
			<h4>Book ID: <%=request.getAttribute("bookid") %></h4>
			<h4>Book Type : <%=request.getAttribute("booktype") %></h4>
			<h4>Delay In Days : <%=request.getAttribute("days") %></h4>
			<h4>Fine Per Day : <%=request.getAttribute("fineperday") %></h4>
			<h4>Fine Amount: <%=request.getAttribute("fine") %></h4>
			<button class="btn btn-primary" onclick="location.href='http://localhost:8016/Java_Case_Study/collectFine/<%=request.getAttribute("issuedId")%>'">Collect Fine</button>
		</div>
	</div>
</div>
</body>
</html>