
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
CategoryName
</th>
<th>
CategoryDescription
</th>
<th>
Edit
</th>
<th>
Delete
</th>

</tr>
<c:forEach items="${cate}" var="ca">
<tr>
<td>${ca.categoryName}</td>
<td>${ca.categoryDiscription}</td>
<td><a href="editcat?catid=${ca.categoryid}">edit</a></td>
<td><a href="deletecat?catid=${ca.categoryid}">delete</a></td>

</tr>

</c:forEach>

</table>
</body>
</html>