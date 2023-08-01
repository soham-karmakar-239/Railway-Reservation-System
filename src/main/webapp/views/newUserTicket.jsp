<html>

<head>
    <title>New Ticket</title>
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

        .new-ticket-container {
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
        <h1>Online Railway Reservation System</h1>
    </header>
    <h3>Raise New Ticket</h3>
    <div class="new-ticket-container">
        <form action="/user/createticket" method="post">
            <div class="mb-3 mt-3">
                <label for="issue" class="form-label">Issue</label>
                <select id="issue" class="form-control" name="issue" required>
                    <option value="">Select</option>
                    <option value="BookTicket">Book Ticket</option>
                    <option value="Cancellations">Cancellations</option>
                    <option value="Refund">Refund</option>
                </select>
            </div>
            <div class="mb-3 mt-3">
                <label for="description" class="form-label">Description</label>
                <textarea id="description" class="form-control" name="description" required></textarea>
            </div>
            <input type="submit" class="btn btn-dark" value="Raise" />
        </form>

    </div>
    <div style="margin:10px">
        <button class="btn btn-dark"><a href="/user/">Home</a></button>
    </div>
</body>

</html>