<%@ page import="java.util.Map" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="java.text.DecimalFormat" %>
<%@ page import="java.math.BigDecimal" %>

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
    <title>Services</title>
    
</head>
<body>
<div class="main-wrapper">
    <%@ include file="header.jsp" %>
    <%@ include file="sidebar.jsp" %>
    <!-- Page Wrapper -->
  <div class="page-wrapper" style="background-image: '/art.jpg'">

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
                        <ul class="breadcrumb">
                            <li class="breadcrumb-item active">Services-Painting</li>
                        </ul>
                    </div>
                </div>
            </div>
             <!-- Main Headings with Toggleable Content -->


<h1>Welcome to the World of Painting</h1>

<form id="videoForm" action="user.jsp" method="post">
 <input type="button" value="Check All" onclick="toggleCheck()"><br>
    <label><a href="https://www.youtube.com/embed/XjOdk8VZmtE">Painting-1</a></label>
    <input type="checkbox" name="video" value="https://www.youtube.com/embed/XjOdk8VZmtE"><br>
    <label><a href="https://www.youtube.com/embed/XjOdk8VZmtETailoring-2">Painting-2</a></label>
    <input type="checkbox" name="video" value="https://www.youtube.com/embed/XjOdk8VZmtETailoring-2"><br>
    <label><a href="https://www.youtube.com/embed/XjOdk8VZmtETailoring-3">Painting-3</a></label>
    <input type="checkbox" name="video" value="https://www.youtube.com/embed/XjOdk8VZmtETailoring-3"><br>
    <label><a href="https://www.youtube.com/embed/XjOdk8VZmtETailoring-4">Painting-4</a></label>
    <input type="checkbox" name="video" value="https://www.youtube.com/embed/XjOdk8VZmtETailoring-4"><br><br>
   
    <input type="submit" value="Forward">
</form>

<script>
function toggleCheck() {
    var checkboxes = document.getElementsByName('video');
    var checkButton = document.querySelector('input[type="button"]');
    var allChecked = true;
    
    for (var i = 0; i < checkboxes.length; i++) {
        if (!checkboxes[i].checked) {
            allChecked = false;
            break;
        }
    }
    
    if (allChecked) {
        for (var i = 0; i < checkboxes.length; i++) {
            checkboxes[i].checked = false;
        }
        checkButton.value = 'Check All';
    } else {
        for (var i = 0; i < checkboxes.length; i++) {
            checkboxes[i].checked = true;
        }
        checkButton.value = 'Uncheck All';
    }
}
</script>





         
        </div>
    </div>
</div>
<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/popper.min.js"></script>
<!-- <script src="js/bootstrap.min.js"></script> -->
 <script src="js/jquery.slimscroll.min.js"></script> 

</body>
</html>
