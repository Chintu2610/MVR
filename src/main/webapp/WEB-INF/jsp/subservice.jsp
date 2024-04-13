<%
HttpSession sdsession = request.getSession(true);
String name = (String) sdsession.getAttribute("name");
String username = (String) sdsession.getAttribute("email");
String roleIDString = (String) sdsession.getAttribute("RoleID");
%>
<% 
    // Retrieve the serviceId from the request parameters
    String serviceId = request.getParameter("serviceId");
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
    <link rel="stylesheet" href="css/tstyle.css">
    <title>Sub Service</title>
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
            </div>
        </div>
    </div>
</div>
<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/popper.min.js"></script>
<script src="js/jquery.slimscroll.min.js"></script>

<script>
    $(document).ready(function() {
        // Function to fetch service details via AJAX
        function fetchServiceDetails(serviceId) {
            $.ajax({
                type: 'GET',
                url: 'subserviceDetails?serviceId=' + serviceId, // Pass serviceId as a parameter
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
            data.forEach(function(subservice) {
                // Generate the base URL for assets
                var currentUrl = window.location.href;
                var baseUrl = currentUrl.split('/').slice(0, 3).join('/');
                var assetsUrl = baseUrl + '/assets/';

                // Check if service has an image URL
                var imageUrl;
                if (subservice.imageUrl !== null) {
                    // Generate the image URL by concatenating the assets URL with the service image URL
                    imageUrl = assetsUrl + subservice.imageUrl;
                } else {
                    // If there's no image URL, use a default image
                    imageUrl = assetsUrl + 'NOImage.jpg';
                }

                var cardHtml = 
                    '<div class="col-md-6 col-sm-6 col-lg-6 col-xl-4">' +
                        '<div class="card dash-widget">' +
                            '<div class="card-body">' +
                                '<div class="dropdown dropdown-action profile-action">' + // Added dropdown container
                                    '<a href="#" class="action-icon dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><i class="material-icons">more_vert</i></a>' +
                                    '<div class="dropdown-menu dropdown-menu-right">' + // Dropdown menu
                                        '<a class="dropdown-item editSubService" href="#" data-subservice-id="' + subservice.subserviceId + '" data-image-url="' + subservice.imageUrl + '" data-subservice-name="' + (subservice.subserviceName ? subservice.subserviceName : 'No Service Name') + '" data-service-id="' + subservice.serviceId + '">Edit</a>' +
                                        '<a class="dropdown-item deleteSubService" href="#" data-subservice-id="' + subservice.subserviceId + '">Delete</a>' + // Delete button
                                    '</div>' +
                                '</div>' +
                                '<span class="dash-widget-icon">' +
                                    '<img src="' + imageUrl + '" style="width: 60px; height: 60px; border-radius: 50%;">' +
                                '</span>' +
                                '<div class="dash-widget-info">' +
                                    '<h4><a href="subsubservice.jsp?subserviceId=' + subservice.subserviceId + '" style="text-decoration: none; color: inherit;">' +
                                        '<br>' +
                                        '<span>' + (subservice.subserviceName ? subservice.subserviceName : 'No Service Name') + '</span>' +
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
            
            // Attach event listener to delete buttons
            attachDeleteButtonListener();
            attachEditButtonListener();
        }

        // Function to attach event listener to delete buttons
        function attachDeleteButtonListener() {
            $('.deleteSubService').click(function(e) {
                e.preventDefault(); // Prevent default link behavior
                // Extract subserviceId from the clicked delete button
                var subserviceId = $(this).data('subservice-id');
                // Send AJAX request to delete subservice endpoint
                $.ajax({
                    type: 'POST',
                    url: '/subservicedelete',
                    data: { subserviceId: subserviceId },
                    success: function(response) {
                        // Redirect to service page after successful deletion
                        window.location.href = '/service';
                    },
                    error: function(xhr, status, error) {
                        console.error('Error deleting subservice:', error);
                        // Handle error if needed
                    }
                });
            });
        }

        
        function attachEditButtonListener() {
            $('.editSubService').click(function(e) {
                e.preventDefault(); // Prevent default link behavior
                
                // Extract service details from the clicked edit button
                var subserviceId = $(this).data('subservice-id');
                var imageUrl = $(this).data('image-url');
                var subserviceName = $(this).data('subservice-name');
                var serviceId = $(this).data('service-id'); // Corrected attribute name
                
                // Populate the modal fields with service details
                $('#editsubservice-id').val(subserviceId);
                $('#editimage_url').val(imageUrl);
                $('#editsubservicename').val(subserviceName);
                $('#editserviceid').val(serviceId);
                
                // Show the edit modal
                $('#editModal').modal('show');
            });
        }

        
        // Fetch service details when the page loads
        var serviceId = '<%= serviceId %>'; // Retrieve serviceId from JSP
        fetchServiceDetails(serviceId);

        // Attach click event to Add Service button to fetch service details
        $('#addServiceButton').click(function() {
            fetchServiceDetails(serviceId);
        });
    });
</script>

  <jsp:include page="subservice_add.jsp" />  
  <jsp:include page="subservice_edit.jsp" />
<%-- <jsp:include page="subservice_add.jsp">
    <jsp:param name="serviceId" value="<%= serviceId %>" />
</jsp:include> --%>
<script src="js/bootstrap.min.js"></script>
</body>
</html>
