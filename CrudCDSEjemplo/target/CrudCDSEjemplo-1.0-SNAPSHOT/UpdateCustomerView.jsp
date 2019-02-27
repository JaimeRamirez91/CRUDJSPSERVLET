<%-- 
    Document   : UpdateCustomerView
    Created on : 02-12-2019, 10:38:28 AM
    Author     : Jaime
--%>

<%@ page isELIgnored="false" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
    </head>
    <body class="container">
         <h1 class="text-center"> Actualizar Customer </h1>
         <c:url value="/Custumer" var="registerUrl" /> <!-- URL petición-->
         <form method="POST" action="${registerUrl}" class="col-6 offset-3">
                <c:forEach items="${datos}" var="customer">
                    <input type="hidden" name="option" value="update">
                    <input type="hidden" name="custId" value="${customer.id}">
                    <section class="form-group">
                        <label> Nombre: </label>
                        <input type="text" name="firstName" class="form-control" value="${customer.firstName}">
                    </section>            
                    <section class="form-group">
                            <label> Apellido:</label>
                            <input type="text" name="lastName" class="form-control" value="${customer.lastName}">
                    </section>
                    <section class="form-group">
                            <label> Email:</label>
                            <input type="email" name="email" class="form-control" value="${customer.email}">
                    </section>
                     <section class="form-group">
                            <label> Numero:</label>
                            <input type="number" name="mobile" class="form-control" value="${customer.mobile}">
                    </section>

                   <h1></h1>
                </c:forEach>
                 <input type="submit" class="col-4 offset-4 btn btn-outline-success" >
        </form>
    </body>
</html>

