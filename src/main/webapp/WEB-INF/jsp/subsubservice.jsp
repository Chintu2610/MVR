<%
HttpSession sdsession = request.getSession(true);
String name = (String) sdsession.getAttribute("name");
String username = (String) sdsession.getAttribute("email");
String roleIDString = (String) sdsession.getAttribute("RoleID");
%>
<% 
    // Retrieve the serviceId from the request parameters
    String subserviceId = request.getParameter("subserviceId");
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

               <div class="row" id="videoContainer">
                    <!-- Videos will be displayed here -->
                </div>
                
                
            </div>
        </div>
    </div>
</div>
     <script src="js/jquery-3.2.1.min.js"></script>
<script>
    $(document).ready(function() {
        // Function to fetch videos via AJAX
         var subserviceId = '<%= subserviceId %>';
        function fetchVideos() {
          //  debugger;
            $.ajax({
              //  url: 'subsubserviceDetails', 
                 url: 'subsubserviceDetails?subserviceId=' + subserviceId,
                method: 'GET',
                success: function(response) {
                    var videoContainer = $('#videoContainer');
                    videoContainer.empty(); // Clear previous videos
                    response.forEach(function(video) {
                        var dropdownMenu = $('<div class="dropdown-menu dropdown-menu-right">' +
                        	    '<a class="dropdown-item editSubService" href="#" data-sss="' + video.subsubserviceId + '" data-tite="' + (video.title ? video.title : 'No Service Name') + '" data-url="' + video.url + '" data-subservice222="' + video.subserviceId + '">Edit</a>' +
                            '<a class="dropdown-item deleteSubService" href="#" data-ffff="' + video.subsubserviceId + '">Delete</a>' +
                            '<a class="dropdown-item" href="' + video.url + '" target="_blank"><i class="fab fa-youtube"></i> Watch on YouTube</a>' +
                            '</div>');
                      /*   var videoElement = $('<div class="video">' +
                        	    '<div class="dropdown">' +
                        	    '<button class="btn btn-sm btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">' +
                        	    '<i class="fas fa-ellipsis-v"></i>' + // Kebab icon
                        	    '</button>' +
                        	    '<div class="dropdown-menu dropdown-menu-right" aria-labelledby="dropdownMenuButton">' +
                        	    '<a class="dropdown-item editSubService" href="#" data-subsubserviceId="' + video.subsubserviceId + '" data-tite="' + (video.title ? video.title : 'No Service Name') + '" data-url="' + video.url + '" data-subserviceId="' + video.subserviceId + '">Edit</a>' +
                        	    '<a class="dropdown-item deleteSubService" href="#" data-subsubserviceId="' + video.subsubserviceId + '">Delete</a>' +
                        	    '<a class="dropdown-item" href="' + video.url + '" target="_blank"><i class="fab fa-youtube"></i> Watch on YouTube</a>' +
                        	    '</div>' +
                        	    '</div>' +
                        	    '<a href="' + video.url + '">' + video.title + '</a>' +
                        	    '<input type="checkbox" name="video" value="' + video.url + '"><br>' +
                        	    '<iframe width="200" height="100" src="' + video.url + '" frameborder="0" allowfullscreen></iframe>' + // Add iframe here
                        	    '</div>');
 */
 var videoElement = $('<div class="video" style="margin-bottom: 20px; margin-left: 40px;">' +
		    '<div class="dropdown">' +
		    '<button class="btn btn-sm btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">' +
		    '<i class="fas fa-ellipsis-v"></i>' + // Kebab icon
		    '</button>' +
		    '<div class="dropdown-menu dropdown-menu-right" aria-labelledby="dropdownMenuButton">' +
		    '<a class="dropdown-item editSubService" href="#" data-sss="' + video.subsubserviceId + '" data-tite="' + (video.title ? video.title : 'No Service Name') + '" data-url="' + video.url + '" data-subservice222="' + video.subserviceId + '">Edit</a>' +
		    '<a class="dropdown-item deleteSubService" href="#" data-ffff="' + video.subsubserviceId + '">Delete</a>' +
		    '<a class="dropdown-item" href="' + video.url + '" target="_blank"><i class="fab fa-youtube"></i> Watch on YouTube</a>' +
		    '</div>' +
		    '</div>' +
		    '<a href="' + video.url + '">' + video.title + '</a>' +
		    '<input type="checkbox" name="video" value="' + video.url + '"><br>' +
		    '<iframe width="200" height="100" src="' + video.url + '" frameborder="0" allowfullscreen></iframe>' + // Add iframe here
		    '</div>');


                        	dropdownMenu.appendTo(videoElement.find('.dropdown'));
                        	videoContainer.append(videoElement);

                    });
                },
                error: function(xhr, status, error) {
                    console.error(xhr.responseText);
                }
            });
        }
        fetchVideos();
        
        // Event listener for delete button
        $('#videoContainer').on('click', '.deleteSubService', function(e) {
            e.preventDefault(); // Prevent default link behavior
            debugger;
            var subsubserviceId = $(this).data('ffff');
            
            // Remove the parent div of the delete button (which is the video container)
            $(this).closest('.video').remove();
            
            // Send AJAX request to delete the subsubservice
            $.ajax({
                type: 'POST',
                url: '/subsubservicedelete',
                data: { subsubserviceId: subsubserviceId },
                success: function(response) {
                    // Optional: Show success message or perform any additional actions
                    console.log('Subsubservice deleted successfully');
                },
                error: function(xhr, status, error) {
                    console.error('Error deleting subservice:', error);
                }
            });
        });
        
        // Attach event listener for edit buttons
        attachEditButtonListener();
    });
    
    // Function to attach event listener for edit buttons
    function attachEditButtonListener() {
        $(document).on('click', '.editSubService', function(e) {
            e.preventDefault(); // Prevent default link behavior
           debugger; 
            // Extract service details from the clicked edit button
            var subsubserviceId = $(this).data('sss');
            var url = $(this).data('url');
            var title = $(this).data('tite'); // Corrected attribute name
            var subserviceId = $(this).data('subservice222'); // Ensure this attribute exists in your HTML
            
            // Populate the modal fields with service details
            $('#editsubsubserviceId').val(subsubserviceId);
            $('#editurl').val(url);
            $('#edittitle').val(title); // Corrected variable name
            $('#editsubserviceId').val(subserviceId);
            
            // Show the edit modal
            $('#editModal').modal('show');
        });
    }
</script>



      <jsp:include page="subsubservice_add.jsp" /> 
       <jsp:include page="subsubservice_edit.jsp" />
<!-- <script src="js/jquery-3.2.1.min.js"></script> -->
<script src="js/popper.min.js"></script>
<script src="js/jquery.slimscroll.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>
