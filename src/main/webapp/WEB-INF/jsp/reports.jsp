<%
HttpSession sessionRec = request.getSession(true);
// Initialize recordsPerPage and currentPage as Java variables
String recordsPerPageStr = (String) sessionRec.getAttribute("recordsPerPage");
String currentPageStr = (String) sessionRec.getAttribute("currentPage");
if (recordsPerPageStr == null || "0".equals(recordsPerPageStr)) {
    recordsPerPageStr = "10"; // Set a default value, e.g., 1
    sessionRec.setAttribute("recordsPerPage", recordsPerPageStr);
}
int recordsPerPage = Integer.parseInt(recordsPerPageStr);

if (currentPageStr == null || "0".equals(currentPageStr)) {
    currentPageStr = "1"; // Set a default value, e.g., 1
    sessionRec.setAttribute("currentPage", currentPageStr);
}
int currentPage = Integer.parseInt(currentPageStr);
// Handle the change in recordsPerPage here
int newRecordsPerPage = 10; // Default value
String newRecordsPerPageParam = request.getParameter("newRecordsPerPage");
if (newRecordsPerPageParam != null) {
    newRecordsPerPage = Integer.parseInt(newRecordsPerPageParam);
    sessionRec.setAttribute("recordsPerPage", String.valueOf(newRecordsPerPage));
    //currentPage = 1; // Reset to the first page when changing recordsPerPage
    //sessionRec.setAttribute("currentPage", "1");
}
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
     <link rel="stylesheet" href="css/tstyles.css">
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>

    <!-- jQuery -->
    <script src="js/jquery-3.2.1.min.js"></script>
    <title>Services</title>



</head>
<body>

<div class="main-wrapper">
    <%@ include file="header.jsp" %>
    <%@ include file="sidebar.jsp" %>
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
            Welcome <%= name %>!
        </div>
        <div class="col">
            <h3 class="page-title">Users</h3>
            <ul class="breadcrumb">
                <li class="breadcrumb-item"><a href="admin_dashboard.jsp">Dashboard</a></li>
                <li class="breadcrumb-item active">reports</li>
            </ul>
          
        </div>
    </div>
</div>

            </div>
             <!-- Main Headings with Toggleable Content -->
     <div class="row justify-content-center">
    <div class="col-md-12 text-center">
