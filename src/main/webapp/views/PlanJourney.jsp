<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <title>Plan Journey</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <!-- <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script> -->
        <!-- <link rel="stylesheet" href="css/commonStyle.css" /> -->
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
			button{
				margin: 10px;
			}
			#planjourney-container{
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
        </style>
    </head>

    <body>
        <header>
            <h1>Online Railway Reservation System</h1>
            <nav class="navbar navbar-default">
                <div class="container-fluid">
                  <div class="navbar-header">
                    <a class="navbar-brand" href="#">User Home</a>
                  </div>
                  <ul class="nav navbar-nav navbar-right">
                    <li><a href="/user/bookings"><span class="glyphicon glyphicon-list"></span>My Bookings </a></li>
                    <li><a href="/user/refunds"><span class="glyphicon glyphicon-list"></span>My Refunds </a></li>
                    <li><a href="/user/help"><span class="glyphicon glyphicon-user"></span>Help </a></li>
                    <li><a href="/logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
                  </ul>
                </div>
              </nav>
        </header>
        <br>
        <div id="planjourney-container">
            <h3>Plan Journey</h3>
            <form action="/user/search" method="post">
                <div class="mb-3 mt-3">
                    <label for="stnfrom" class="form-label">Source Station</label>
                    <input id="stnfrom" class="form-control" name="fromStn" type="text" placeholder="Enter from station"
                        required />
                </div>
                <div class="mb-3 mt-3">
                    <label for="stnto" class="form-label">Destination Station</label>
                    <input id="stnto" class="form-control" name="toStn" type="text" placeholder="Enter to station"
                        required />

                </div>
                <div class="mb-3 mt-3">
                    <label for="datejourney" class="form-label">Date of Journey</label>
                    <input id="datejourney" class="form-control" name="departureDate" type="date" required />
                </div>
                <div class="mb-3 mt-3">
                    <label for="traintype" class="form-label">Train Type</label>
                    <select name="trainType" class="form-control">
                        <option value="0">Select</option>
                        <option value="Superfast">Superfast</option>
                        <option value="Express">Express</option>
                        <option value="Passenger">Passenger</option>
                    </select>
                </div><br/>
                <input type="submit" class="btn btn-dark" value="Search" />
            </form>
        </div>
        <script>
        	const today = new Date();
    		today.setDate(today.getDate() + 90);
    		let month = today.getMonth()+1;
    		month = month < 10? "0"+month:month;
    		let day = today.getDate();
    		day = day < 10? "0"+day: day;
			const date = today.getFullYear()+'-'+month+'-'+day;
			document.getElementById("datejourney").min = date;
        </script>
    </body>

    </html>