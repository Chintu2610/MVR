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


<script>
    $(document).ready(function() {
        // Function to fetch service details via AJAX
        function fetchServiceDetails() {
            $.ajax({
                type: 'GET',
                url: 'serviceDetails',
                dataType: 'json',
                success: function(data) {
                  //  console.log('Received data:', data); // Log the received data
                    // Process the received data and generate service cards
                    populateServiceCards(data);
                    // Attach event listener for delete buttons after service cards are populated
                    attachDeleteButtonListener();
                    // Attach event listener for edit buttons after service cards are populated
                    attachEditButtonListener();
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
                // Create the HTML for the current service card
                <!-- Create the HTML for the current service card -->
var cardHtml = 
    '<div class="col-md-6 col-sm-6 col-lg-6 col-xl-4">' +
        '<div class="card dash-widget">' +
            '<div class="card-body">' +
                '<div class="dropdown dropdown-action profile-action">' + // Added dropdown container
                    '<a href="#" class="action-icon dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><i class="material-icons">more_vert</i></a>' +
                    '<div class="dropdown-menu dropdown-menu-right">' + // Dropdown menu
                        '<a class="dropdown-item editService" href="#" data-service-id="' + service.serviceId + '" data-image-url="' + service.imageUrl + '" data-service-name="' + service.serviceName + '" data-url="' + service.url + '">Edit</a>' +
                        '<a class="dropdown-item deleteService" href="#" data-service-id="' + service.serviceId + '">Delete</a>' + // Delete button
                    '</div>' +
                '</div>' +
                '<span class="dash-widget-icon">' +
                    '<img src="' + imageUrl + '" style="width: 60px; height: 60px; border-radius: 50%;">' +
                '</span>' +
                '<div class="dash-widget-info">' +
                    '<h4><a href="subservice?serviceId=' + service.serviceId + '" style="text-decoration: none; color: inherit;">' +
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

        // Function to attach event listener for delete buttons
        function attachDeleteButtonListener() {
            $('.deleteService').click(function(e) {
                e.preventDefault(); // Prevent default link behavior
                // Extract serviceId from the clicked delete button
                var serviceId = $(this).data('service-id');
                // Send AJAX request to delete service endpoint
                $.ajax({
                    type: 'POST',
                    url: '/servicedelete',
                    data: { serviceId: serviceId },
                    success: function(response) {
                        // Redirect to service page after successful deletion
                        window.location.href = '/service';
                    },
                    error: function(xhr, status, error) {
                        console.error('Error deleting service:', error);
                        // Handle error if needed
                    }
                });
            });
        }

     // Function to attach event listener for edit buttons
        function attachEditButtonListener() {
            $('.editService').click(function(e) {
                e.preventDefault(); // Prevent default link behavior
                // Extract service details from the clicked edit button
                var service_id = $(this).data('service-id');
                var image_url = $(this).data('image-url');
                var service_name = $(this).data('service-name');
                var url = $(this).data('url');
                
                // Populate the modal fields with service details
                $('#editService_id').val(service_id);
                $('#editImage_url').val(image_url);
                $('#editService_name').val(service_name);
                $('#editUrl').val(url);
                
                // Show the edit modal
                $('#editModal').modal('show');
            });
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
	<jsp:include page="service_edit.jsp" />

<script src="js/jquery-3.2.1.min.js"></script> 
<script src="js/popper.min.js"></script>
<!-- <script src="js/bootstrap.min.js"></script> -->
<script src="js/jquery.slimscroll.min.js"></script>

</body>
</html>