<button id="numberOfUsersRegisteredThisMonth" class="btn btn-primary">Number of Users Registered This Month</button>
<button id="fetchDeliveryDatePassedBtn" class="btn btn-secondary">Number of Projects Assigned This Month</button>
<button id="numberOfTrainingCompletedThisMonth" class="btn btn-success">Number of Training Completed This Month</button> 
    <!-- Containers to display fetched data -->
  </div>
  </div>
	 <table id="notificationTable">
        <thead>
            <tr>
            	<th>Name</th>
            	<th>Address</th>
                <th style="width: 250px;">Email</th>
                <th>Ph. No</th>
                
                <!-- Add more table headers if needed -->
            </tr>
        </thead>
        <tbody id="notificationTableBody">
            <!-- Table body will be populated dynamically -->
        </tbody>
    </table>
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    
    <!-- Add your JavaScript at the end of the body -->
    <script>
        function numberOfUsersRegisteredThisMonth() {
            // Make an AJAX request to the server-side endpoint to fetch all user details
            $.ajax({
                type: 'GET',
                url: 'numberOfUsersRegisteredThisMonth',
                dataType: 'json',
                success: function (data) {
                	$('#notificationTable thead').html(
                            '<tr>' +
                            '<th>Name</th>' +
                            '<th>Address</th>' +
                            '<th style="width: 250px;">Email</th>' +
                            '<th>Ph. No</th>' +
                           
                            '</tr>'
                        );
                    // Clear the table body before populating with new data
                    $('#notificationTable tbody').empty();
                    // Iterate over each user data and append a new row to the table
                    $.each(data, function (index, user) {
                    	
                        var row = '<tr>' +
                            '<td >' + user.name + '</td>' +
                            '<td>' + user.address + '</td>' +
                            '<td style="width: 250px;">' + user.email + '</td>' +
                            '<td>' + user.phoneNum + '</td>' +
                            '<td>' +
                            '</td>' +
                            '</tr>';
                        var $row = $(row);
                        // Attach event listeners to the edit and delete buttons in this row
                        

                        $('#notificationTable tbody').append($row);
                    });
                },
                error: function (error) {
                    console.error('Error fetching user details:', error);
                }
            });
        }
		
        // Attach click event listener to the button
        document.getElementById('numberOfUsersRegisteredThisMonth').addEventListener('click', numberOfUsersRegisteredThisMonth);

        function numberOfWorksAssignedThisMonth() {
            // Change table headers
            $('#notificationTable thead').html(
                '<tr>' +
                '<th>Email</th>' +
                '<th>Assigned Work</th>' +
                '<th>Status</th>' +
                '<th>Deadline</th>' +
                '<th>Action</th>' +
                '</tr>'
            );

            // Make an AJAX request to fetch data for works assigned this month
            $.ajax({
                type: 'GET',
                url: 'numberOfWorksAssignedThisMonth',
                dataType: 'json',
                success: function (data) {
                    // Clear the table body before populating with new data
                    $('#notificationTable tbody').empty();

                    // Iterate over each user data and append a new row to the table
                    $.each(data, function (index, user) {
                        var row = '<tr>' +
                            '<td class="email" style="width: 250px;">' + user.email + '</td>' +
                            '<td>' + user.assignedWork + '</td>' +
                            '<td>' + user.status + '</td>' +
                            '<td>' + user.deadline + '</td>' +
                            '<td>' +
                            '</td>' +
                            '<td>' +
                            '</td>' +
                            '</tr>';
                        var $row = $(row);
                        // Attach event listeners to the edit and delete buttons in this row

                        $('#notificationTable tbody').append($row);
                    });
                },
                error: function (error) {
                    console.error('Error fetching user details:', error);
                }
            });
        }

        // Attach click event listener to the button for works assigned this month
        document.getElementById('fetchDeliveryDatePassedBtn').addEventListener('click', numberOfWorksAssignedThisMonth);

        // Function to fetch data for delivered products
        function numberOfTrainingCompletedThisMonth() {
            // Change table headers
            $('#notificationTable thead').html(
                '<tr>' +
                '<th>Email</th>' +
                '<th>Assigned Work</th>' +
                '<th>Status</th>' +
                '<th>Deadline</th>' +
                '</tr>'
            );

            // Make an AJAX request to fetch data for delivered products
            $.ajax({
                type: 'GET',
                url: 'numberOfTrainingCompletedThisMonth',
                dataType: 'json',
                success: function (data) {
                    // Clear the table body before populating with new data
                    $('#notificationTable tbody').empty();

                    // Iterate over each user data and append a new row to the table
                    $.each(data, function (index, user) {
                        var row = '<tr>' +
                            '<td style="width: 250px;">' + user.email + '</td>' +
                            '<td>' + user.assignedWork + '</td>' +
                            '<td>' + user.status + '</td>' +
                            '<td>' + user.deadline + '</td>' +
                            '</tr>';
                        var $row = $(row);
                        // Attach event listeners to the edit and delete buttons in this row

                        $('#notificationTable tbody').append($row);
                    });
                },
                error: function (error) {
                    console.error('Error fetching user details:', error);
                }
            });
        }

        // Attach click event listener to the button for delivered products
        document.getElementById('numberOfTrainingCompletedThisMonth').addEventListener('click', numberOfTrainingCompletedThisMonth);

    </script>
       </div>
       </div>
         
    
     
   <div class="row justify-content-center align-items-center custom-pagination d-flex justify-content-center" id="flag1">
    
     
   </div>


<jsp:include page="useredit.jsp" /> 

    <!-- Bootstrap Core JS -->
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>

    <!-- Slimscroll JS -->
    <script src="js/jquery.slimscroll.min.js"></script>

    <!-- Select2 JS -->
    <script src="js/select2.min.js"></script>

    <!-- Datetimepicker JS -->
    <script src="js/moment.min.js"></script>
    <script src="js/bootstrap-datetimepicker.min.js"></script>

    
 
</body>
</html>