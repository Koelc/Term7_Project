<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix ="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" >
<title>Insert title here</title>
</head>
<body>

<nav id="navbar-red" class="navbar navbar-inverse navbar-static-top" role="navigation">
<div class="container-fluid">
	<ul class="nav navbar-nav">
	 <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbarArea">
	 
	  <span class="icon-bar"></span>
	  <span class="icon-bar"></span>
	  <span class="icon-bar"></span>
	 </button>
	 	
	</ul>
</div>

<div class="collapse navbar-collapse" id="navbarArea">

<ul class="nav navbar-nav">
 <li><a href="#">Home</a></li>
 <li><a href="#">Contact Us</a></li>
 <li><a href="<spring:url value="/gotologin"></spring:url>">Admin</a></li>
 <li><a href="#"><i class="fa fa-user fa" aria-hidden="true"></i></a></li>
 <li><a href="<spring:url value="/register"></spring:url>">Register</a></li>
  <li><a href="<spring:url value="/prodCustList"></spring:url>">Products</a></li>
</ul>

</div>

</nav>

</body>
</html>







