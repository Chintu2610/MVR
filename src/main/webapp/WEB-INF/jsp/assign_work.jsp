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
    <div class="col-sm-10">
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>Raw Material</th>
                       <th>Available Quantity</th>
                    <th>Quantity to Assign</th>
                </tr>
            </thead>
            <tbody id="rawMaterialTable">
                <!-- Raw materials and quantity input fields will be populated dynamically here -->
            </tbody>
        </table>
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
                // Clear the table body before populating with new data
                $('#rawMaterialTable').empty();

                // Iterate over each raw material and append a new row to the table
                $.each(data, function (index, material) {
                    $('#rawMaterialTable').append('<tr>' +
                        '<td>' + material.name + '</td>' +
                        '<td>' + material.quantityAvailable + '</td>' +
                        '<td><input type="number" class="form-control quantity-input" id="' + material.name + '_quantity" name="' + material.name + '_quantity" placeholder="Enter quantity"></td>' +
                        '</tr>');
                });
            },
            error: function (error) {
                console.error('Error fetching raw materials:', error);
            }
        });
    }

    // Attach event listener to input fields for quantity
    $(document).on('input', '.quantity-input', function () {
        var assignedQuantity = parseInt($(this).val());
        var availableQuantity = parseInt($(this).closest('tr').find('td:eq(1)').text());

        if (assignedQuantity > availableQuantity) {
            alert('Assigned quantity cannot exceed available quantity.');
            // Reset the input field to the available quantity
            $(this).val(availableQuantity);
        }
    });
</script>

<div class="form-group row">
                            <label for="assigned_work" class="col-sm-2 col-form-label">DeadLine<span class="text-danger">*</span></label>
                            <div class="col-sm-8">
                                 <input name="deadLine"  class="form-control" type="date">
                            </div>
                        </div>
	  
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
                	'<td>' + assignedWork.email + '</td>' +
                    '<td>' + assignedWork.assignedWork + '</td>' +
                    
                    '<td>' + assignedWork.status + '</td>' +
                    '<td>' + assignedWork.deadline + '</td>' +
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
            	<th>Email</th>
                <th>Assigned Work</th>
                
                <th>Status</th>
                <th>Deadline</th>
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