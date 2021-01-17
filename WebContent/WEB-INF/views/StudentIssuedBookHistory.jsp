<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Issued Book History</title>
<style>
		body {font-family: Arial, Helvetica, sans-serif;
	background-color:Ivory!important;
		 font-style: italic;
		 background-image:url("https://static-cse.canva.com/blob/140234/Rainbow-Gradient-Pink-and-Purple-Zoom-Virtual-Background.png");
	}
		 
		 
	h3
	{
		margin-top:50px;
		margin-left:40%;
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
		margin-top:-10px;
		
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
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="style.css">
</head>
<body>
	
<%@page import="java.util.List"%>     
<%@page import="java.util.ArrayList"%> 
<%@page import="com.xoriant.beans.IssuedBook"%>
<%@page import="java.util.Iterator"%> 

<% List<IssuedBook> issuedBooks = (ArrayList) request.getAttribute("issuedBooks"); %>

<div class="row">
	<div class="col-md-12">
		<h3>ISSUED BOOKS</h3>
	</div>
</div>

<br></br>

<table class="table table-stripped" cellspacing="2" cellpadding="2"  border="1">
<thead class="thead-dark">
<tr><th>ID</th><th>Book Id</th><th>Issue Date</th><th>Returning date</th><th>Days Left</th><th>Status</th><th>Approver</th><th>Fine</th></tr>
</thead>
<%
// Iterating through subjectList

if(request.getAttribute("issuedBooks") != null)  // Null check for the object
{
	Iterator<IssuedBook> iterator = issuedBooks.iterator();  // Iterator interface
	
	while(iterator.hasNext())  // iterate through all the data until the last record
	{
		IssuedBook issuedBook = iterator.next(); //assign individual employee record to the employee class object
	%>
	<tr><td class="text-primary"><%=issuedBook.getIssueId()%></td>
		<td class="text-primary"><%=issuedBook.getBook().getBookId()%></td>
		<td class="text-primary"><%=issuedBook.getIssueDate()%></td>
		<td class="text-primary"><%=issuedBook.getReturningDate()%></td>
		<td class="text-primary"><%=issuedBook.getDaysLeft()%></td>
		<td class="text-primary"><%=issuedBook.getStatus()%></td>
		<td class="text-primary"><%=issuedBook.getApproverId()%></td>
		<td class="text-primary"><%=issuedBook.getFine()%></td>
	</tr>
	<%
	}
}
%>
</table>


</body>
</html>