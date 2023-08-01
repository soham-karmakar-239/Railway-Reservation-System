<html>
	<head>
		<title>Schedule Train</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
				<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
				<style>
					body{
					    color: black;
					    text-align: center;
					    background-image:url(../assets/images/train.jpg);
						background-repeat: no-repeat;
					    background-size: cover; 
					}
					a{
						text-decoration: none;
						color: white;
					}
					#sctrain{
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
				</style>
	</head>
	<body>
		<header>
	        <h1>Online Railway Reservation System</h1>
	    </header>
	    <div class="container mt-3" id="sctrain">
			<h2>Schedule Trains</h2>
			<h4>${train.trainNo} | ${train.trainName}</h4>
			<form action="/admin/scheduletrain" method="post">
				<input id="departureTime" name="trainNo" type="hidden"  value="${train.trainNo}"/>
				<div class="mb-3 mt-3">
					<label for="departureTime" class="form-label">Departure Time </label>
					<input type="time" class="form-control" name="departureTimeUtil" required>
				</div>
				<div>
					<lable for="arrivalTime" class="form-label">Arrival Time</lable>
					<input class="form-control" name="arrivalTimeUtil" type="time" required>
				</div>
				<input type="submit" value="Re-Schedule Train" />
			</form>
		</div>
		<div style="margin:10px">
			<button type="button" class="btn btn-dark"><a href="/admin/">Home</a>
		</div>
	</body>
<html>