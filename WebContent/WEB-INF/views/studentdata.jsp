<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Approve Student</title>
<style type="text/css">
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
	
	
</style>

</head>
 <body>
    
    
        
   		<form class="form-inline" action=" http://localhost:8016/Java_Case_Study/studentDataAdd/${userId}" method="post">
	
		
		<label for="rollno"><b> Roll Number:</b></label>
		<input type="text" name="rollno" id="rollno"  style="margin-top:-40px;" required >
		<br></br>
		<label for="registration"><b>Registration Number:</b></label>
		<input type="text" name="registration" style="margin-top:-40px; margin-bottom:150px;" id="registration"  required>
		
	
		
		
		<button class="btn btn-primary" id="submitbutton" style="margin-top:70px !important; position:fixed; margin-left:-400px !important;" type="submit" value="Submit" >Submit</button>
	</form>
    </body>
</html>