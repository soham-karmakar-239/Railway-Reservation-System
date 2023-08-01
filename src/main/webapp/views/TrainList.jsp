<%@ page isELIgnored="false" %>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
		<html lang="en">

		<head>
			<meta charset="UTF-8">
			<meta http-equiv="X-UA-Compatible" content="IE=edge">
			<meta name="viewport" content="width=device-width, initial-scale=1.0">
			<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
			 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
			 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
			<title>Train List</title>
			<style>
				/*--------------Common Style---------------*/
				body{
				    color: black;
				    text-align: center;
				    background-image:url(../assets/images/train.jpg);
					background-repeat: no-repeat;
				    background-size: cover; 
				}
				/*--------------Common Style---------------*/
				
				/*--------------TrainList Style---------------*/
				#trains
				{
					width: 50%;
    				height: auto;
    				margin-left: 25%;
    				text-align: center;
    				border: 1px solid white;
    				border-radius: 10px;
    				background: rgb(255, 255, 255);
    				opacity: .75;
    				padding: 2%;
				}
			</style>
		</head>

		<body>
			<header>
					<h1>  Online Railway Reservation System</h1>
			</header>
			<div class="container" id="trains">
				<h3>Train List</h3>
				<c:if test="${fn:length(trains) == 0}">
					<div>No Trains Available</div>
				</c:if>
				<ol>
					<c:forEach var="train" items="${trains}">
						<li>
							<h3>${train.trainName}</h3>
							<table class="table">
								<tr>
									<th>Train No</th>
									<td>${train.trainNo}</td>
								</tr>
								<tr>
									<th>Train Type</th>
									<td>${train.trainType}</td>
								</tr>
								<tr>
									<th>Source Sattion</th>
									<td>${train.sourceStn}</td>
								</tr>
								<tr>
									<th>Destination Station</th>
									<td>${train.destinationStn}</td>
								</tr>
								<tr>
									<th>Number of Seats</th>
									<td>${train.noOfSeats}</td>
								</tr>
								<tr>
									<th>Price</th>
									<td>
										<table class="table">
											<tr>
												<th>Type of Compartment </th>
												<th>Amount (in Rs)</th>
											</tr>
											<tr>
												<td>A1</td>
												<td>${train.a1Price}</td>
											</tr>
											<tr>
												<td>A2</td>
												<td>${train.a2Price}</td>
											</tr>
											<tr>
												<td>A3</td>
												<td>${train.a3Price}</td>
											</tr>
											<tr>
												<td>Sleeper</td>
												<td>${train.slPrice}</td>
											</tr>
											<tr>
												<td>General</td>
												<td>${train.genPrice}</td>
											</tr>
										</table>
									</td>
								</tr>
								<tr>
									<th>Departure Date</th>
									<td>${departureDate}</td>
								</tr>
								<tr>
									<th>Departure Time</th>
									<td>${train.departureTime}</td>
								</tr>
								<tr>
									<th>Arrival Time Time</th>
									<td>${train.arrivalTime}</td>
								</tr>
							</table>
							<form action="/user/booktrain" method="get">
								<input type="hidden" value=${train.trainNo} name="trainNo"/>
								<input type="hidden" value=${departureDate} name="departureDate"/>
								<input type="submit" class="btn btn-dark" value="Book" />
							</form>
						</li>

					</c:forEach>
				</ol>
			</div>
			<div>
				<button type="button" class="btn btn-dark"><a href="/user/">Home</a></button>
			</div>
		</body>

		</html>