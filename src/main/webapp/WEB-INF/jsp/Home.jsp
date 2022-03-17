<%@page import="org.springframework.beans.factory.annotation.Autowired"%>
<%@page import="com.sportyshoes.product.ProductService"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.sportyshoes.product.Product"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sporty Shoes</title>
<link rel="stylesheet" href="css/Navigationbar.css">
</head>
<body>
	<div class="topnav">
		<header>
			  <nav class="navbar">
			  	<ul>
			  		<li><a href="/dashboard"> Sporty Shoes </a></li>
			  		<li><a href="/products"> Product </a></li>
			  		<li><a href="/category"> Category </a></li>
			  		<li><a href="/subCategory"> Sub category </a></li>
			  		<li><a href="/logout"> Logout </a></li>
			  	</ul>
			  </nav>
		  </header>
	</div>
	<div id="proTable" class="cls-pro-table">
		<table border="1">
			<tbody>
				<tr>
					<th>Product ID</th>
					<th>Product Name</th>	
					<th>Image</th>	
				</tr>
				<tr>
					<c:forEach items="${productList}" var="prodcutModel">
						<td> <c:out value="${prodcutModel.productID}"></c:out></td>
						<td> <c:out value="${prodcutModel.productName}"></c:out></td>
						<td> <img id="imgView" alt="Doesn't have the image" src="/getImg?id=${prodcutModel.productID}" width="150" height="100" /> </td>
					</c:forEach>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>