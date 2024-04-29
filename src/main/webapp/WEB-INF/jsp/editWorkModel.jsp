
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
    <%
    // Getting the username from the session
    String username = (String)session.getAttribute("username");
%>
<!DOCTYPE html>
<html>
<head>
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
    <title>Work Add</title>

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
    <title>Work Add</title>
</head>
<body>
<form id="workForm" action="/updateWork" method="POST">
<div id="editModal" class="modal custom-modal fade" role="dialog">
 <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
        
            <div class="modal-header">
                <h5 class="modal-title">Edit Work</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            
            <div class="modal-body">
          <div class="form-group">
            <label class="col-form-label">ID <span class="text-danger">*</span></label>
            <input id="editWorkId" name="workid" required class="form-control" type="text" disabled>
        </div>
        <div class="form-group">
            <label class="col-form-label">Name <span class="text-danger">*</span></label>
            <input id="editname" name="workname" required class="form-control" type="text">
        </div>
</div>

 <div class="submit-section">
    <button type="submit" class="btn btn-primary submit-btn" >Submit</button>
  </div>
  </div>
        </div>
    </div>
</form>
