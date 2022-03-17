<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Category</title>
	<style type="text/css">
		.submit{
			background: green;
			color: white;
			border-radius: 30px;
			width: 80px;
		}
	</style>
<link rel="stylesheet" href="css/Navigationbar.css">
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
				  		<li><a href="/dashboard"> Sporty Shoes </a></li>
				  		<li><a href="/products"> Product </a></li>
				  		<li><a href="/category"> Category </a></li>
				  		<li><a href="/subCategory"> Sub category </a></li>
				  		<li><a href="/logout"> Logout </a></li>
				  	</ul>
				  </nav>
			  </header>
			</div>
			<div id="addCatForm" class="addCatForm" align="center">
				<form action="saveCategory" method="post">
					<input type="text" id="catName" class="catName" name="categoryName" placeholder="Enter Category Name">
					<input type="submit" id="submit" class="submit" value="Save">
				</form>
			</div>
		<%}
	%>
</body>
</html>