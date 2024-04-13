<%@ page import="java.util.Map" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="java.text.DecimalFormat" %>
<%@ page import="java.math.BigDecimal" %>
<%
    // Getting the username from the session
    String username = (String)session.getAttribute("name");


HttpSession sdsession = request.getSession(true);

// Retrieve the username attribute from the session
String usernamee = (String) sdsession.getAttribute("username");
String roleIDString = (String) sdsession.getAttribute("RoleID");
 


%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=0">
<meta name="description" content="xm-s1 Admin Template">
<meta name="keywords"
	content="admin, Cryptocurrency, account management">
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
    <title>Assign Task</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
   <style>
   .submit-btn {
            background-color: #007bff;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        .submit-btn:hover {
            background-color: #0056b3;
        }
   </style>
    
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
                <div class="col">
                        <div class="col-sm-12">
                            <!-- Display welcome message -->
                            <div id="welcomeMessage" style="text-align: center; margin-top: 20px; font-size: 24px;">
                                Welcome <%= username %>!
                            </div>
                            <ul class="breadcrumb">
                                <li class="breadcrumb-item active">Dash board</li>
                            </ul>
                        </div>
                    </div>
                </div>


<form action = "/assign_work" method="post">

 
					<div class="form-group row">
                            <label for="email" class="col-sm-2 col-form-label">Email<span class="text-danger">*</span></label>
                            <div class="col-sm-8">
                                <select id="email" name="email" class="form-control"></select>
                            </div>
                        </div>

<script>
    $(document).ready(function () {
        showAllUserEmailDetails();
    });

    function showAllUserEmailDetails() {
        // Make an AJAX request to the server-side endpoint to fetch all user details
        $.ajax({
            type: 'GET',
            url: 'userDetails',
            dataType: 'json',
            success: function (data) {
                // Clear the dropdown before populating with new data
                $('#email').empty();

                // Iterate over each user data and append a new option to the dropdown
                $.each(data, function (index, user) {
                    $('#email').append($('<option>', {
                        value: user.email,
                        text: user.email
                    }));
                });
            },
            error: function (error) {
                console.error('Error fetching user details:', error);
            }
        });
    }
</script>


<div class="form-group row">
                            <label for="assigned_work" class="col-sm-2 col-form-label">Available Works<span class="text-danger">*</span></label>
                            <div class="col-sm-8">
                                <select id="assigned_work" name="work" class="form-control"></select>
                            </div>
                        </div>



<script>
    $(document).ready(function () {
        showAllAssignedTasks();
    });

    function showAllAssignedTasks() {
        // Make an AJAX request to the server-side endpoint to fetch all assigned tasks
        $.ajax({
            type: 'GET',
            url: 'getAvailableWorks',
            dataType: 'json',
            success: function (data) {
                // Clear the dropdown before populating with new data
                $('#assigned_work').empty();

                // Iterate over each task and append a new option to the dropdown
                $.each(data, function (index, task) {
                    $('#assigned_work').append($('<option>', {
                        value: task.workName,
                        text: task.workName
                    }));
                });
            },
            error: function (error) {
                console.error('Error fetching assigned tasks:', error);
            }
        });
    }
</script>

<div class="form-group row">
    <label for="rawmaterials" class="col-sm-2 col-form-label">Available RawMaterials<span class="text-danger">*</span></label>
    <div class="col-sm-8">
        <select id="rawmaterials" name="rawmaterials" class="form-control" multiple>
            <!-- Options will be populated dynamically -->
        </select>
    </div>
</div>

<!-- Input fields for specifying quantity -->
<div id="quantityInputs">
    <!-- Quantity inputs will be dynamically added here -->
</div>

<script>
    $(document).ready(function () {
        showAllAvailableRawMaterials();
    });

    function showAllAvailableRawMaterials() {
        // Make an AJAX request to the server-side endpoint to fetch all available raw materials
        $.ajax({
            type: 'GET',
            url: 'rawmaterialDetails',
            dataType: 'json',
            success: function (data) {
                // Clear the dropdown and quantity inputs before populating with new data
                $('#rawmaterials').empty();
                $('#quantityInputs').empty();

                // Iterate over each raw material and append a new option to the dropdown
                $.each(data, function (index, material) {
                    $('#rawmaterials').append($('<option>', {
                        value: material.name,
                        text: material.name
                    }));

                    // Create an input field for quantity corresponding to each raw material
                    $('#quantityInputs').append('<div class="form-group row">' +
                        '<label for="' + material.name + '" class="col-sm-2 col-form-label">' + material.name + ' Quantity</label>' +
                        '<div class="col-sm-8">' +
                        '<input type="number" id="' + material.name + '" name="' + material.name + '_quantity" class="form-control" placeholder="Enter quantity">' +
                        '</div>' +
                        '</div>');
                });
            },
            error: function (error) {
                console.error('Error fetching raw materials:', error);
            }
        });
    }
</script>

	  
                        <div class="text-center">
                            <button type="submit" class="btn btn-primary submit-btn">Assign</button>
                        </div>
</form>
                </div>
                <script>
                $(document).ready(function () {
    showAssignedWorks();
});

function showAssignedWorks() {
    // Make an AJAX request to the server-side endpoint to fetch all assigned works
    $.ajax({
        type: 'GET',
        url: 'getAllAssignedWorks',
        dataType: 'json',
        success: function (data) {
            // Clear the table body before populating with new data
            $('#assignedWorksTableBody').empty();

            // Iterate over each assigned work and append a new row to the table
            $.each(data, function (index, assignedWork) {
                var row = '<tr>' +
                    '<td>' + assignedWork.assignedWork + '</td>' +
                    '<td>' + assignedWork.email + '</td>' +
                    '<td>' + assignedWork.userId + '</td>' +
                    '</tr>';
                $('#assignedWorksTableBody').append(row);
            });
        },
        error: function (error) {
            console.error('Error fetching assigned works:', error);
        }
    });
}
</script>

                <div class="text-center mt-5">
    <h2>Assigned Works</h2>
</div>
<div class="table-responsive mt-3">
    <table class="table table-striped">
        <thead>
            <tr>
                <th>Assigned Work</th>
                <th>Email</th>
                <th>Name</th>
            </tr>
        </thead>
        <tbody id="assignedWorksTableBody">
            <!-- Assigned works will be populated here -->
        </tbody>
    </table>
</div>
            </div>
        </div>
</div>

<script src="js/jquery-3.2.1.min.js"></script> 
<script src="js/popper.min.js"></script> 
<script src="js/bootstrap.min.js"></script> 
<script src="js/jquery.slimscroll.min.js"></script> 
<%-- <%} %> --%>
    </body>
</html>