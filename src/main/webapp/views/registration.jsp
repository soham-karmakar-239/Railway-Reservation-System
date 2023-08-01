<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ page isELIgnored="false" %>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
			<!DOCTYPE html>
			<html>

			<head>
				<meta charset="ISO-8859-1">
				<title>LOGIN</title>
				<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
				<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
				<link rel="stylesheet" href="css/commonStyle.css" />
			</head>

			<body>
				<header>
					<h1>Online Railway Reservation System</h1>
				</header>

				<div id="authentication-container">
					<h3>User Registration</h3>


					<!-- <div class="registration-form"> -->

					<form action="/register" method="post">
						<div class="mb-3 mt-3">
							<label for="firstName" class="form-label">FirstName </label>
							<input type="text" class="form-control" name="firstName" required>
						</div>
						<div>
							<label for="lastName" class="form-label">Last Name </label>
							<input type="text" class="form-control" name="lastName" required>
						</div>
						<label for="gender" class="form-check-label">Gender </label>
						<div style="width: 20px">
							<span class="form-check">
								<input type="radio" class="form-check-input" name="gender" id="male" value="Male">
								<label for="male" class="form-check-label">Male</label>
							</span>
							<span class="form-check">
								<input type="radio" class="form-check-input" name="gender" id="female" value="Female">
								<label for="female" class="form-check-label">Female</label>
							</span>
						</div>
						<div class="mb-3 mt-3">
							<label class="form-label">Date of birth</label>
							<input type="date" class="form-control" id="dob" name="dob" required>
						</div>
						<div class="mb-3 mt-3">
							<label class="form-label">Email</label>
							<input type="email" class="form-control" name="email" required>
						</div>
						<div class="mb-3 mt-3">
							<label class="form-label">Contact Number</label>
							<input type="tel" class="form-control" pattern="[6-9]{1}[0-9]{9}" name="contactNo" required>
						</div>
						<div class="mb-3 mt-3">
							<label class="form-label">Username</label>
							<input type="text" class="form-control" name="username" placeholder="Enter Username" required>
						</div>
						<div class="mb-3 mt-3">
							<label class="form-label">Password</label>
							<input type="password" class="form-control" name="password" required>
						</div>
						<div class="mb-3 mt-3">
							<label class="form-label">My Pet Name:</label>
							<input type="text" class="form-control" name="securityAnswer1" required>
						</div>
						<div class="mb-3 mt-3">
							<label class="form-label">My School Name:</label>
							<input type="text" class="form-control" name="securityAnswer2" required>
						</div>
						<div class="mb-3 mt-3">
							<label class="form-label">My Favorite Book:</label>
							<input type="text" class="form-control" name="securityAnswer3" required>
						</div>
						<input type="submit" class="btn btn-dark" value="Submit" text-align="center">
					</form>
					<div style="margin:10px">
						<button type="button" class="btn btn-dark"><a href="/">Home</a></button>
					</div>
					
				</div>
				<script>
		        	const today = new Date();
		    		let month = today.getMonth()+1;
		    		month = month < 10? "0"+month:month;
		    		let day = today.getDate();
		    		day = day < 10? "0"+day: day;
					const date = today.getFullYear()+'-'+month+'-'+day;
					document.getElementById("dob").max = date;
		        </script>
			</body>

			</html>
