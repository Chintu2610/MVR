<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <!-- Favicon -->
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

    <!-- jQuery library -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<h1>hello world</h1>
	

            <form id="editForm" action="serviceedit" method="POST">
                <div id="editModal"  class="modal-header">
                    <h5 class="modal-title">Edit Service</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label class="col-form-label">ID <span class="text-danger">*</span></label>
                        <input id="editservice_id" name="service_id" required class="form-control" type="text">
                    </div>
                    <div class="form-group">
                        <label class="col-form-label">Upload Image <span class="text-danger">*</span></label>
                        <input id="editimage_url" name="file" required class="form-control" type="file">
                    </div>
                    <div class="form-group">
                        <label class="col-form-label">service_name</label>
                        <textarea id="editservice_name" name="service_name" class="form-control"></textarea>
                    </div>
                    <div class="form-group">
                        <label class="col-form-label">url</label>
                        <input id="editurl" name="url" class="form-control" type="text">
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-primary">Submit</button>
                </div>
            </form>
     

</body>
</html>