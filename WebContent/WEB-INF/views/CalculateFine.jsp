<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book Fine</title>
</head>
<body>
<div class="container">
	<h2>This book is Due with Due Date!!</h2>
	<h4>Book : <%=request.getAttribute("bookname") %></h4>
	<h4>Book ID: <%=request.getAttribute("bookid") %></h4>
	<h4>Book Type : <%=request.getAttribute("booktype") %></h4>
	<h4>Delay In Days : <%=request.getAttribute("days") %></h4>
	<h4>Fine Per Day : <%=request.getAttribute("fineperday") %></h4>
	<h4>Fine Amount: <%=request.getAttribute("fine") %></h4>
	<br>
	<button onclick="location.href='http://localhost:8016/Java_Case_Study/collectFine/<%=request.getAttribute("issuedId")%>'">Collect Fine</button>
</div>
</body>
</html>