<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container" align="center">
		<div class="card">
			<div class="card-body">
				<form action=" http://localhost:2300/Java_Case_Study/studentDataAdd/${userId}" method="post">
					<div class="form-group row">
						<label for="rollno" class="col-sm-2 col-form-label">Roll
							no:</label>
							<input type="text" name="rollno">

					</div>
					<br />
					<div class="form-group row">
						<label for="registration" class="col-sm-2 col-form-label">
							Registration number:</label>
						
							<input type="text" name="registration">
						
					</div>
					<br /> 
					<button type="submit" class="btn btn-primary">Submit</button>
					</form>
			</div>
		</div>
	</div>

</body>
</html>