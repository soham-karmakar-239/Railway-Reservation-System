<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
    <Title>Book Train</Title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <style>
        /*--------------Common Style---------------*/
        body {
            color: black;
            text-align: center;
            background-image: url(../assets/images/train.jpg);
            background-repeat: no-repeat;
            background-size: cover;
        }
        a{
            text-decoration: none;
            color: white;
        }

        /*--------------Common Style---------------*/
        #newtrain{
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
     <c:choose>
        <c:when test="${param == '{error=}'}">
            <div class="alert alert-danger d-inline-flex p-2 bd-highlight" role="alert"><strong>Train Number Already Exist</strong></div>
        </c:when>
    </c:choose>
    <div id="newtrain">
        <h3>Add Train</h3>
    <div class="train-details-container">
        <form action="/admin/newtrain" method="post">
            <div class="mb-3 mt-3">
                <label for="train-no" class="form-label">Train No </label>
                <input type="number" class="form-control" name="trainNo" required>
            </div>
            <div class="mb-3 mt-3">
                <label for="train-name" class="form-label">Train Name </label>
                <input type="text" class="form-control" name="trainName" required>
            </div>
            <div class="mb-3 mt-3">
                <label for="traintype" class="form-label">Train Type</label>
                <select name="trainType" class="form-control">
                    <option value="0">Select</option>
                    <option value="Superfast">Superfast</option>
                    <option value="Express">Express</option>
                    <option value="Passenger">Passenger</option>
                </select>
            </div>
            <div class="mb-3 mt-3">
                <label for="noOfSeats" class="form-label">Number of Seats </label>
                <input type="number" class="form-control" name="noOfSeats" required>
            </div>
            </div>
            <div class="mb-3 mt-3">
                <label for="a1Price" class="form-label">Price of AC-1 Tier</label>
                <input type="number" class="form-control" name="a1Price" required>
            </div>
            <div class="mb-3 mt-3">
                <label for="a2Price" class="form-label">Price of AC-2 Tier</label>
                <input type="number" class="form-control" name="a2Price" required>
            </div>
            <div class="mb-3 mt-3">
                <label for="a3Price" class="form-label">Price of AC-3 Tier</label>
                <input type="number" class="form-control" name="a3Price" required>
            </div>
            <div class="mb-3 mt-3">
                <label for="s1Price" class="form-label">Price of Sleeper</label>
                <input type="number" class="form-control" name="slPrice" required>
            </div>
            <div class="mb-3 mt-3">
                <label for="genPrice" class="form-label">Price of General</label>
                <input type="number" class="form-control" name="genPrice" required>
            </div>
            <div class="mb-3 mt-3">
                <lable for="source" class="form-label">Source Staiton</lable>
                <input name="sourceStn" class="form-control" type="text" required>
            </div>
            <div class="mb-3 mt-3">
                <lable for="departureTime" class="form-label">Departure Time</lable>
                <input name="departureTimeUtil" class="form-control" type="time" required>
            </div>
            <div class="mb-3 mt-3">
                <lable for="to" class="form-label">Destination Station</lable>
                <input  class="form-control" name="destinationStn" type="text" required>
            </div>
            <div class="mb-3 mt-3">
                <lable for="arrivalTime" class="form-label">Arrival Time</lable>
                <input id="arrivalTime" class="form-control" name="arrivalTimeUtil" type="time" required>
            </div>
            <input type="submit" class="btn btn-dark" value="Add Train" text-align="center">
            <div style="margin:10px">
                <button type="button" class="btn btn-dark"><a href="/admin/">Home</a>
            </div>
        </div>
    </div> 
        </form>
</body>

</html>