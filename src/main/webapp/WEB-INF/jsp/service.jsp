<%
HttpSession sdsession = request.getSession(true);
String name = (String) sdsession.getAttribute("name");
String username = (String) sdsession.getAttribute("email");
String roleIDString = (String) sdsession.getAttribute("RoleID");

%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0">
    <meta name="description" content="xm-s1 Admin Template">
    <meta name="keywords" content="admin, Cryptocurrency, account management">
    <meta name="author" content="xm-s1 Admin Template">
    <meta name="robots" content="noindex, nofollow">

    <!-- Favicon -->
    <link rel="shortcut icon" type="image/x-icon" href="assets/logomvr.png">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css">

    <!-- Fontawesome CSS -->
    <link rel="stylesheet" href="css/font-awesome.min.css">

    <!-- Lineawesome CSS -->
    <link rel="stylesheet" href="css/line-awesome.min.css">

    <!-- Main CSS -->
    <link rel="stylesheet" href="css/style.css">
    <title>Service</title>

</head>
<body>
<div class="main-wrapper">
    <jsp:include page="header.jsp" />
    <jsp:include page="sidebar.jsp" /> 

    <!-- Page Wrapper -->
    <div class="page-wrapper">
        <!-- Page Content -->
        <div class="content container-fluid">
            <!-- Page Header -->
            <div class="page-header">
                <div class="row align-items-center">
                    <div class="col-sm-12">
                        <!-- Display welcome message -->
                        <div id="welcomeMessage" style="text-align: center; margin-top: 20px; font-size: 24px;">
                            Welcome <%= username %>!
                        </div>
                        <ul class="breadcrumb">
                            <li class="breadcrumb-item active">Dashboard</li>
                        </ul>
                    </div>
                </div>


   <div class="col-auto float-right ml-auto">
							<a href="#" class="Addbutton" data-toggle="modal" data-target="#add1"><i class="fa fa-plus"></i> Add </a>
			         </div>

                <!-- Dynamically generate cards -->
                <div class="row" id="serviceCards">
                    <!-- Service cards will be dynamically populated here -->
                </div>

           <!--      Add Service Button
                <div class="row justify-content-center">
                    <div class="col-md-6">
                        <button class="btn btn-primary btn-block" id="addServiceButton">Add Service</button>
                    </div>
                </div> -->
                
               
                
                
            </div>
        </div>
    </div>
</div>
<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/popper.min.js"></script>
<!-- <script src="js/bootstrap.min.js"></script> -->
<script src="js/jquery.slimscroll.min.js"></script>

<script>
    $(document).ready(function() {
        // Function to fetch service details via AJAX
        function fetchServiceDetails() {
            $.ajax({
                type: 'GET',
                url: 'serviceDetails',
                dataType: 'json',
                success: function(data) {
                    console.log('Received data:', data); // Log the received data
                    // Process the received data and generate service cards
                    populateServiceCards(data);
                },
                error: function(xhr, status, error) {
                    console.error('Error fetching service details:', error);
                }
            });
        }

     // Function to populate service cards in the UI
        function populateServiceCards(data) {
            // Initialize an empty string to store the generated HTML for service cards
            var serviceCardsHtml = '';

            // Loop through each service object in the data array
            data.forEach(function(service) {
                // Generate the base URL for assets
                var currentUrl = window.location.href;
                var baseUrl = currentUrl.split('/').slice(0, 3).join('/');
                var assetsUrl = baseUrl + '/assets/';

                // Check if service has an image URL
                var imageUrl;
                if (service.imageUrl !== null) {
                    // Generate the image URL by concatenating the assets URL with the service image URL
                    imageUrl = assetsUrl + service.imageUrl;
                } else {
                    // If there's no image URL, use a default image
                    imageUrl = assetsUrl + 'NOImage.jpg';
                }
		console.log(imageUrl);
                // Create the HTML for the current service card
			             /*  var cardHtml = 
			    '<div class="col-md-6 col-sm-6 col-lg-6 col-xl-4">' +
			        '<div class="card dash-widget">' +
			            '<div class="card-body">' +
			                '<span class="dash-widget-icon">' +
			                    '<img src="' + imageUrl + '" style="width: 60px; height: 60px; border-radius: 50%;">' +
			                '</span>' +
			                '<div class="dash-widget-info">' +
			                    '<h4><a href="' + service.url + '" style="text-decoration: none; color: inherit;">' +
			                        '<br>' +
			                        '<span>' + (service.serviceName ? service.serviceName : 'No Service Name') + '</span>' +
			                    '</a></h4>' +
			                '</div>' +
			            '</div>' +
			        '</div>' +
			    '</div>'; */

			 // Create the HTML for the current service card
			    var cardHtml = 
			        '<div class="col-md-6 col-sm-6 col-lg-6 col-xl-4">' +
			            '<div class="card dash-widget">' +
			                '<div class="card-body">' +
			                    '<span class="dash-widget-icon">' +
			                        '<img src="' + imageUrl + '" style="width: 60px; height: 60px; border-radius: 50%;">' +
			                    '</span>' +
			                    '<div class="dash-widget-info">' +
			                        '<h4><a href="subservice.jsp?serviceId=' + service.serviceId + '" style="text-decoration: none; color: inherit;">' +
			                            '<br>' +
			                            '<span>' + (service.serviceName ? service.serviceName : 'No Service Name') + '</span>' +
			                        '</a></h4>' +
			                    '</div>' +
			                '</div>' +
			            '</div>' +
			        '</div>';

                // Append the generated card HTML to the serviceCardsHtml string
                serviceCardsHtml += cardHtml;
            });

            // Set the HTML content of the service cards container
            $('#serviceCards').html(serviceCardsHtml);
        }

        // Fetch service details when the page loads
        fetchServiceDetails();

        // Attach click event to Add Service button to fetch service details
        $('#addServiceButton').click(function() {
            fetchServiceDetails();
        });
    });
</script>
<jsp:include page="service_add.jsp" />

</body>
</html>
