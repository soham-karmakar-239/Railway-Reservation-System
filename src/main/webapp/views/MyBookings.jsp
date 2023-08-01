<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
    <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="ISO-8859-1">
            <title>Insert title here</title>
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
                li{
                	margin-top: 5px;
                	margin-bottom: 5px;
                }

                a {
                    text-decoration: none;
                    color: white;
                }

                #bookings-conainer {
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
                table{
                	text-align: left;
                }
            </style>
        </head>

        <body>
            <header>
                <h1>Online Railway Reservation System</h1>
            </header>
            <div id="bookings-conainer">
            	<h2>My Bookings</h2>
            	<c:if test="${fn:length(bookings) == 0}">
						<div>No Bookings Available</div>
				</c:if>
                <ol>
                    <c:forEach var="booking" items="${bookings}">
                        <li>
                        	<h4>${booking.trainNo} | ${booking.trainName}</h4>
                            <table class="table">
                                <tr>
                                    <th>PNR Number</th>
                                    <td>${booking.pnr}</td>
                                </tr>
                                <tr>
                                    <th>Source station</th>
                                    <td>${booking.fromStation}</td>
                                    <th>Departure Time</th>
                                    <td>${booking.departureTime}</td>
                                </tr>
                                <tr>
                                    <th>Destination station</th>
                                    <td>${booking.toStation}</td>
                                    <th>Arrival Time</th>
                                    <td>${booking.arrivalTime}</td>
                                </tr>
                                <tr>
                                    <th>Departure Date</th>
                                    <td>${booking.departureDate}</td>
                                    <th>Seat Class</th>
                                    <td>${booking.seatClass}</td>
                                </tr>
                                <tr>
                                    <th>Payment Id</th>
                                    <td>${booking.paymentId}</td>
                                    <th>Card Number</th>
                                    <td>${booking.cardNo}</td>
                                </tr>
                                <tr>
                                    <td>Ticket Amount</td>
                                    <td>Rs ${booking.price}</td>
                                </tr>
                                <tr>
                                    <th>Booking Date</th>
                                    <td>${booking.bookingDate}</td>
                                    <th>Booking Time</th>
                                    <td>${booking.bookingTime}</td>
                                </tr>
                            </table>
                            <form action="cancel" method="get">
                                <input type="hidden" name="pnr" value="${booking.pnr}" />
                                <input type="submit" class="btn btn-dark" value="Cancel Ticket">
                            </form>
                        </li>
                    </c:forEach>
                </ol>
                <div style="margin:10px">
	                <button type="button" class="btn btn-dark"><a href="/user/">Home</a>
	            </div>
            </div>
        </body>

        </html>