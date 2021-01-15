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
Returned Books

<table>
<thead>
		<tr>
			<th>Book ID</th>
			<th>Book Name</th>
			<th>Book Status</th>
		
		</tr>
	</thead>
  <c:forEach items="${returnedBooks}" var="returnedBook">
    <tr>
      <td><c:out value="${returnedBook.value.bookId}" /></td>
      <td><c:out value="${returnedBook.key}" /></td>
      <td><c:out value="${returnedBook.value.status}" /></td>
     
    </tr>
  </c:forEach>
</table>
</body>
</html>