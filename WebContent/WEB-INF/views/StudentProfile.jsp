<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Home</title>
<style>
	body {font-family: Arial, Helvetica, sans-serif;
	background-color:Ivory!important;
		 font-style: italic;
		 background-image:url("https://static-cse.canva.com/blob/140234/Rainbow-Gradient-Pink-and-Purple-Zoom-Virtual-Background.png");
	}
.profile-main {
	margin-top:0px;
	display: flex;
	flex-direction: row;
	padding: 5rem;
	align-content: center;
	text-align: center;
}
.card
{
	width:100% !important;
	
}



.malert {
	margin-top:-530px !important;
	right: 50px;
	top: 50px;
	width: 500px;
	height: 80px;
	margin-left:700px;
	z-index: 1;
	border-radius: 5px;
	border: solid 1px rgb(204, 82, 82);
	background-color: rgb(235, 116, 116);
	color: black;
	padding: 20px;
}

.right, .left {
	width: 50%;
}

.right {
	margin-top:400px;

	
}

.right>button {
	display: inline-block;
	width: 60%;
	margin-top: 10px;
	border-radius: 5px;
	height: 3rem;
	background-color: blue;
	color: white;
}

.right button:hover {
	scale: 1.1;
	background-color: white;
	color: blue;
	cursor: pointer;
}

.details h1, h4 {
	margin: 0;
}
.card-body
{
	font-size:20px;
	display:inline-block!important;
}
</style>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
	<div class="profile-main">
		<div class="left">
			<svg alt="profile-picture" width="250px" height="300px"
				id="457bf273-24a3-4fd8-a857-e9b918267d6a" data-name="Layer 1"
				xmlns="http://www.w3.org/2000/svg"
				xmlns:xlink="http://www.w3.org/1999/xlink" width="698" height="698"
				viewBox="0 0 698 698">
			<defs>
			<linearGradient id="b247946c-c62f-4d08-994a-4c3d64e1e98f" x1="349"
				y1="698" x2="349" gradientUnits="userSpaceOnUse">
			<stop offset="0" stop-color="gray" stop-opacity="0.25" />
			<stop offset="0.54" stop-color="gray" stop-opacity="0.12" />
			<stop offset="1" stop-color="gray" stop-opacity="0.1" /></linearGradient></defs>
			<title>profile pic</title>
			<g opacity="0.5">
			<circle cx="349" cy="349" r="349"
				fill="url(#b247946c-c62f-4d08-994a-4c3d64e1e98f)" /></g>
			<circle cx="349.68" cy="346.77" r="341.64" fill="#f5f5f5" />
			<path
				d="M601,790.76a340,340,0,0,0,187.79-56.2c-12.59-68.8-60.5-72.72-60.5-72.72H464.09s-45.21,3.71-59.33,67A340.07,340.07,0,0,0,601,790.76Z"
				transform="translate(-251 -101)" fill="#6c63ff" />
			<circle cx="346.37" cy="339.57" r="164.9" fill="#333" />
			<path
				d="M293.15,476.92H398.81a0,0,0,0,1,0,0v84.53A52.83,52.83,0,0,1,346,614.28h0a52.83,52.83,0,0,1-52.83-52.83V476.92a0,0,0,0,1,0,0Z"
				opacity="0.1" />
			<path
				d="M296.5,473h99a3.35,3.35,0,0,1,3.35,3.35v81.18A52.83,52.83,0,0,1,346,610.37h0a52.83,52.83,0,0,1-52.83-52.83V476.35A3.35,3.35,0,0,1,296.5,473Z"
				fill="#fdb797" />
			<path d="M544.34,617.82a152.07,152.07,0,0,0,105.66.29v-13H544.34Z"
				transform="translate(-251 -101)" opacity="0.1" />
			<circle cx="346.37" cy="372.44" r="151.45" fill="#fdb797" />
			<path
				d="M489.49,335.68S553.32,465.24,733.37,390l-41.92-65.73-74.31-26.67Z"
				transform="translate(-251 -101)" opacity="0.1" />
			<path
				d="M489.49,333.78s63.83,129.56,243.88,54.3l-41.92-65.73-74.31-26.67Z"
				transform="translate(-251 -101)" fill="#333" />
			<path
				d="M488.93,325a87.49,87.49,0,0,1,21.69-35.27c29.79-29.45,78.63-35.66,103.68-69.24,6,9.32,1.36,23.65-9,27.65,24-.16,51.81-2.26,65.38-22a44.89,44.89,0,0,1-7.57,47.4c21.27,1,44,15.4,45.34,36.65.92,14.16-8,27.56-19.59,35.68s-25.71,11.85-39.56,14.9C608.86,369.7,462.54,407.07,488.93,325Z"
				transform="translate(-251 -101)" fill="#333" />
			<ellipse cx="194.86" cy="372.3" rx="14.09" ry="26.42" fill="#fdb797" />
			<ellipse cx="497.8" cy="372.3" rx="14.09" ry="26.42" fill="#fdb797" /></svg>
			<div class="card">
				<div class="card-header">
					<h1><%=request.getAttribute("name")%></h1>
				</div>
				<div class="card-body">
					
					Role : STUDENT
					<br></br>
					ID :<%=request.getAttribute("id")%>
						<br></br>
					Registration Number : <%=request.getAttribute("regno")%>
						<br></br>
					Roll Number : <%=request.getAttribute("rollno")%>
						<br></br>
					Address : <%=request.getAttribute("address")%>
						<br></br>
					Admission Date : <%=request.getAttribute("admission")%>
				</div>
			</div>
		</div>
		<div class="right" >
			<button
				onclick="window.location='http://localhost:8016/Java_Case_Study/SearchBook'">
				<i class="fa fa-search" aria-hidden="true"></i> SEARCH BOOK
			</button>
			<button
				onclick="window.location='http://localhost:8016/Java_Case_Study/issuedBooks'">
				<i class="fa fa-book" aria-hidden="true"></i> ISSUED BOOK
			</button>
			<button
				onclick="window.location='http://localhost:8016/Java_Case_Study/borrowHistory'">
				<i class="fa fa-history" aria-hidden="true"></i> BORROWED HISTORY
			</button>
			<button
				onclick="window.location='http://localhost:8016/Java_Case_Study/updatePassword'">
				<i class="fa fa-key" aria-hidden="true"></i> UPDATE PASSWORD
			</button>
			<button
				onclick="window.location='http://localhost:8016/Java_Case_Study/logout'" >
				<i class="fa fa-sign-out" aria-hidden="true"></i> LOGOUT
			</button>
		</div>
	</div>

<% if(request.getAttribute("alert") != null) {%>
	<div class="malert"><%=request.getAttribute("alert") %></div>
	<%} %>
</body>
</html>