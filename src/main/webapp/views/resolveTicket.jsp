<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <html>

    <head>
        <title>Resolve Ticket</title>
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

            .ticket-container {
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

            textarea {
                width: 100%;
                height: 100px;
            }

            .content {
                width: 50%;
            }
        </style>
    </head>

    <body>
        <header>
            <h1>Online Railway Reservation System</h1>
        </header>
        <div class="ticket-container">
            <h3>Resolve Ticket</h3>
            <form action="/admin/resolve" method="post">
                <table class="table">
                    <tr>
                        <th>Ticket Id</th>
                        <td>${ticket.ticketId}</td>
                        <th>Issue</th>
                        <td>${ticket.issue}</td>
                    </tr>
                </table>
                <table class="table">
                    <tr>
                        <td class="content">
                            <div><strong>Description</strong></div>
                            <p>${ticket.description}</p>
                        </td>

                        <td class="content">
                            <div><strong>Resolution</strong></div>
                            <input type="hidden" name="ticketId" value="${ticket.ticketId}" />
                            <textarea name="resolution"></textarea>
                        </td>
                    </tr>
                </table>
                <input type="submit" class="btn btn-dark" value="Resolve" />
            </form>
        </div>
        <div style="margin:10px">
            <button class="btn btn-dark"><a href="/admin/">Home</a></button>
        </div>
    </body>

    </html>