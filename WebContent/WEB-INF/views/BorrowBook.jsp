<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<table border=1, cellpadding="5">
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
  		<c:forEach items="${books}" var="book">
    		<tr>
      			<td><c:out value="${book.bookId}" /></td>
      			<td><c:out value="${book.bookName}" /></td>
      			<td><c:out value="${book.bookType}" /></td>
      			<td><c:out value="${book.author}" /></td>
      			<td><c:out value="${book.publication}" /></td>
      			<td><c:out value="${book.availableQuantity}" /></td>
      			<td><c:out value="${book.totalQuantity}" /></td>
      			<td><c:out value="${book.description}" /></td>
  	  			<td><a href="<c:url value='/borrow/${book.bookId}' />" >Issue Book</a></td>
    		</tr>
  		</c:forEach>
</table>
</body>
</html>