<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Home</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body{
    color: black;
    text-align: center;
    background-image:url(../assets/images/train.jpg);
	background-repeat: no-repeat;
    background-size: cover; 
}
input[type=submit]{
				margin: 10px;
			}
#searchTrain-container{
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
            <br>
            <nav class="navbar navbar-default">
                <div class="container-fluid">
                  <div class="navbar-header">
                    <a class="navbar-brand" href="#"><span class="glyphicon glyphicon-home"></span> Admin Home</a>
                  </div>
                  <ul class="nav navbar-nav navbar-right">
                    <li></span><a href="/admin/newtrain"><span class="glyphicon glyphicon-plus-sign"></span>Add New Train</a></li>
                
                <li><a href="/admin/trains"><span class="glyphicon glyphicon-ok-sign"></span> All Trains</a></li>
                
                <li><a href="/admin/tickets"><span class="glyphicon glyphicon-ok-sign"></span> View Tickets</a></li>
                
                <li><a href="/logout"><span class="glyphicon glyphicon-log-out"></span>Logout</a></li>
                  </ul>
                </div>
              </nav>
    </header>
    <div id="searchTrain-container">
    	<h3>Search Train</h3>
	    <form action="/admin/searchtrain" method="post">
	    	<div class="mb-3 mt-3">
		    	<lable for"trainNo" class="form-label">Train Number</lable>
		    	<input id="trainNo"  class="form-control" name="trainNo" type="number" required/>
		    <div>
	    	<input type="submit" class="btn btn-dark" value="Search"/>
	    </form>
	</div>
    <!-- <footer>
        <p>Get connected with us on social media<br>
            <a href="#" class="fa fa-facebook"></a>
            <a href="#" class="fa fa-twitter"></a>
            <a href="#" class="fa fa-github"></a>
        </p>


    </footer> -->


</body>
</html>