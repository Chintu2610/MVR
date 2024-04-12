<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="java.util.List" %>
<%@ page import="java.sql.ResultSet" %>
<!DOCTYPE html>
<html lang="en">
 <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0">
        <meta name="description" content="Smarthr - Bootstrap Admin Template">
		<meta name="keywords" content="admin, estimates, bootstrap, business, corporate, creative, management, minimal, modern, accounts, invoice, html5, responsive, CRM, Projects">
        <meta name="author" content="Dreamguys - Bootstrap Admin Template">
        <meta name="robots" content="noindex, nofollow">
        <title>Homex - Real Estate Template</title>
		<link rel="shortcut icon" href="images/favicon.ico">
		<!-- Favicon -->
        <link rel="shortcut icon" type="image/x-icon" href="assets/logomvr.png">
		
		<!-- Bootstrap CSS -->
        <link rel="stylesheet" href="css/bootstrap.min.css">
		
		<!-- Fontawesome CSS -->
        <!-- <link rel="stylesheet" href="css/font-awesome.min.css"> -->
		
		<!-- Lineawesome CSS -->
        <link rel="stylesheet" href="css/line-awesome.min.css">
		
		<!-- Select2 CSS -->
		<link rel="stylesheet" href="css/select2.min.css">
		
		<!-- Datetimepicker CSS -->
		<link rel="stylesheet" href="css/bootstrap-datetimepicker.min.css">
		
		<!-- Main CSS -->
        <link rel="stylesheet" href="css/style.css">
		<script src="js/popper.min.js"></script> 
<script src="js/bootstrap.min.js"></script> 
 <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
		
		<script>
		$(document).ready(function () {
			
	        showProfileDetails();
	    });
		function showProfileDetails() {
	        // Get the selected property ID from the dropdown
	        var username = '<%= session.getAttribute("email") %>';
	        console.log(username);
			
	        // Make an AJAX request to the server-side endpoint with the selected property ID
	        $.ajax({
	            type: 'GET',
	            url: 'ProfileDetails?username=' + username,
	            dataType: 'json',
	            success: function (data) {
	                // Populate the form fields with the retrieved property details
	                $('[name="name"]').val(data.name);
	                $('[name="userid"]').val(data.userid);
	                $('[name="email"]').val(data.email);
	                
	                 $('[name="password"]').val(data.password); 
	                 $('[name="phone"]').val(data.phoneNum); 
	                 $('[name="address"]').val(data.address); 
	                /* $('[name="phone"]').val(data.phone); */
	                // ... Add more fields as needed ...	
	                // Update the table with property features if available
	                updatePropertyFeatures(data.features);
	            },
	            error: function (error) {
	                console.error('Error fetching property details:', error);
	            }
	        });
	    }
		
		</script>
		<script>
		function submitProfileForm(event) {
		    event.preventDefault(); // Prevent the default form submission
		    // Get form data
		    var formData = {
		    		userid: $('#userid').val(),
		        name: $('#name').val(),		        
		        email: $('#email').val(),
		        phoneNum: $('#phone').val(),
		        password: $('#password').val(),
		        address: $('#address').val()
		        // Add other form fields as needed
		    };
		    console.log("data", JSON.stringify(formData));
		    // Make an AJAX request
		    $.ajax({
		        type: 'POST',
		        url: 'EditProfile',
		        data: JSON.stringify(formData),
		        contentType: 'application/json',
		        success: function (data) {
		            console.log('Profile updated successfully');
		            // Handle success, e.g., show a success message
		        },
		        error: function (error) {
		            console.error('Error updating profile:', error);
		            // Handle error, e.g., show an error message
		        }
		    });
		}

		</script>
		
		    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f0f0f0;
            display: flex;
        }

        main {
            flex: 1;
            overflow-y: auto; /* Enable vertical scrolling */
        }

        section {
            display: flex;
            justify-content: space-around;
            flex-wrap: wrap;
            padding: 20px;
        }

        .feature {
            width: 30%;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            margin: 10px;
            padding: 20px;
            box-sizing: border-box;
        }

        .feature img {
            max-width: 100%;
            border-radius: 4px;
        }

        footer {
            background-color: #2c3e50;
            color: #fff;
            text-align: center;
            padding: 10px;
            position: fixed;
            bottom: 0;
            width: 100%;
        }
  .white-smoke-background {
    background-color: whitesmoke;
    height: 530px;
    width : 1200px;
    padding: 50px 80px; /* Increase padding for wider frame and more height */
    border-radius: 12px; /* Increase border-radius for smoother corners */
    box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2); /* Optional: Adjust shadow */
    margin-right: 20px; /* Increase margin towards the right */
}

     
    </style>
    </head>
<body>

 <form id="profileForm" action="EditProfile" method="post" onsubmit="submitProfileForm(event)">

<div class="main-wrapper">
    
        <!--	Header start  -->
		<jsp:include page="header.jsp" />
        <!--	Header end  -->
        
       <!--	sidebar start  -->
        <jsp:include page="sidebar.jsp" />
		 <!--	sidebar end  -->
		 
		 <div class="page-wrapper">
			
				<!-- Page Content -->
                <div class="content container-fluid">
        <div class="white-smoke-background">
       <div class="page-header">
                    <div class="row">
                        <div class="col-sm-12">
                            <h3 class="page-title">Profile</h3>
                            <ul class="breadcrumb">
                                <li class="breadcrumb-item"><a href="index.jsp">Dashboard</a></li>
                                <li class="breadcrumb-item active">Profile</li>
                            </ul>
                        </div>
                    </div>
                </div>
                <!-- Other content or form elements can be placed here -->           						
						<!-- Profile Modal -->
							<div class="row">
								<div class="col-md-12">
									<h2>Profile Information</h2>
							</div>
							</div>
																											
								<div class="row">
								<div class="col-md-6">
								<div class="form-group">
									<label> Name <span class="text-danger">*</span></label>				
					    <input type="text" id="name" name="name" class="form-control">					       
								</div>
							</div>
					
					
					<div class="col-md-6">
						<div class="form-group">
							<label>Email<span class="text-danger">*</span></label>
			       <input type="text" id="email" name="email" class="form-control">
						</div>
					</div>
						</div>		
						<div class="row">		
					<div class="col-md-6">
						<div class="form-group">
							<label>Phone number<span class="text-danger">*</span></label>
			       		<input type="text" id="phone" name="phone" class="form-control" >
						</div>
					</div>
					<div class="col-md-6" >
						<div class="form-group">
							<label>Password <span class="text-danger">*</span></label>
			       		<input type="text" id="password" name="password" class="form-control" readonly>
						</div>
					</div>	
					</div>	
					<div class="row">
						<div class="col-md-6" >
						<div class="form-group">
							<label>Address <span class="text-danger">*</span></label>
			       		<input type="text" id="address" name="address" class="form-control">
						</div>
					</div>
					<div class="col-md-6" style="display:none;">
						<div class="form-group">
							<input type="text" id="userid" name="userid" class="form-control">
						</div>
					</div>
					</div>
					<div class="row">									
										<div class="col-md-12 text-center">
										<div class="form-group">
					                <input type="submit" value="Submit" class="btn btn-success centre">
					            </div>
					            </div>
								</div>
						</div>        
        <!--	Footer   start-->		
        </div>
        <%@ include file="footer.jsp" %>
    </div>
</div>
</form>

</body>
</html>