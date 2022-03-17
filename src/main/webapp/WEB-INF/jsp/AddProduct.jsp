<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
	.submit{
			background: green;
			color: white;
			border-radius: 30px;
			width: 100px;
			padding: 4px;
			margin: 30px;
		}
	
	h3{
		text-align: center;
		color: green;
	}
</style>
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
			<form action="saveProduct" method="post" enctype="multipart/form-data">
				<h3>Add Product</h3>
				<div class="container">
					<div class="row">
						<div class="col">
							<input type="text" id="proName" class="proName" name="productName" placeholder="Enter Product Name">
						</div>
						<div class="col">
							<div class="cls-dropdown">
								<select name="selectSubCat" id="selectSubCat" class="cls-selectSubCat">
									<option> Select SubCategory </option>
									<c:forEach items="${subCatList}" var="subCatList"> <option value="<c:out value="${subCatList.subCatID}"> </c:out>"> <c:out value="${subCatList.subCategoryName}"> </c:out> </option> </c:forEach>
								</select>
							</div>
						</div>
						<div class="col">
							<input id="imgUpload" name="imgUpload" multiple="multiple" type="file" /> 
						</div>
					</div>
				</div>
				<div class="saveBtn" id="saveBtn" align="center">
					<input type="submit" id="submit" class="submit" value="Save">
				</div>
		</form>
		<%}
	%>
</body>
</html>