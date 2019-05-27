
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="Adminhedder.jsp" %>
    <%@page import="com.bharath.model.Category"%>
<%@page import="java.util.List"%>
   <%@page isELIgnored="false"  %>
   <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
<table border="1">
<tr>
<th>
ProductName
</th>
<th>
ProductDescription
</th>
<th>
ProductPrice
</th>
<th>
ProductSupplier
</th>
<th>
ProductCategory
</th>
<th>
ProductImages
</th>
<th>
Edit
</th>
<th>
Delete
</th>
</tr>
<c:forEach items="${prod}" var="pr">
<tr>
<td>${pr.productName}</td>
<td>${pr.productDiscription}</td>
<td>${pr.productPrice}</td>
<td>${pr.productSupplier}</td>
<td>${pr.productCategory}</td>
<td><img src="resources/project-images/${pr.productId}.jpg" style="width:100%;"></td>
<td><a href="editpro?proid=${pr.productId}">edit</a></td>
<td><a href="deletepro?proid=${pr.productId}">delete</a></td>
</tr>
</c:forEach>
</table>
</body>
</html>