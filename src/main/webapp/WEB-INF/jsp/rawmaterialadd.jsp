<%@ page import="java.util.Map" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="java.text.DecimalFormat" %>
<%@ page import="java.math.BigDecimal" %>

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
    <script src="js/jquery-3.2.1.min.js"></script>
    <title>Raw Materials ADD</title>
   
<script>
    function submitForm() {
        var form = document.getElementById('rawMaterialForm');
        var formData = new FormData(form);
        var rawmaterial = {};
        formData.forEach(function(value, key) {
            rawmaterial[key] = value;
        });
        var jsonRawMaterial = JSON.stringify(rawmaterial);

        var xhr = new XMLHttpRequest();
        xhr.open('POST', '/rawmaterialadd');
        xhr.setRequestHeader('Content-Type', 'application/json');
        xhr.onload = function() {
            if (xhr.status === 200) {
                // Handle success
                alert('Raw material added successfully');
                window.location.reload();
            } else {
                // Handle error
            	alert('Error: ');
            }
        };
        xhr.send(jsonRawMaterial);
    }
</script>
  
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
                                <%-- Welcome <%= username %>! --%>
                            </div>
                          <!--   <ul class="breadcrumb">
                                <li class="breadcrumb-item active">Dashboard</li>
                            </ul> -->
                        </div>
                    </div>
                </div>



<form id="rawMaterialForm">
<div id="add1" class="modal custom-modal fade" role="dialog">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Add Raw Material</h5>
               <!--  <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button> -->
            </div>
            <div class="modal-body">
                <div class="col-md-12">
                    <div class="form-group">
                        <label class="col-form-label">Name <span class="text-danger">*</span></label>
                        <input name="name" required class="form-control" type="text">
                    </div>
                </div>
                <div class="col-md-12">
                    <div class="form-group">
                        <label class="col-form-label">Description <span class="text-danger">*</span></label>
                        <input name="description" required class="form-control" type="text">
                    </div>
                </div>
                <div class="col-md-12">
                    <div class="form-group">
                        <label class="col-form-label">Supplier Name <span class="text-danger">*</span></label>
                        <input name="supplierName" required class="form-control" type="text">
                    </div>
                </div>
                
             
                <div class="col-md-12">
                    <div class="form-group">
                        <label class="col-form-label">Unit Price <span class="text-danger">*</span></label>
                        <input name="unitPrice" required class="form-control" type="text">
                    </div>
                </div>
                <div class="col-md-12">
                    <div class="form-group">
                        <label class="col-form-label">Quantity Available <span class="text-danger">*</span></label>
                        <input name="quantityAvailable" required class="form-control" type="text">
                    </div>
                </div>
                <div class="col-md-12">
                    <div class="form-group">
                        <label class="col-form-label">Storage Conditions <span class="text-danger">*</span></label>
                        <input name="storageConditions" required class="form-control" type="text">
                    </div>
                </div>
                <div class="col-md-12">
                    <div class="form-group">
                        <label class="col-form-label">Expiry Date <span class="text-danger">*</span></label>
                        <input name="expiryDate"  class="form-control" type="date">
                    </div>
                </div>
                <div class="col-md-12">
                    <div class="form-group">
                        <label class="col-form-label">Date Added <span class="text-danger">*</span></label>
                        <input name="dateAdded"  class="form-control" type="date">
                    </div>
                </div>
                <div class="submit-section">
                  <!--   <button type="submit" class="btn btn-primary submit-btn">Submit</button> -->
                  <button type="button" onclick="submitForm()">Submit</button>
                </div>
            </div>
        </div>
    </div></div>
</form>

            </div>
        </div>
</div>
</div>
<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/popper.min.js"></script>
<!-- <script src="js/bootstrap.min.js"></script> -->
 <script src="js/jquery.slimscroll.min.js"></script> 

    </body>
</html>