<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Library Managment System</title>
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<style>
body {
	
	font-family: cursive;
	background-color:Ivory!important;
	font-style: italic;
	background-image:url("https://images.unsplash.com/photo-1524995997946-a1c2e315a42f?ixid=MXwxMjA3fDB8MHxzZWFyY2h8NHx8bGlicmFyeXxlbnwwfHwwfA%3D%3D&ixlib=rb-1.2.1&w=1000&q=80");
	background-repeat:no-repeat;
	background-size:100% 100%;
}

h3
	{
		margin-top:50px;
		margin-left:32%;
		font-size:35px;
		font-weight:bold!important;
		
	}
.card
{
	margin-left:-250px !important;
	margin-top:30px;
	 background:lavender;
	width:100% !important;
	height:20% important;
}	 
h2
{
	text-align:center;
	
}

label
{
	margin-left:20px;
	
}
input
{

	margin-left:10px;
}
button
{
	margin-left:100px;
	margin-top:10px;}
</style>
</head>
<body>
<h3 class="text-info">Library Management System</h3>

<!-- Modal HTML -->
<div class="app mt-8">
    <div class="container-fluid">
        <div class="d-flex full-height p-v-15 flex-column">
            
            <div class="container mt-5">
                <div class="row align-items-center">
                    <div class="col-md-5 d-none d-md-block">
                         </div>
                    <div class="offset-md-1 col-md-5 " id="login">
                        <div class="card myCard">
                            <div class="card-body text-dark px-4 py-5">
                                <h2 class="m-t-20 text-dark">LOG IN</h2>
                                    
                                <form name = login action ="/Java_Case_Study/login" method="POST">
                                    <div class="form-group my-4">
                                    <label class="font-weight-bold" for="userName">USER ID:</label>
                                    <input type="text" class="form-control" id="userId" name="userId"placeholder="Enter User Id" required>
                                    </div>
                                    <div class="form-group my-4">
                                    <label class="font-weight-bold" for="password">PASSWORD:</label>
                                    <input type="password" class="form-control" id="password" name="password"placeholder="Enter Password" required>
                                    <%if(request.getAttribute("error") != null){ %><label style="color:red ; margin-top:10px;" ><%=request.getAttribute("error") %></label><%} %>
                                    </div>                                                                             
                                    <div class="form-group">
                                    <div class="d-flex "> 
                                        <span class="font-size-13 text-muted">
                                            </span>
                                        <button class="btn btn-primary mb-5 "
                                            style="height: 10% !important;width: 45% !important; ">LOG IN
                                            </button>
                                    </div>
                                      <div class="registration">
                                      	<p style="margin-left:220px !important;">Don't have an account?
                                      
	        							<a style="float:right; margin-top:10px;" href="/Java_Case_Study/StudentRegistration">REGISTER HERE</a></p>
        							</div>
                                    </div>
                                </form> 
                            </div>
                        </div>
                    </div>                  
                </div>
            </div>
        </div>
    </div>
</div> 
</body>
</html>