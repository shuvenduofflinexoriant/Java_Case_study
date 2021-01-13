<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<title>Insert title here</title>
<style type="text/css">

	body {font-family: cursive;
	background-color:Ivory!important;
		 font-style: italic;}

	
.form-inline
{

	margin-left:180px;
	border:2px solid black;
	margin-top:30px;
	width:70%;
	height:90%;
	margin-bottom:10px;
	
}
	
	.form-inline label {
	  margin: 5px 10px 5px 0;
	  width:50% !important;
	  display: inline-block;
	  margin-left:100px;
	  font-weight:bold !important;
	}
	
	.form-inline input {

	  margin-top:15px;
	  margin-bottom:15px;
	  margin-left:-200px !important;
	  padding: 10px;
	  background-color: #fff;
	  width:40%!important;
	}
	
	.form-inline button {
	  padding: 10px 20px;
	  background-color: dodgerblue;
	  border: 1px solid #ddd;
	  color: white;
	  cursor: pointer;
	  margin-top:15px;
	  width:25%;
	  margin-bottom:10px;
	  margin-left:36% !important;
	}
	
	.form-inline button:hover {
	  background-color: royalblue;
	}
	
	h3
	{
		margin-top:10px;
		margin-left:35%;
		font-size:30px;
		font-weight:bold!important;
		color:#06022B;
		text-align:center;
		width:350px;
	}
	}
</style>
</head>

    <body>
    
    	<h3 class=" bg-light text-dark">REGISTER STUDENT</h3>
        
   		<form class="form-inline" action="http://localhost:2121/Java_Case_Study/submitForm" method="post">
	
		
		<label for="name"><b> Student Name:</b></label>
		<input type="text" name="name" id="name" placeholder="Enter Name" required>
		<br/>
		<label for="admissionDate"><b>Admission Date:</b></label>
		<input type="date" name="admissionDate" placeholder="Enter Admission Date" id="admissionDate" required>
		<br/>
		<label for="releaseDate"><b>Release Date:</b></label>
		<input type="date" name="releaseDate" placeholder="Enter Relese Date" id="releaseDate" required>
		<br/>
		<label for="address"><b>Address:</b></label>
		<input type="text" name="address" placeholder="Enter Address" id="address" required>
		<br/>
		<label for="contactNumber"><b>Contact Number:</b></label>
		<input type="text" name="contactNumber" placeholder="Enter Contact Number" id="contactNumber" required>
		<br/>
		
		
		<button type="submit" class="btn btn-primary" id="submit">Submit</button>
		
	</form>
    </body>
</html>