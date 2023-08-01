<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
	<hml>

		<head>
			<meta charset="UTF-8">
			<meta http-equiv="X-UA-Compatible" content="IE=edge">
			<meta name="viewport" content="width=device-width, initial-scale=1.0">
			<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
			<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
			<title>Refund History</title>
			<style>
				/*--------------Common Style---------------*/
				body {
					color: black;
					text-align: center;
					background-image: url(../assets/images/train.jpg);
					background-repeat: no-repeat;
					background-size: cover;
				}

				/*--------------Common Style---------------*/

				/*--------------TrainList Style---------------*/
				#refund-container {
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

				table {
					text-align: left;
				}

				a {
					text-decoration: none;
					color: white;
				}
			</style>
		</head>

		<body>
			<header>
				<h1> Online Railway Reservation System</h1>
			</header>
			<div id="refund-container">
				<c:if test="${fn:length(refunds) == 0}">
						<div>No Refunds Yet</div>
				</c:if>
				<ol>
					<c:forEach var="refund" items="${refunds}">
						<li>
							<table class="table">
								<tr>
									<td>Refund Id</td>
									<td>${refund.refundId}</td>
								</tr>
								<tr>
									<td>Refund Amount</td>
									<td>${refund.refundAmount}</td>
								</tr>
								<tr>
									<td>Card Number</td>
									<td>${refund.cardNo}</td>
								</tr>
								<tr>
									<td>Card Holder's Name</td>
									<td>${refund.cardHolderName}</td>
								</tr>
								<tr>
									<td>Refund Date</td>
									<td>${refund.refundDate}</td>
								</tr>
							</table>
						</li>
					</c:forEach>
				</ol>
			</div>
			<div>
				<button type="button" class="btn btn-dark"><a href="/user/">Home</a></button>
			</div>
		</body>
	</hml>