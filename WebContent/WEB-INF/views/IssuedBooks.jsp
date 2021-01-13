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
Return Book

<table>

<thead>
		<tr>
			<th>Book ID</th>
			<th>Book Name</th>
			<th>Book Status</th>
			<th>Return Date</th>
			<th>Action</th>
		</tr>
	</thead>
  <c:forEach items="${issuedBooks}" var="issuedBook">
    <tr>
      <td><c:out value="${issuedBook.value.bookId}" /></td>
      <td><c:out value="${issuedBook.key}" /></td>
      <td><c:out value="${issuedBook.value.status}" /></td>
      <td><c:out value="${issuedBook.value.returningDate}" /></td>
  	  <td><a href="<c:url value='/returnBook/${issuedBook.value.issueId}' />" >Return Book</a></td>
    </tr>
  </c:forEach>
</table>

</body>
</html>