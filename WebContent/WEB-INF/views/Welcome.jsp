<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>

body {

	
	font-family: cursive;
	background-color:Ivory!important;
	font-style: italic;
	background-image:url("https://images.unsplash.com/photo-1524995997946-a1c2e315a42f?ixid=MXwxMjA3fDB8MHxzZWFyY2h8NHx8bGlicmFyeXxlbnwwfHwwfA%3D%3D&ixlib=rb-1.2.1&w=1000&q=80")
		 }
		 
		 
	h3
	{
		margin-top:50px;
		margin-left:26%;
		font-size:35px;
		font-weight:bold!important;
		color:#1F5480;
	}
ul {
  list-style-type: none;
  margin-left: 10px;
  margin-right:10px;
  margin-top:100px;
  padding: 0;
  overflow: hidden;

  border-radius:35%;
  background-color: #333;
}



li a {
  display: block;
  color: white;
  text-align: center !important;
  padding: 14px 16px;
  float:left;
  padding-left:5px;
  margin-left:105px;
  text-decoration: none;
}



.active {
  background-color:#1F5480;
}
</style>
</head>
<body>
 <h3>Welcome To Library Management System</h3>


	
	<ul>
	  <li> <a href="SearchBook">SEARCH BOOK<i class="fa fa-search-plus" aria-hidden="true"></i><span class="sr-only">(current)</span></a></li>
	  <li><a href="borrow">BORROW BOOK</a></li>
	  <li> <a href="viewreturnrequests">VIEW BOOK RETURN REQUEST</a></li>
	  <li><a href="allissuedbooks">VIEW ALL ISSUED BOOKS</a></li>
	</ul>


</html>

</body>
</html>