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
<% 
    // Retrieve the serviceId from the request parameters
    String subserviceId = request.getParameter("subserviceId");
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
    <title>Sub Service ADD</title>
   
<script>
    
    function submitForm() {
        var form = document.getElementById('rawMaterialForm');
        var formData = new FormData(form);

        var xhr = new XMLHttpRequest();
        xhr.open('POST', '/trainingassigneeadd');
        xhr.onload = function() {
            if (xhr.status === 200) {
               
                window.location.reload();
            } else {
                console.error('Error adding ');
            }
        };
        xhr.send(formData);
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
                        </div>
                    </div>
                </div>



<form id="rawMaterialForm" >
<div id="add1" class="modal custom-modal fade" role="dialog">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Add Training Assignee</h5>
            </div>
            
           
            <div class="modal-body">
            
            
              
                
                <!-- <div class="col-md-12">
                    <div class="form-group">
                        <label class="col-form-label">user id <span class="text-danger">*</span></label>
                        <input name="userid" required class="form-control" type="text" ">
                    </div>
                </div> -->
                <div class="col-md-12">
    <div class="form-group">
        <label class="col-form-label">User <span class="text-danger">*</span></label>
        <select name="userid" required class="form-control">
            <option value="">Select User</option>
            <!-- Retrieve user IDs and names from the server-side endpoint -->
            <!-- Use AJAX or similar technique to fetch the data dynamically -->
            <!-- Example: -->
            <script>
                // Make an AJAX request to fetch user IDs and names
                fetch('/userDropdown')
                    .then(response => response.json())
                    .then(data => {
                        // Populate the dropdown with retrieved user IDs and names
                        data.forEach(userIdAndName => {
                            const [userId, userName] = userIdAndName.split('-').map(str => str.trim());
                            const option = document.createElement('option');
                            option.value = userId;
                            option.textContent = userName;
                            document.querySelector('select[name="userid"]').appendChild(option);
                        });
                    })
                    .catch(error => console.error('Error fetching user dropdown:', error));
            </script>
        </select>
    </div>
</div>
                
                
            <!--     <div class="col-md-12">
                    <div class="form-group">
                        <label class="col-form-label">trainingid <span class="text-danger">*</span></label>
                        <input name="trainingid" required class="form-control" type="text">
                    </div>
                </div> -->
                <div class="col-md-12">
    <div class="form-group">
        <label class="col-form-label">Training ID <span class="text-danger">*</span></label>
        <select name="trainingid" required class="form-control">
            <option value="">Select TrainingID</option>
            <!-- Retrieve user IDs and names from the server-side endpoint -->
            <!-- Use AJAX or similar technique to fetch the data dynamically -->
            <!-- Example: -->
            <script>
                // Make an AJAX request to fetch user IDs and names
                fetch('/trainingDropdown')
                    .then(response => response.json())
                    .then(data => {
                        // Populate the dropdown with retrieved user IDs and names
                        data.forEach(userIdAndName => {
                            const [trainingid, trainingname] = userIdAndName.split('-').map(str => str.trim());
                            const option = document.createElement('option');
                            option.value = trainingid;
                            option.textContent = trainingname;
                            document.querySelector('select[name="trainingid"]').appendChild(option);
                        });
                    })
                    .catch(error => console.error('Error fetching user dropdown:', error));
            </script>
        </select>
    </div>
</div>
                
                
                
                
                
                  <div class="col-md-12">
                    <div class="form-group">
                        <label class="col-form-label">status <span class="text-danger">*</span></label>
                        <input name="trainingassignestatus" required class="form-control" type="text">
                    </div>
                </div>
                
                <div class="submit-section">
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
 <script src="js/jquery.slimscroll.min.js"></script> 

    </body>
</html>