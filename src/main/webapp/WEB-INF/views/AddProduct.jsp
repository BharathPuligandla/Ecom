<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="Adminhedder.jsp" %>
     <%@ page isELIgnored="false" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="sform" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="s" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<sform:form action="addPro"  method="post" modelAttribute="pro" enctype="multipart/form-data">

productName<sform:input  path="productName"  />
</br>
productDiscription <sform:input  path="productDiscription" />
</br>
productPrice<sform:input  path="productPrice" />
</br>
productCategory <sform:select path="productCategory">
<s:forEach items="${cat}" var="cat">
<sform:option value="${cat.categoryName}"> </sform:option>
</s:forEach>
</sform:select>
</br>
productSupplier <sform:select  path="productSupplier" >
<s:forEach items="${sup}" var="sup">
<sform:option value="${sup.supplierName}"> </sform:option>
</s:forEach>
</sform:select>

 <sform:input path="productId" type="hidden" />
 </br>
 ProductImage<sform:input type="file" path="productImage"/>
<input type="submit"  value="${ButtonName}" />
</sform:form>
</body>
</html>