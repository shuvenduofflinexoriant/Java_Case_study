<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Liberian</title>
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
				<form action=" http://localhost:8016/Java_Case_Study/liberianadded" method="post">
					<div class="form-group row">
						<label for="liberianName" class="col-sm-2 col-form-label">Liberian
							name:</label>
							<input type="text" name="liberianName">
					</div>
					<div class="form-group row">
						<label for="password" class="col-sm-2 col-form-label">New Password :</label>
							<input type="password" name="password">
					</div>
					<div class="form-group row">
						<label for="confirmpassword" class="col-sm-2 col-form-label">Re-enter Password :</label>
							<input type="password" name="confirmpassword">
					</div>
					  <%if(request.getAttribute("error") != null){ %><label color="red"><%=request.getAttribute("error") %></label><%} %>
					<br />
					
					<button type="submit" class="btn btn-primary">Submit</button>
				</form>
			</div>
		</div>
	</div>

</body>
</html>