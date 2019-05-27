
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.bharath.model.Category"%>
<%@page import="java.util.List"%>
   <%@page isELIgnored="false"  %>
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
 <c:forEach items="${prod}" var="pr">
 		<div class="col-sm-4" style="background-color:white;">
		<td><img src="resources/project-images/${pr.productId}.jpg" style="width:30%;"></td>
 		</br>
		ProductName:<td>${pr.productName}</td>
		</br>
		ProductDiscription: <td>${pr.productDiscription}</td>
		</br>
		ProductPrice: <td>${pr.productPrice}</td>
		</br>
		<td><a href="userSupplierDetails?proid=${pr.productId}">view Details</a></td>
		</br>
</div>
 </c:forEach>
   </div>

 </div>
</body>
</html>