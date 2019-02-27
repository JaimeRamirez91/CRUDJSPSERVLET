<%-- 
    Document   : home
    Created on : 02-11-2019, 09:33:42 AM
    Author     : Jaime
--%>

<%@ page isELIgnored="false" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Servlet, JSP and JDBC CRUD Operations</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
</head>
<body class="container">
        <h1 class="text-center">Listado de Customers</h1>
        <table class="table table-striped text-center">
		<tr>
			<th>ID</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
			<th>Mobile</th>
			<th>Update</th>
			<th>Delete</th>
		</tr>
		<c:forEach items="${customerList}" var="customer">
			<tr>
				<td>${customer.id}</td>
				<td>${customer.firstName}</td>
				<td>${customer.lastName}</td>
				<td>${customer.email}</td>
				<td>${customer.mobile}</td>
				
				<td>
					<form action="<c:url value="/Custumer"/>" method="POST">
                                            <input type="hidden" name="redirectUpdate" value="true"><!-- input oculto -->
                                            <input type="hidden" name="option" value="update"><!-- input oculto -->
                                            <input type="hidden" name="custId" value="${customer.id}"><!-- input oculto -->
                                            <input type="hidden" name="firstName" value="${customer.firstName}"><!-- input oculto -->
                                            <input type="hidden" name="lastName" value="${customer.lastName}"><!-- input oculto -->
					    <input type="hidden" name="email" value="${customer.email}"><!-- input oculto -->
                                            <input type="hidden" name="mobile" value="${customer.mobile}"><!-- input oculto -->
                                            <input type="submit" value="Update" class="btn btn-outline-success">
					</form>
				<td>
					<form action="<c:url value="/Custumer"/>" method="POST">
                                                <input type="hidden" name="redirectUpdate" value="true"><!-- input oculto -->
                                                 <input type="hidden" name="option" value="delete"><!-- input oculto -->
						<input type="hidden" name="custId" value="${customer.id}"><!-- input oculto -->
                                                <input type="hidden" name="firstName" value="${customer.firstName}"><!-- input oculto -->
						<input  type="submit" value="Delete" class="btn btn-outline-danger">
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>