<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div>
	<h1>Fine Collection Success!</h1>
	<h4>Book : <%=request.getAttribute("bookname") %></h4>
	<h4>User Id : <%=request.getAttribute("userid") %></h4>
	<h4>Name : <%=request.getAttribute("username") %></h4>
	<h4>Fine Amount: <%=request.getAttribute("fine") %></h4>
	<h4>Approver : <%=request.getAttribute("approver")%></h4>
	<h4>Status : Successfull</h4>
	
	<button onclick="location.href='http://localhost:8016/Java_Case_Study/">HOME</button>
</div>
</body>
</html>