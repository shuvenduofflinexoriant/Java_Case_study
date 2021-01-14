<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<title>Insert title here</title>
<style type="text/css">
label{
   display: inline-block ;
   width: 200px ;
   margin: 2px 2px 2px 2px ;
   text-align: left ;
}
body {

	
	font-family: cursive;
	background-color: rgba(218, 247, 166 );
	font-style: italic;
	background-image:url("https://www.xmple.com/wallpaper/linear-gradient-violet-pink-2560x1440-c2-d5caf0-f0cad9-a-255-f-14.svg")
		 }
		 
</style>
</head>
<body>
      
  <div class="container" align="center">
		<div class="card">
			<div class="card-body">
				<form action="http://localhost:8016/Java_Case_Study/bookAddSubmit" method="post">
					<div class="form-group row">
						<label for="bookName" class="col-sm-2 col-form-label">Book
							name:</label>
							<input type="text" name="bookName">

					</div>
					<br />
					<div class="form-group row">
						<label for="author" class="col-sm-2 col-form-label">
							 Author:</label>
						
							<input type="text" name="author">
						
					</div>
					<br /> 
					<div class="form-group row">
						<label for="publication" class="col-sm-2 col-form-label">
							Publication:</label>
						
							<input type="text" name="publication">
						
					</div>
					<br /> 
					<div class="form-group row">
						<label for="description" class="col-sm-2 col-form-label">
							Description:</label>
						
							<input type="text" name="description">
						
					</div>
					<br /> 
					<div class="form-group row">
						<label for="totalQuantity" class="col-sm-2 col-form-label">
							Total Quantity</label>
						
							<input type="number" name="totalQuantity">
				
					</div>
					<br /> 
					<div class="form-group row">
						<label for="availableQuantity" class="col-sm-2 col-form-label">
							Available Quantity</label>
						
							<input type="number" name="availableQuantity">
				
					</div>
					<br /> 
					
						<div class="form-group row">
						<label for="publishDate" class="col-sm-2 col-form-label">
							Publish Date</label>
						
							<input type="Date" name="publishDate">
					
					</div>
					<br />
					<div class="form-group row">
						<label for="availableOn" class="col-sm-2 col-form-label">
							Available On</label>
							<input type="Date" name="availableOn">
					</div>
					<br />
					<div class="form-group row">
						<label for="bookType" class="col-sm-2 col-form-label">
							 Book Type</label>
							<input type="text" name="bookType">
					</div>
					<br />
					
					
					<button type="submit" class="btn btn-primary">Submit</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>