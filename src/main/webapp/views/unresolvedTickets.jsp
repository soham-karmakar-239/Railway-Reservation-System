<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
    <html>

    <head>
        <title>Unresolved Tickets</title>
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
                width: 60%;
                height: auto;
                margin-left: 20%;
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
            <h3>Unresolved Tickets</h3>
            <table class="table">
                <tr>
                    <th>Ticket Id</th>
                    <th>Issue</th>
                    <th>Date of Generation</th>
                    <th>Action</th>
                </tr>
                <c:forEach var="ticket" items="${tickets}">
                    <tr>
                        <td>${ticket.ticketId}</td>
                        <td>${ticket.issue}</td>
                        <td>${ticket.dateCreated}</td>
                        <td>
                            <form action="/admin/resolve" method="get">
                                <input type="hidden" name="ticketId" value="${ticket.ticketId}" />
                                <input type="hidden" name="issue" value="${ticket.issue}" />
                                <input type="hidden" name="description" value="${ticket.description}" />
                                <input type="submit" class="btn btn-dark" value="Resolve" />
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <c:if test="${fn:length(tickets) == 0}">
					<div>All Tickets Resolved</div>
			</c:if>
        </div>
        <div style="margin:10px">
            <button class="btn btn-dark"><a href="/admin/">Home</a></button>
        </div>
    </body>

    </html>