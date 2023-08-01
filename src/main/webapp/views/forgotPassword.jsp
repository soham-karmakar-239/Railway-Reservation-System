<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="css/commonStyle.css" />
</head>

<body>
    <header>
        <h1>Online Railway Reservation System</h1>
    </header>
    <c:choose>
        <c:when test="${param == '{error=}'}">
            <div class="alert alert-danger d-inline-flex p-2 bd-highlight" role="alert"><strong>Security Question
                    Mismatch</strong></div>
        </c:when>
    </c:choose>
    <div id="securiy-question-container">
        <h3>Kindly answer the Following</h3>
        <form action="/resetpassword" method="post">
            <div class="mb-3 mt-3">
                <label class="form-label">Username</label>
                <input type="text" class="form-control" name="username" required>
            </div>
            <div class="mb-3 mt-3">
                <label class="form-label">My Pet Name:</label>
                <input type="text" class="form-control" name="securityAnswer1" required>
            </div>
            <div class="mb-3 mt-3">
                <label class="form-label">My School Name:</label>
                <input type="text" class="form-control" name="securityAnswer2" required>
            </div>
            <div class="mb-3 mt-3">
                <label class="form-label">My Favorite Book:</label>
                <input type="text" class="form-control" name="securityAnswer3" required>
            </div>
            <input type="submit" class="btn btn-dark" value="Submit" text-align="center">
        </form>
        <div>
            <button type="button" class="btn btn-dark"><a href="/">Home</a></button>
        </div>
    </div>

</body>

</html>