<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
		.message{
			color: blue;
		}
		body{
			font-family: Arial, sans-serif;
            background-color: gray;
            color: white;
            text-align: center;
            margin: 0;
            padding: 0;
		}
		@charset "ISO-8859-1";

body {
            font-family: Arial, sans-serif;
            background-color: gray;
            color: white;
            text-align: center;
            margin: 0;
            padding: 0;
        }

        .container {
            max-width: 400px;
            margin: 0 auto;
            padding: 20px;
            background-color: #be84e7;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
        }

        h2 {
            color: #45b6fe;
        }

        .form-group {
            margin-bottom: 20px;
        }

        label {
            display: block;
            font-weight: bold;
            margin-bottom: 5px;
            text-align: left;
        }

        input[type="text"],
        input[type="password"],
        input[type="email"] {
            width: 100%;
            padding: 10px;
            border: none;
            border-radius: 5px;
            background-color: #fff;
            color: #0e2433;
        }

        input[type="submit"] {
            background-color: #45b6fe;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        .message {
            background-color: #45b6fe;
            color: white;
            padding: 10px;
            margin-top: 20px;
            border-radius: 5px;
        }
        .login-btn {
            background-color: #f8a000; /* Customize the color */
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            margin-top: 10px; /* Adjust the margin as needed */
        }
        .register-btn {
            background-color: #f8a000; /* Customize the color */
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            margin-top: 10px; /* Adjust the margin as needed */
        }
	</style>
<title>Insert title here</title>

</head>
<body>
	
	<br><br><div class="container mt-5">
		
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card">
                <div class="card-header">
                    <h2 class="mb-0" style="color: darkgreen;">Registration</h2>
                </div>
                <div class="card-body"><br>
                    <form action="/register"  method="post">
                        <div class="form-group">
                            <label for="fname">First Name:</label>
                            <input type="text" class="form-control" id="fname" name="fname" placeholder="enter your first name" required>
                        </div>

                        <div class="form-group">
                            <label for="lname">Last Name:</label>
                            <input type="text" class="form-control" id="lname" name="lname" placeholder="enter your last name" required>
                        </div>

                        <div class="form-group">
                            <label for="email">Email:</label>
                            <input type="email" class="form-control" id="email" name="email" placeholder="enter your email" required>
                        </div>

                        <div class="form-group">
                            <label for="username">Username:</label>
                            <input type="text" class="form-control" id="username" name="username" placeholder="enter your username" required>
                        </div>

                        <div class="form-group">
                            <label for="password">Password:</label>
                            <input type="password" class="form-control" id="password" name="password" placeholder="enter your password" required>
                        </div>

                        <button type="submit" class="register-btn" >Register</button>
                         <button type="button" class="login-btn" onclick="location.href='/login'">Login</button>
                     
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap JS and Popper.js -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	
</body>
</html>