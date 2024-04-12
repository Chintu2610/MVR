

<%@ page import="java.util.Arrays" %>
 
<%
    String[] selectedVideos = request.getParameterValues("selectedVideos");
    String selectedVideosString = "";

    if (selectedVideos != null && selectedVideos.length > 0) {
        // Concatenate the video links into a single string
        selectedVideosString = String.join(",", selectedVideos);
    }
%>

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
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>

    <!-- jQuery -->
    <script src="js/jquery-3.2.1.min.js"></script>
    <title>Services</title>
<script>
 var recordsPerPage = <%= newRecordsPerPage %>; // Use Java variable in JavaScript
 var currentPage = <%= currentPage %>; 

 function changeRecordsPerPage() {
     var recordsPerPageSelect = document.getElementById("recordsPerPage");
     var selectedValue = recordsPerPageSelect.value;
     
     // Update the URL with the selected "recordsPerPage" value and navigate to it
     var baseUrl = window.location.href.split('?')[0];
     var newUrl = baseUrl + '?newRecordsPerPage=' + selectedValue;
     window.location.href = newUrl;
 }

</script>
<script>
$(document).ready(function () {
    showAllUserDetails();
});

function showAllUserDetails() {
    // Make an AJAX request to the server-side endpoint to fetch all user details
    $.ajax({
        type: 'GET',
        url: 'userDetails',
        dataType: 'json',
        success: function (data) {
            // Clear the table body before populating with new data
            $('#userTable tbody').empty();

            // Iterate over each user data and append a new row to the table
            $.each(data, function (index, user) {
                var row = '<tr>' +
               			 '<td><input type="checkbox" name="selectedEmail" value="' + user.email + '"></td>' +       
               			 '<td>' + user.userid + '</td>' +
                          '<td>' + user.name + '</td>' +
                          '<td>' + user.email + '</td>' +
                          '<td>' + user.phoneNum + '</td>' +
                          '<td>' + user.address + '</td>' +
                          // Add more columns as needed
                          '</tr>';
                $('#userTable tbody').append(row);
            });
        },
        error: function (error) {
            console.error('Error fetching user details:', error);
        }
    });
}

		
		</script>


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
                            Welcome <%= username %>!
                        </div>
                              <div class="col">
								<h3 class="page-title">Users</h3>
								<ul class="breadcrumb">
									<li class="breadcrumb-item"><a href="admin_dashboard.jsp">Dashboard</a></li>
									<li class="breadcrumb-item active">users</li>
								</ul>
							</div>
                    </div>
                </div>
            </div>
             <!-- Main Headings with Toggleable Content -->
      <div class="col-auto float-right ml-auto">

			         </div>
			         <form id="emailform" action="/ServiceController" method="get">
	        <table id="userTable" class="table-striped custom-table mb-0 datatable">
                        <thead>
                            <tr>
                            	<th>Select</th>
                                <th>User ID</th>
                                <th>Name</th>
                                <th>Email</th>
                                <th>Phone</th>
                                <th>Address</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!-- User data will be populated here -->
                        </tbody>
                    </table>
  
   
                   <input name="selectedVideos" value="<%=
                		   selectedVideos[0].toString()
%>">

         <div class="text-center">
                    <button type="submit" onclick="sendEmail()" class="btn btn-primary">Submit</button>
                </div>
            </form>
         <script>
    function sendEmail() {
        // Get all checkboxes with name 'selectedEmail'
        var selectedEmailCheckboxes = document.querySelectorAll('input[name="selectedEmail"]:checked');
        var selectedEmails = [];

        // Loop through each checked checkbox to get its value (email)
        selectedEmailCheckboxes.forEach(function(checkbox) {
            selectedEmails.push(checkbox.value); // Add the value (email) to the array
        });

        // Now you have an array of selected emails, you can do something with it
        console.log(selectedEmails); // For testing, you can log it to the console
        // You can perform further actions here, like sending it to the server via AJAX or any other logic.
    }
</script>
        </div>
    </div>
</div>


 
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.slimscroll.min.js"></script>
    <script src="js/select2.min.js"></script>
    <script src="js/moment.min.js"></script>
    <script src="js/bootstrap-datetimepicker.min.js"></script>

    
 
</body>
</html>