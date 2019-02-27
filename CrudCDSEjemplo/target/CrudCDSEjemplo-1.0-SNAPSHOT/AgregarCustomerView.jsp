<%-- 
    Document   : AgregarCustomerView
    Created on : 02-12-2019, 10:38:28 AM
    Author     : Jaime
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
    </head>
    <body class="container">
     
        <h1 class="text-center"> ${mensaje} </h1>
   
        <c:url value="/Custumer" var="registerUrl" /> <!-- URL petición-->

        <form method="POST" action="${registerUrl}" class="col-6 offset-3">
             <input type="hidden" name="option" value="add">
            <section class="form-group">
                <label> Nombre:</label>
                <input type="text" name="firstName" class="form-control">
            </section>            
            <section class="form-group">
                    <label> Apellido:</label>
                    <input type="text" name="lastName" class="form-control">
            </section>
            <section class="form-group">
                    <label> Email:</label>
                    <input type="email" name="email" class="form-control">
            </section>
             <section class="form-group">
                    <label> Numero:</label>
                    <input type="number" name="mobile" class="form-control">
            </section>
            <input type="submit" class="col-4 offset-4 btn btn-outline-success" >
        </form>
    </body>
</html>
