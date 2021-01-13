<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <div align="center">
    <table border=1, cellpadding="5">
    <thead>
    <tr>
    <th> User Id</th>
    <th> Name</th>
    <th> Role</th>
    <th> Admission Date</th>
    <th> Release Date</th>
    <th> Address</th>
    <th> Contact Number</th>
    
   </tr>
    </thead>
    <c:forEach items="${studentData}" var="student">
      <tr>
      <td><c:out value="${student.userId}"/></td>
      <td><c:out value="${student.name}"/></td>
      <td><c:out value="${student.role}"/></td>
      <td><c:out value="${student.admissionDate}"/></td>
      <td><c:out value="${student.releaseDate}"/></td>
      <td><c:out value="${student.address}"/></td>
      <td><c:out value="${student.contactNumber}"/></td>
      <td><a href="<c:url value='/approveReturn/${student.userId}'/>">Approve</a></td>
    </c:forEach>    
    <tr>
    
    
    
    </table>
    
    
    
    
    </div>
</body>
</html>