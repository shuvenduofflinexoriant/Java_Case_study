<%@page import="java.sql.Connection"%>
<%@page import="com.xoriant.beans.Book"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.Transaction"%>
<%@page import="org.hibernate.Session"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="org.hibernate.boot.MetadataSources"%>
<%@page import="org.hibernate.boot.Metadata"%>
<%@page import="org.hibernate.boot.registry.StandardServiceRegistryBuilder"%>
<%@page import="org.hibernate.boot.registry.StandardServiceRegistry"%>
<%@page import="java.sql.DriverManager" %>
<%@page import="java.sql.ResultSet" %>
<%@page import="java.sql.Statement" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<style>
	body
	{
		background-color:Ivory!important;
		 font-style: italic;
		 font-family: Arial, Helvetica, sans-serif;
	}
	h3
	{
		margin-left:350px;
		margin-top:10px !important;
		position:fixed!important;
		font-size:50px;
	}
	input
	{	
		width: 350px !important;
		text-align :center !important;
		height:40px!important;
		padding-bottom:10px !important;
		margin-left:350px;
		margin-top:50px;
		position:fixed!important;
	}
	
	table
	{ 
	margin-left:10px;
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
	<div class="row">
		<div class="col-md-12">
			<h3 class="text-info">SEARCH BOOK</h3>
		</div>
	</div>
	</br>
	</br>
	
	<div>
		<div class="col-md-12">
		
			<form action="" method="get">
			
				<input type="text"  class="form-control" name="keyword" placeholder="Search By Keyword"/>
				
			</form>
		
		</div>
	
	</div>
	</br>
	</br>
	</br>
	</br>
	</br>
	</br>
	<table class="table table-striped" border=1, cellpadding="5" >
		<thead class="thead-light">
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
		</thead>
		<tbody>
			<%
			try {
				//2.register the connection object
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				//3.create connection
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagementdb","root","admin");
				
				System.out.println("Connected");
				
				Statement st = con.createStatement();
				
				ResultSet res = null;
					
				String query = request.getParameter("keyword");
				
				String data;
				if(query!=null)
				{
					data = "select * from books where bookName like '%"+query+"%' or bookId like '%"+query+"%' or author like '%"+query+"%' or publication like '%"+query+"%'";
					
				}
				else
				{
					data = "select * from books";
				}
				res = st.executeQuery(data);
				while(res.next())
				{
					
				%>
			
			
			<tr>
	      			<td><%=res.getString("bookId") %></td>
	      			<td><%=res.getString("bookName") %></td>
	      			<td><%=res.getString("bookType") %></td>
	      			<td><%=res.getString("author") %></td>
	      			<td><%=res.getString("publication") %></td>
	      			<td><%=res.getString("availableQuantity") %></td>
	      			<td><%=res.getString("totalQuantity") %></td>
	      			<td><%=res.getString("description") %></td>
	      			<%if(Integer.parseInt(res.getString("availableQuantity"))>0){ %>
	  	  			<td><button class="btn btn-primary" onclick="window.location='http://localhost:8016/Java_Case_Study/borrow/<%=res.getString("bookId")%>'"  type="submit">ISSUE</button>
	  	  			<% }else {%><td><button class="btn btn-primary" disabled type="submit">Book not available</button></td><%}; %>
	    		</tr>
	    		<%
				}
			}catch(Exception e)
				{
					e.printStackTrace();
				}
	  		%>
	  		

	  	</tbody>
</table>

</body>
</html>