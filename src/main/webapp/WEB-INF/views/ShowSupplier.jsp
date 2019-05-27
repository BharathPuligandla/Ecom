
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="Adminhedder.jsp" %>
    <%@page import="com.bharath.model.Supplier"%>
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
SupplierName
</th>
<th>
SupplierDescription
</th>
<th>
SupplierAddress
</th>
<th>
Edit
</th>
<th>
Delete
</th>

</tr>
<c:forEach items="${supr}" var="sa">
<tr>
<td>${sa.supplierName}</td>
<td>${sa.supplierDetails}</td>
<td>${sa.supplierAddress}</td>
<td><a href="editsup?supid=${sa.supplierId}">edit</a></td>
<td><a href="deletesup?supid=${sa.supplierId}">delete</a></td>

</tr>

</c:forEach>

</table>
</body>
</html>