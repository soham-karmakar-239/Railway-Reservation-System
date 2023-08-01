<!DOCTYPE html>
<html>

<head>
	<title>Book Train</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<style>
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

		table {
			text-align: left;
		}

		select {
			width: 100%;
			outline: none;
			border: none;
		}

		.train-details-container {
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
	<div class="train-details-container">
		<h2>Train Details</h2>
		<h4>${trainDetails.trainNo} | ${trainDetails.trainName}</h4>
		<form action="/user/payment" method="get">
			<table class="table">
				<tr>
					<th>Departure Date</th>
					<td>${departureDate}</td>
				</tr>
				<tr>
					<th>Source Staiton</th>
					<td>${trainDetails.sourceStn}</td>
				</tr>
				<tr>
					<th>Destination Station</th>
					<td>${trainDetails.destinationStn}</td>
				</tr>
				<tr>
					<th>
						<label class="form-label">Seat Type</label>
					</th>
					<td>
						<Select name="seatClass" required>
							<option value="">Select</option>
							<option value="1A">AC 1-Tier</option>
							<option value="2A">AC 2-Tier</option>
							<option value="3A">AC 3-Tier</option>
							<option value="SL">Sleeper</option>
							<option value="Gen">General</option>
						</Select>
					</td>
				</tr>
			</table>

			<input type="hidden" value=${trainDetails.trainNo} name="trainNo" />
			<input type="hidden" value=${departureDate} name="departureDate" />


			<input type="submit" class="btn btn-dark" value="Book Train" />
		</form>


		<div style="margin:10px">
			<button type="button" class="btn btn-dark"><a href="/user/">Home</a>
		</div>
	</div>
</body>

</html>