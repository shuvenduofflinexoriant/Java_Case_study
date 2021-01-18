<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<title>Update Password</title>

<style type="text/css">
label{
   display: inline-block ;
   width: 200px ;
   margin: 2px 2px 2px 2px ;
   text-align: left ;
}
	body {font-family: Arial, Helvetica, sans-serif;
	background-color:Ivory!important;
		 font-style: italic;
		 background-image:url("https://static-cse.canva.com/blob/140234/Rainbow-Gradient-Pink-and-Purple-Zoom-Virtual-Background.png");
	}
	.form-inline
{
	margin-left:220px;
	border:2px solid black;
	margin-top:30px;
	margin-bottom:10px;
	width:60% !important;
	
}
	
	.form-inline label {
	  margin: 5px 10px 5px 0;
	  width:50% !important;
	  display: inline-block;
	  margin-left:90px;
		margin-top:50px;
		
	  font-weight:bold !important;
	}
	
	.form-inline input {

		
	 	margin-left:280px;
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
	  margin-top:80px;
	  width:25%;
		margin-bottom:20px;
	  margin-left:-40% !important;
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
		
	}
	#password
	{
		margin-top:-180px !important;
	}
	
	p{
	 margin-top: 15rem;
    margin-left: 2rem;
    text-align: left;
    margin-right: 5rem;
    position: absolute;
	}
	
	
</style>
</head>
<body>
<h3 class="text-info">UPDATE PASSWORD</h3>
<form class="form-inline" action=" http://localhost:8016/Java_Case_Study/updatePassword" method="POST">
	
		
		<label for="oldpassword"><b>Enter old Password :</b></label>
		<input type="text" name="oldpassword" id="oldpassword" style="margin-top:-30px !important;"required >
		<br></br>
		<label for="password"><b>New Password :</b></label>
		<input type="password" name="password" id="password" style="margin-top:-30px !important;" required>
		<br></br>
		<label for="confirmpassword"><b>Re-enter Password :</b></label>
		<input type="password" name="confirmpassword" id="confirmpassword" style="margin-top:-150px !important;" required>
		
		
		 <%if(request.getAttribute("error") != null){ %><p color="red"><%=request.getAttribute("error") %></p><%} %>
		 <br></br>
		
		
		<button class="btn btn-primary" id="submitbutton" type="submit" value="Submit" >UPDATE PASSWORD</button>
	</form>

</body>
</html>