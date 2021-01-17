<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>


<link rel="stylesheet" href="style.css">
<style>
		body {font-family: Arial, Helvetica, sans-serif;
	background-color:Ivory!important;
		 font-style: italic;
		 background-image:url("https://static-cse.canva.com/blob/140234/Rainbow-Gradient-Pink-and-Purple-Zoom-Virtual-Background.png");
	}
		 
		 
	h3
	{
		margin-top:50px;
		margin-left:37%;
		font-size:35px;
		position:fixed!important;
		font-weight:bold!important;
		color:#1F5480;
	}
	td
	{
		color:#5DD87C!important;
		font-size:15px;
		font-weight:bold;
		text-align:center;
	}
	input
	{	
		width: 500px !important;
		text-align :center !important;
		height:40px!important;
		
		margin-left:400px;
		margin-top:0px;
		
	}
	
	table
	{ 
	margin-left:85px;
	width:90% !important;
	margin-top:180px;
	margin-right:10px;
	
	}
	button
	{
			padding: 10px 20px;
	  		background-color: dodgerblue;
	 		border: 1px solid #ddd;
	  		color: white;
	  		cursor: pointer;
	  		text-align:center;
	  		margin-top:0px;
	  		width:100% !important;
	  		padding-bottom:5px!important ;
	  		margin-left:0px !important;
	}
</style>
</head>
<body>

 <%--Importing all the dependent classes--%>
<%@page import="java.util.List"%>     
<%@page import="java.util.ArrayList"%> 
<%@page import="com.xoriant.beans.IssuedBook"%>
<%@page import="java.util.Iterator"%> 

<% List<IssuedBook> issuedBooks = (ArrayList) request.getAttribute("issuedBooks"); %>

<div class="row">
	<div class="col-md-12">
		<h3> BOOK RETURNED REQUESTS</h3>
	</div>
</div>

<br></br>


<%
// Iterating through subjectList

if(request.getAttribute("issuedBooks") != null && !issuedBooks.isEmpty())  // Null check for the object
{
	
	%>
	<table class="table table-stripped" cellspacing="2" cellpadding="2"  border="1">
<thead class="thead-dark">
	<tr><th>ID</th><th>User ID</th><th>Book Id</th><th>Issue Date</th><th>Returning date</th><th>Returned date</th><th>Status</th><th>APPROVE</th></tr>
</thead>
	<%
	
	Iterator<IssuedBook> iterator = issuedBooks.iterator();  // Iterator interface
	
	while(iterator.hasNext())  // iterate through all the data until the last record
	{
		IssuedBook issuedBook = iterator.next(); //assign individual employee record to the employee class object
	%>
	<tr><td class="text-primary" ><%=issuedBook.getIssueId()%></td>
		<td class="text-primary" ><%=issuedBook.getStudent().getUserId()%></td>
		<td class="text-primary" ><%=issuedBook.getBook().getBookId()%></td>
		<td class="text-primary" ><%=issuedBook.getIssueDate()%></td>
		<td class="text-primary" ><%=issuedBook.getReturningDate()%></td>
		<td class="text-primary" ><%=issuedBook.getReturnedDate() %></td>
		<td class="text-primary" ><%=issuedBook.getStatus() %></td>
		<td  ><a  class="btn btn-success" href="approveReturn/<%=issuedBook.getIssueId()%>">APPROVE</a></td>
	</tr>
	<%
	}
}else{
	%>
	No Return Request Present!
	<%
}
%>
</table>


</body>
</html>