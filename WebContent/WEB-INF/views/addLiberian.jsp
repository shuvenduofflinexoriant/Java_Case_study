<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<div class="container" align="center">
		<div class="card">
			<div class="card-body">
			<h1>Add Liberian</h1>
				<form action=" http://localhost:2300/Java_Case_Study/liberianadded" method="post">
					<div class="form-group row">
						<label for="liberianName" class="col-sm-2 col-form-label">Liberian
							name:</label>
							<input type="text" name="liberianName">

					</div>
					<br />
					
					<button type="submit" class="btn btn-primary">Submit</button>
					</form>
			</div>
		</div>
	</div>

</body>
</html>