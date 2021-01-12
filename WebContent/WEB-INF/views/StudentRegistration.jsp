<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">

label{

   display: inline-block ;
   width: 200px ;
   margin: 2px 2px 2px 2px ;
   text-align: left ;

}

</style>
</head>

    <body>
        <h3>Welcome, Enter The Employee Details</h3>
   <form class="form-inline" action="http://localhost:8016/Java_Case_Study/submitForm" method="post">
	
		
		<label for="name"><b> Student Name:</b></label>
		<input type="text" name="name" id="name">
		<br/>
		<label for="admissionDate"><b>Admission Date:</b></label>
		<input type="date" name="admissionDate" id="admissionDate">
		<br/>
		<label for="releaseDate"><b>Release Date:</b></label>
		<input type="date" name="releaseDate" id="releaseDate">
		<br/>
		<label for="address"><b>Address:</b></label>
		<input type="text" name="address" id="address">
		<br/>
		<label for="contactNumber"><b>Contact Number:</b></label>
		<input type="text" name="contactNumber" id="contactNumber">
		<br/>
		<label for="registrationNumber"><b>Registration Number:</b></label>
		<input type="text" name="registrationNumber" id="registrationNumber">
		<br/>
		<label for="rollNumber"><b>Roll Number:</b></label>
		<input type="text" name="rollNumber" id="rollNumber">
		<br/>
		
		<button type="submit" id="submit">Submit</button>
	</form>
    </body>
</html>