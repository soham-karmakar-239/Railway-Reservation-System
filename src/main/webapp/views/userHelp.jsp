<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>

<head>
    <title>Help</title>
    <meta charset="ISO-8859-1">
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

        .all-tickets-container {
            width: 70%;
            height: auto;
            margin-left: 15%;
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
    </style>
</head>

<body>
    <header>
        <h1>Online Railway Reservation System</h1>
    </header>
    <div class="all-tickets-container">
        <h3>All Tickets</h3>
        <table class="table">
            <tr>
                <th>Ticket Id</th>
                <th>Issue</th>
                <th>Date of Generation</th>
                <th>Description</th>
                <th>Resolution</th>
            </tr>
            <c:forEach var="ticket" items="${tickets}">
                <tr>
                    <td>${ticket.ticketId}</td>
                    <td>${ticket.issue}</td>
                    <td>${ticket.dateCreated}</td>
                    <td>${ticket.description}</td>
                    <td>${ticket.resolution}</td>
                </tr>
            </c:forEach>
        </table>
        <c:if test="${fn:length(tickets) == 0}">
				<div>No Tickets Yet</div>
		</c:if>
    </div>
    <div style="margin:10px">
        <button class="btn btn-dark"><a href="/user/newticket">Raise New Ticket</a></button>
    </div>
    <div style="margin:10px">
        <button class="btn btn-dark"><a href="/user/">Home</a></button>
    </div>
</body>

</html>