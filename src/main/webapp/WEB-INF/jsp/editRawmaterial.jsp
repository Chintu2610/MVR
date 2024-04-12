
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
    <%
    // Getting the username from the session
    String username = (String)session.getAttribute("username");
%>
<!DOCTYPE html>
<html>
<head>

<script>
        $(document).ready(function () {
            // Handle form submission using AJAX
            $('#editForm').submit(function (event) {
                event.preventDefault(); // Prevent default form submission
                var formData = $(this).serialize(); // Serialize form data
                $.ajax({
                    type: 'POST',
                    url: $(this).attr('action'), // Get form action attribute
                    data: formData, // Send serialized form data
                    success: function (response) {
                        // Handle success response
                        // For example, display a success message or redirect
                    },
                    error: function (xhr, status, error) {
                        // Handle error response
                        console.error('Error:', error);
                    }
                });
            });
        });
    </script>

<style type="text/css">
.network-form-group {
    width: 100%; /* Set the overall width */
    margin-right: 30px; /* Increase margin on the right side */
    margin-left: 30px; /* Increase margin on the left side */
}
</style>
    <meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=0">
<meta name="description" content="xm-s1 Admin Template">
<meta name="keywords"
	content="admin, Cryptocurrency, account management">
<meta name="author" content="Weblabs - Admin Template">
<meta name="robots" content="noindex, nofollow">
    <title>Raw Material</title>

    <!-- Favicon -->
   <!--  <link rel="shortcut icon" type="image/x-icon" href="assets/favicon.png"> -->
 <link rel="shortcut icon" type="image/x-icon" href="assets/LOGOTrade.jpg">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css">

    <!-- Fontawesome CSS -->
    <link rel="stylesheet" href="css/font-awesome.min.css">

    <!-- Lineawesome CSS -->
    <link rel="stylesheet" href="css/line-awesome.min.css">

    <!-- Select2 CSS -->
    <link rel="stylesheet" href="css/select2.min.css">

    <!-- Datetimepicker CSS -->
    <link rel="stylesheet" href="css/bootstrap-datetimepicker.min.css">

    <!-- Main CSS -->
    <link rel="stylesheet" href="css/style.css">
    
    <!-- Table styles CSS -->
    <link rel="stylesheet" href="css/tstyles.css">  
    <title>Raw Material</title>
</head>
<body>
<div id="editModal" class="modal custom-modal fade" role="dialog">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <form id="editForm" action="rawmaterialedit" method="POST">
                <div class="modal-header">
                    <h5 class="modal-title">Edit Raw Material</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label class="col-form-label">ID <span class="text-danger">*</span></label>
                        <input id="editrawMaterialID" name="rawMaterialID" required class="form-control" type="text">
                    </div>
                    <div class="form-group">
                        <label class="col-form-label">Name <span class="text-danger">*</span></label>
                        <input id="editname" name="name" required class="form-control" type="text">
                    </div>
                    <div class="form-group">
                        <label class="col-form-label">Description</label>
                        <textarea id="editDescription" name="description" class="form-control"></textarea>
                    </div>
                    <div class="form-group">
                        <label class="col-form-label">Supplier Name</label>
                        <input id="editsupplierName" name="supplierName" class="form-control" type="text">
                    </div>
                    <div class="form-group">
                        <label class="col-form-label">Unit Price</label>
                        <input id="editunitPrice" name="unitPrice" class="form-control" type="number">
                    </div>
                    <div class="form-group">
                        <label class="col-form-label">Quantity Available</label>
                        <input id="editquantityAvailable" name="quantityAvailable" class="form-control" type="number">
                    </div>
                    <div class="form-group">
                        <label class="col-form-label">Storage Conditions</label>
                        <textarea id="editstorageConditions" name="storageConditions" class="form-control"></textarea>
                    </div>
                    <div class="form-group">
                        <label class="col-form-label">Expiry Date</label>
                        <input id="editexpiryDate" name="expiryDate" class="form-control" type="date">
                    </div>
                    <div class="form-group">
                        <label class="col-form-label">Date Added</label>
                        <input id="editdateAdded" name="dateAdded" class="form-control" type="date">
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-primary">Submit</button>
                </div>
            </form>
        </div>
    </div>
</div>

