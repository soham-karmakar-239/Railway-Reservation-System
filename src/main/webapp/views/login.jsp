<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
<title>User Authentication</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="css/commonStyle.css" />
</head>
<body>
	<header>
		<h1>Online Railway Reservation System</h1>
	</header>
	<br>
	<c:choose>
		<c:when test="${param == '{registered=}'}">
			<div class="alert alert-success d-inline-flex p-2 bd-highlight" role="alert" ><strong>Successfully Registered</strong></div>
		</c:when>
		<c:when test="${param == '{passwordreset=}'}">
			<div class="alert alert-success d-inline-flex p-2 bd-highlight" role="alert" ><strong>Password Set Successfully</strong></div>
		</c:when>
		<c:when test="${param == '{error=}'}">
		   <div class="alert alert-danger d-inline-flex p-2 bd-highlight" role="alert" ><strong>Authentication Unsuccessful</strong></div>
		</c:when>
	</c:choose>
	
	<div id="authentication-container">
		<h3>User Authentication</h3>
		<form action="/login" method="post">
		<div class="mb-3 mt-3">
			<label for="username" class="form-label">User ID</label>
			<input id="username" class="form-control" name="username" type="text" placeholder="Enter User Id" required />
		</div>
		<div class="mb-3">
			<label for="password" class="form-label">Password</label>
			<input id="password" class="form-control" name="password" type="password" placeholder="Enter Password" required />
		</div>
		<input type="submit" class="btn btn-dark" value="Sign In" />
	  </form>
	  <div class="forgetpassword">
	  	<a href="/forgotpassword" >Forgot Password?</a>
	  </div>
	<br>
	<div>
		<button type="button" class="btn btn-dark"><a href="/">Home</a></button>
	</div>
</div>
</body>

</html>
 