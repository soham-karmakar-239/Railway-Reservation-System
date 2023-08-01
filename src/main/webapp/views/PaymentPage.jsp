<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Payment</title>
    <link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <style>
        /*--------------Common Style---------------*/
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

        /*--------------Common Style---------------*/
        .container-fluid {
            font: normal 18px sans-serif;
        }

        .creditCardForm {
            max-width: 700px;
            background-color: #fff;
            margin: 100px auto;
            overflow: hidden;
            padding: 25px;
            color: #4c4e56;
        }

        .creditCardForm label {
            width: 100%;
            margin-bottom: 10px;
        }

        .creditCardForm .heading h2 {
            text-align: center;
            font-family: 'Open Sans', sans-serif;
            color: #4c4e56;
        }

        .creditCardForm .payment {
            float: left;
            font-size: 18px;
            padding: 10px 25px;
            margin-top: 20px;
            position: relative;
        }

        .creditCardForm .payment .form-group {
            float: left;
            margin-bottom: 15px;
        }

        .creditCardForm .payment .form-control {
            line-height: 40px;
            height: auto;
            padding: 0 16px;
        }

        .creditCardForm .owner {
            width: 63%;
            margin-right: 10px;
        }

        .creditCardForm .CVV {
            width: 35%;
        }

        .creditCardForm #card-number-field {
            width: 100%;
        }

        .creditCardForm #expiration-date {
            width: 49%;
        }

        .creditCardForm #credit_cards {
            width: 50%;
            margin-top: 25px;
            text-align: right;
        }

        .creditCardForm #pay-now {
            width: 100%;
            margin-top: 25px;
        }

        .creditCardForm .payment .btn {
            width: 100%;
            margin-top: 3px;
            font-size: 24px;
            background-color: #2ec4a5;
            color: white;
        }

        .creditCardForm .payment select {
            padding: 10px;
            margin-right: 15px;
        }

        .transparent {
            opacity: 0.2;
        }

        @media(max-width: 650px) {

            .creditCardForm .owner,
            .creditCardForm .CVV,
            .creditCardForm #expiration-date,
            .creditCardForm #credit_cards {
                width: 100%;
            }

            .creditCardForm #credit_cards {
                text-align: left;
            }
        }

        @media (max-width: 850px) {

            header h3 {
                float: none;
                text-align: center;
            }


        }
    </style>
</head>

<body>
    <header>
            <h1>Online Railway Reservation System</h1>
    </header>
    <div class="container-fluid">

        <div class="creditCardForm">
            <div class="heading">
                <h2>Confirm Purchase</h2>
            </div>
            <div class="payment">
                <form action="/user/confirmbooking" method="post">
                    <div class="form-group" id="card-number-field">
                        <label for="cardNumber">Card Number</label>
                        <input type="text" class="form-control" id="cardNo" pattern="[1-9]{1}[0-9]{15}"
                            title="Card Number must be a 16-digit number" name="cardNo" required>
                    </div>
                    <div class="form-group owner">
                        <label for="owner">Card Holder's Name</label>
                        <input type="text" class="form-control" id="cardHolderName"
                            title="Card Holder's Name should not contain any Numerics or Special Characters"
                            name="cardHolderName" required>
                    </div>
                    <div class="form-group CVV">
                        <label for="cvv">CVV</label>
                        <input type="tel" class="form-control" id="cvv" pattern="[1-9]{1}[0-9]{2}"
                            title="CVV must be a 3-digit number" name="cvv" required>
                    </div>
                    <div class="form-group amount">
                        <label for="amount">Amount (in Rs)</label>
                        <input type="text" class="form-control" id="price" name="price" value=${price}
                            readonly="readonly">
                    </div>
                    <div class="form-group" name="expiryMonth">
                        <label>Expiration Date</label>
                        <select id="expiration-date" name="expiryYear" onchange="getMonths(this.value)"
                            required></select>
                        <select id="expiration-month" name="month" required>

                        </select>


                    </div>
                    <div class="form-group" id="credit_cards">
                        <img src="../assets/images/visa.jpg" id="visa">
                        <img src="../assets/images/mastercard.jpg" id="mastercard">
                        <img src="../assets/images/amex.jpg" id="amex">
                    </div>
                    <input type="hidden" value=${trainNo} name="trainNo" />
                    <input type="hidden" value=${departureDate} name="departureDate" />
                    <input type="hidden" value=${seatClass} name="seatClass" />
                    <div class="form-group" id="pay-now">
                        <button type="submit" class="btn btn-default" id="confirm-purchase">Confirm</button>
                    </div>
                </form>
                <button class="btn btn-default"><a href="/user/">Cancel</a></button>
            </div>
        </div>
    </div>
    <script>
        let option = "<option value=''>Select</option>";
        const date = new Date();
        let currentYear = date.getFullYear();
        let upto = currentYear + 10;
        while (currentYear <= upto)
            option += '<option value="' + currentYear + '">' + (currentYear++) + '</option>';
        document.getElementById("expiration-date").innerHTML = option;


        function getMonths(year) {
            monthName = ["", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"];
            let month;
            let option = "<option value=''>Select</option>";
            if (year == date.getFullYear())
                month = date.getMonth() + 1;
            else
                month = 1;
            while (month <= 12)
                option += '<option value="' + month + '">' + monthName[month++] + '</option>';
            document.getElementById("expiration-month").innerHTML = option;
        }
    </script>
</body>

</html>e