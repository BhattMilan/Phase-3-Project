<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sporty Shoes</title>
<link rel="stylesheet" href="css/Navigationbar.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
<style type="text/css">
	.succeed p{
		color: green;
	}
</style>
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
			<div id="succeedMsg" class="succeed" align="center">
				<p>
					Record has been added successfully!
				</p>
				<div id="backBtn" class="backBtn">
					<button type="button" class="btn btn-success" onclick="window.location='/dashboard'">Back</button>
				</div>
			</div>
		<%}
	%>
</body>
</html>