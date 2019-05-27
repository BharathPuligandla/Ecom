<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
   <%@ page isELIgnored="false" %>
   <%@ include file="Userhadder.jsp" %>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:forEach items="${cartlist}" var="cart">
CARTID:- ${cart.cartId}
</br>
PRODUCTID:- ${cart.productId}
</br>
PRODUCT NAME:- ${cart.productName}
</br>
PRODUCT PRICE:- ${cart.productPrice}
</br>
PRODUCT SUPPLIER:- ${cart.productSupplier}
</br>
QUANTITY:- ${cart.quantity}
</br>
TOTAL PRICE:- ${cart.totalPrice}
</br>

</c:forEach>
</body>
</html>