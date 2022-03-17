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
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<script src="https://code.jquery.com/jquery.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
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
				  		<li><a href="/dashboard"> Sporty Shoes </a></li>
				  		<li><a href="/products"> Product </a></li>
				  		<li><a href="/category"> Category </a></li>
				  		<li><a href="/subCategory"> Sub category </a></li>
				  		<li><a href="/logout"> Logout </a></li>
				  	</ul>
				  </nav>
			  </header>
			</div>
			<div id="subCatTable" class="subCatTable">
				<table class="table table-dark">
					<thead>
						<tr>
							<th scope="col">SubCategory ID</th>
							<th scope="col">Category ID</th>
							<th scope="col">SubCategory Name</th>
						</tr>
					</thead>
					<tbody>
							<c:forEach items="${subCategoryList}" var="subCatModel">
								<tr>
									<td> <c:out value="${subCatModel.subCatID}"></c:out></td>
									<td> <c:out value="${subCatModel.category.categoryID}"></c:out></td>
									<td> <c:out value="${subCatModel.subCategoryName}"></c:out></td>
								</tr>
							</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="container">
				<div class="row">
					<div class="col">
						<div id="addSubCatBtn" class="cls-addSubCatBtn">
							<button type="button" class="btn btn-success" onclick="window.location='/addSubCategory'">Add SubCategory</button>
						</div>
					</div>
					<div class="col">
						<div id="deleteSubCatBtn" class="cls-deleteSubCatBtn">
							<button type="button" class="btn btn-success" onclick="window.location='/deleteSubCategory'">Delete SubCategory</button>
						</div>
					</div>
				</div>
			</div>	
		<%}
	%>
</body>
</html>