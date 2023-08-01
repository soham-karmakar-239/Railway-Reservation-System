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
    <div id="reset-password-container">
        <h3>Reset Password</h3>
        <form action="/savepassword" method="post">
        
        <input type="hidden" class="form-control" name="username" value="${username}">
            <div class="mb-3 mt-3">
                <label class="form-label">New Password</label>
                <input type="password" class="form-control" name="newPassword" placeholder="Enter new password"
                    required>
            </div>
            
            <input type="submit" class="btn btn-dark" value="Submit" text-align="center">
        </form>
        <div>
            <button type="button" class="btn btn-dark"><a href="/">Home</a></button>
        </div>
    </div>
</body>

</html>