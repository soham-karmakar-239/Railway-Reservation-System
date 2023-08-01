<%@ page isELIgnored="false" %>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
			<html>

			<head>
				<meta charset="UTF-8">
				<meta http-equiv="X-UA-Compatible" content="IE=edge">
				<meta name="viewport" content="width=device-width, initial-scale=1.0">
				<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
				<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
				<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
			 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
			 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script> -->
				<title>Add Train</title>
				<style>
					/*--------------Common Style---------------*/
					body {
						color: black;
						text-align: center;
						background-image: url(../assets/images/train.jpg);
						background-repeat: no-repeat;
						background-size: cover;
					}

					a {
						text-decoration: none;
						color: white;
					}
					
					.no-train {
			            width: 40%;
			            height: auto;
			            margin-left: 30%;
			            text-align: center;
			            border: 1px solid white;
			            border-radius: 10px;
			            background: rgb(255, 255, 255);
			            opacity: .75;
			            padding: 2%;
			        }
        
					/*--------------Common Style---------------*/

					/*--------------Train List Style---------------*/
					ul {
						list-style-type: none;
						padding: 5px;
						opacity: 0.75;
					}

					li {
						padding: 5px;
						margin: 5px;
						border-radius: 10px;
					}

					li:nth-child(even) {
						background: rgb(255, 255, 255);
					}

					li:nth-child(odd) {
						background: rgb(255, 255, 255);
					}

					h3 {
						margin: 0;
						padding-top: 15px;
					}


					/*--------------TrainList Style---------------*/
				</style>
			</head>

			<body>
				<header>
					<h1>Online Railway Reservation System</h1>
				</header>
				<c:choose>
					<c:when test="${param == '{added=}'}">
						<div class="alert alert-success d-inline-flex p-2 bd-highlight" role="alert"><strong>New Train
								Added Successfully</strong></div>
					</c:when>
					<c:when test="${param == '{rescheduled=}'}">
						<div class="alert alert-success d-inline-flex p-2 bd-highlight" role="alert"><strong>Train
								Rescheduled Successfully</strong></div>
					</c:when>
				</c:choose>

				<div class="container mt-3">
					<h3>All Trains</h3>
					<c:if test="${fn:length(trains) == 0}">
						<div class="no-train">No Trains Available</div>
					</c:if>
					<c:forEach var="train" items="${trains}">
						<ul class="list-group">
							<li class="list-group-item">${train.trainNo} | ${train.trainName} | ${train.sourceStn} |
								${train.destinationStn} | ${train.departureTime} | ${train.arrivalTime}

								<div style="margin:10px">
									<form action="/admin/scheduletrain" method="get">
										<input type="hidden" class="btn btn-dark" value=${train.trainNo}
											name="trainNo" />
										<input type="submit" class="btn btn-dark" value="Re-Schedule Train" />
									</form>
								</div>

							</li>
						</ul>
					</c:forEach>
				</div>
				<div style="margin:10px">
					<button type="button" class="btn btn-dark"><a href="/admin/">Home</a>
				</div>
			</body>

			</html>