<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="Adminhedder.jsp" %>
    <%@ page isELIgnored="false" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="sform" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<sform:form action="addCat"  method="post" modelAttribute="cat">
CategoryName <sform:input  path="categoryName"  />
</br>
CategoryDiscription <sform:input  path="categoryDiscription" />
</br>
<sform:input path="categoryid" type="hidden" />
<input type="submit"  value="${ButtonName}" />

</sform:form>
</body>
</html>