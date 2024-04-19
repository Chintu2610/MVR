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

function deleteRawMaterial(ID) {
    // Perform the delete operation using AJAX
    $.ajax({
        type: 'POST',
        url: '/userdelete',
        data: { userid: ID },
        success: function(response) {
            window.location.reload();
        },
        error: function(xhr, status, error) {
            // Handle error response
            alert('Error: ' + error);
        }
    });
}

function editRawMaterial(userid, name, email, phoneNum, paid250, approvestatus) {
    $('#edituserid').val(userid);
    $('#editname').val(name);
    $('#editemail').val(email);
    $('#editphoneNum').val(phoneNum);
    $('#editaddress').val(address);
    $('#editpaid250').val(paid250);
    $('#editapprovestatus').val(approvestatus);

    // Show the edit modal
    $('#editModal').modal('show');
}

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
                          '<td>' + user.userid + '</td>' +
                          '<td>' + user.name + '</td>' +
                          '<td>' + user.email + '</td>' +
                          '<td>' + user.phoneNum + '</td>' +
                          '<td>' + user.address + '</td>' +
                          '<td>' + user.paid250 + '</td>' +
                          '<td>' + user.approvestatus + '</td>' +
                          '<td>'; // Start button column
                if (user.approvestatus === "approved") {
                    row += '<button class="btn btn-success" disabled>Approve</button>'; // Disable the button if already approved
                } else {
                    row += '<button onclick="approveUser(' + user.userid + ')" class="btn btn-success">Approve</button>'; // Add an Approve button
                }
                row += '</td>';
                /* row += '<td style="width:300px;">' + // Add the delete and edit button columns
                       '<button class="btn btn-danger btn-sm deleteBtn" onclick="deleteRawMaterial(' + user.userid + ')">Delete</button>' +
                       '<button class="btn btn-primary btn-sm editBtn" onclick="editRawMaterial(' + user.userid + ', \'' + user.name + '\', \'' + user.email + '\', \'' + user.phoneNum +'\', \'' + user.address '\', \'' + user.paid250 + '\', \'' + user.approvestatus + '\')">Edit</button>' +
                       '</td>' +
                       '</tr>'; */ // End button column and row
                
                $('#userTable tbody').append(row);
            });
        },
        error: function (error) {
            console.error('Error fetching user details:', error);
        }
    });
}

function approveUser(userId) {
    // Make an AJAX request to update the approve status for the user with the given userId
    $.ajax({
        type: 'POST',
        url: '/approveUser', // Specify the endpoint to handle the approval
        data: { userId: userId },
        success: function (response) {
            // If the approval was successful, refresh the user details table
            showAllUserDetails();
        },
        error: function (error) {
            console.error('Error approving user:', error);
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
	        <table id="userTable" class="table-striped custom-table mb-0 datatable">
                        <thead>
                            <tr>


                                <th>User ID</th>
                                <th>Name</th>
                                <th>Email</th>
                                <th>Phone</th>
                                <th>Address</th>
                                <th>payment</th>
                                <th>Approve status</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!-- User data will be populated here -->
                        </tbody>
                    </table>
       </div>
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