<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Issued Books</title>

<link rel="stylesheet" href="style.css">
</head>
<body>

 <%--Importing all the dependent classes--%>
<%@page import="java.util.List"%>     
<%@page import="java.util.ArrayList"%> 
<%@page import="com.xoriant.beans.IssuedBook"%>
<%@page import="java.util.Iterator"%> 

<% List<IssuedBook> issuedBooks = (ArrayList) request.getAttribute("issuedBooks"); %>


<strong><a>View All Issued Books</a></strong>
<br></br>

<table cellspacing="2" cellpadding="2"  border="1">

<tr><th>ID</th><th>User ID</th><th>Book Id</th><th>Issue Date</th><th>Returning date</th><th>Days Left</th><th>Status</th><th>Approver</th><th>Fine</th></tr>
<%
// Iterating through subjectList

if(request.getAttribute("issuedBooks") != null)  // Null check for the object
{
	Iterator<IssuedBook> iterator = issuedBooks.iterator();  // Iterator interface
	
	while(iterator.hasNext())  // iterate through all the data until the last record
	{
		IssuedBook issuedBook = iterator.next(); //assign individual employee record to the employee class object
	%>
	<tr><td><%=issuedBook.getIssueId()%></td>
		<td><%=issuedBook.getStudent().getUserId()%></td>
		<td><%=issuedBook.getBook().getBookId()%></td>
		<td><%=issuedBook.getIssueDate()%></td>
		<td><%=issuedBook.getReturningDate()%></td>
		<td><%=issuedBook.getDaysLeft()%></td>
		<td><%=issuedBook.getStatus()%></td>
		<td><%=issuedBook.getApproverId()%></td>
		<td><%=issuedBook.getFine()%></td>
	</tr>
	<%
	}
}
%>
</table>
</body>
</html>