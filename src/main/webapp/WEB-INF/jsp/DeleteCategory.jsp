<%@page import="java.util.List"%>
<%@page import="com.sportyshoes.category.CategoryController"%>
<%@page import="com.sportyshoes.category.CategoryService"%>
<%@page import="com.sportyshoes.category.Category"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sporty Shoes</title>
<link rel="stylesheet" href="css/Navigationbar.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
<link rel="stylesheet" href="https://unpkg.com/bootstrap-table@1.19.1/dist/bootstrap-table.min.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
</head>
<body>
	<%
		response.setHeader("Cache-Control","no-cache");
		response.setHeader("Cache-Control","no-store");
		response.setHeader("Pragma","no-cache");
		response.setDateHeader ("Expires", 0);
		if(session==null){
			response.sendRedirect("/");
		}
		else{%>
			<div class="topnav">
				<header>
				  <nav class="navbar">
				  	<ul>
				  		<li><a href="dashboard"> Sporty Shoes </a></li>
				  		<li><a href="/products"> Product </a></li>
				  		<li><a href="/category"> Category </a></li>
				  		<li><a href="/subCategory"> Sub category </a></li>
				  		<li><a href="/logout"> Logout </a></li>
				  	</ul>
				  </nav>
			  </header>
			</div>
			<div id="catTable" class="catTable">
				<table class="table">
				<thead class="thead-dark">
					<tr>
						<th scope="col">Category ID</th>
						<th scope="col">Category Name</th>	
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${catList}" var="catModel">
						<tr>
							<td> <c:out value="${catModel.categoryID}"></c:out></td>
							<td> <c:out value="${catModel.categoryName}"></c:out></td>
							<td><button type="button" class="btn btn-success" onclick="window.location='/catDeleteProcess?id=${catModel.categoryID}'">Delete</button></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>		
		<%}
	%>
</body>
</html>