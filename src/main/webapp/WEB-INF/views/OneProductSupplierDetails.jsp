
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.bharath.model.Category"%>
<%@page import="java.util.List"%>
   <%@page isELIgnored="false"  %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="sform" %>
   <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
 <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
   <div class="container-fluid">
  <div class="row">
<div class="col" style="background-color:lavender;">
ProductImages:  <img src="resources/project-images/${prod.productId}.jpg" style="width:50%;">
</br>
ProductName:  <td>${prod.productName}</td>
</br>
ProductDescription:  <td>${prod.productDiscription}</td>
</br>
ProductPrice:  <td>${prod.productPrice}</td>
</br>
ProductSupplier:  <td>${prod.productSupplier}</td>
</br>
<form action="AddToCart">
ProductId <input type="number" value="${prod.productId}" name="id"/>
Quantity <input type="number" name="Quantity"/>
<input type="submit" value="AddToCart"/>
</form>
</br>
<a href="#">BuyNow</a>
</div>
 </div>
</div>

</body>
</html>