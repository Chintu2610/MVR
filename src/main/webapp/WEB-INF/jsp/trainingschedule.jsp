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
		<script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/2.5.1/jspdf.umd.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf-autotable/3.5.13/jspdf.plugin.autotable.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/FileSaver.js/2.0.5/FileSaver.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/xlsx/0.16.9/xlsx.full.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/TableExport/5.2.0/js/tableexport.min.js"></script>
    <!-- jQuery -->
    <script src="js/jquery-3.2.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    
    <title>Training Assignee</title>
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
        
        $(document).ready(function () {
            showAllUserDetails();
        });

        function showAllUserDetails() {
            // AJAX request to fetch user details
            $.ajax({
                type: 'GET',
                url: 'TrainingScheduleDetails',
                dataType: 'json',
                success: function (data) {
                    $('#userTable tbody').empty();

                    $.each(data, function (index, user) {

                                $.ajax({
                                    type: 'GET',
                                    url: '/getTrainername',
                                    data: { trainingid: user.trainingid },
                                    success: function (trainingname) {
                                        var row = '<tr>' +
                                            '<td style="width: 100px;">' + user.trainingscheduleid + '</td>' +
                                            '<td style="width: 150px;">' + trainingname + '</td>' +
                                            '<td style="width: 150px;">' + user.startDate + '</td>' +
                                            '<td style="width: 150px;">' + user.endDate + '</td>' +
                                            '<td style="width: 250px;">' + user.timings + '</td>' +
                                            '<td style="width: 150px;">' + user.description + '</td>';


                                        row += '<td style="width:250px;">' +
                                            '<button class="btn btn-primary btn-sm editBtn">Edit</button>&nbsp;&nbsp;' +
                                            '<button class="btn btn-danger btn-sm deleteBtn">Delete</button>' +
                                            '</td>' +
                                            '</tr>';

                                        var $row = $(row);
                                        $row.find('.editBtn').click(function () {
                                            editRawMaterial(user.trainingscheduleid, user.trainingid, user.startDate, user.endDate, user.timings, user.description);
                                        });
                                        $row.find('.deleteBtn').click(function () {
                                            deleteRawMaterial(user.trainingscheduleid);
                                        });

                                        $('#userTable tbody').append($row);
                                    },
                                   
                            error: function (error) {
                                console.error('Error fetching username:', error);
                            }
                        });
                    });
                },
                error: function (error) {
                    console.error('Error fetching user details:', error);
                }
            });
        }


       

        function editRawMaterial(trainingscheduleid,trainingid,startDate,endDate,timings,description) {
            // Edit functionality
            $('#edittrainingscheduleid').val(trainingscheduleid);
                    $('#edittrainingid').val(trainingid);
                    $('#editstartDate').val(startDate);
                    $('#editendDate').val(endDate);
                    $('#edittimings').val(timings);
                    $('#editdescription').val(description);
                    
                    // Show the edit modal
                    $('#editModal').modal('show');
        }

        function deleteRawMaterial(ID) {
            // Delete functionality
         $.ajax({
                        type: 'POST',
                        url: '/TrainingScheduledelete',
                        data: { trainingscheduleid: ID },
                        success: function(response) {
                            // Handle success response
                        	// alert("RawMaterial Deleted Successfully");
                        	 window.location.reload();
                        },
                        error: function(xhr, status, error) {
                            // Handle error response
                            alert('Error: ' + error);
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
								<h3 class="page-title">Training Schedule</h3>
								<ul class="breadcrumb">
									<li class="breadcrumb-item"><a href="admin_dashboard">Dashboard</a></li>
									<li class="breadcrumb-item active">Training Schedule</li>
								</ul>
							</div>
							<div class="col-auto float-right ml-auto">
							
							<a href="#" class="Addbutton" data-toggle="modal" data-target="#add1"><i class="fa fa-plus"></i> Add </a>

							</div>
                    </div>
                </div>
            </div>
             <!-- Main Headings with Toggleable Content -->
      <div class="col-auto float-right ml-auto">

			         </div>
	        <table id="userTable" class="table-striped custom-table mb-0 datatable" style="width: 800px;">
                        <thead>
                            <tr>


                          <!--   <th>ID</th> -->
                            <th style="width: 100px;">ID</th>
					        <th style="width: 150px;">Training Name</th>
					        <th style="width: 150px;">startDate</th>
					        <th style="width: 150px;" >endDate</th>
					         <th style="width: 250px;">timings</th>
					        <th style="width: 150px;" >description</th>
					        <th  style="width: 250px; ">Action</th>
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
	<jsp:include page="trainingschedule_add.jsp" />
	<jsp:include page="trainingschedule_edit.jsp" /> 
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