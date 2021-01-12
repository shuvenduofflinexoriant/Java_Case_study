<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book Fine</title>
</head>
<body>
	This book is Due with Due Date!!
	Dealy In Days : <%=request.getAttribute("days") %>
	Fine Amount: <%=request.getAttribute("fine") %>
	<button>Collect Fine</button>
</body>
</html>