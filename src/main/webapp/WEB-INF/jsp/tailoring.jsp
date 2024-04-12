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
   <style >
      .video {
    margin-right: 40px; /* Adjust the value as needed */
}
    .video:last-child {
        margin-right: 10;
    }
   </style> 
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
                        <ul class="breadcrumb">
                            <li class="breadcrumb-item active">Services-Tailoring</li>
                        </ul>
                    </div>
                </div>
            </div>
             <!-- Main Headings with Toggleable Content -->


<h1>Welcome to the World of Tailoring</h1>

<form id="videoForm" action="user_email" method="get">


    <!-- <label>day 1  video of Tailoring-1</label> -->
<div class="row">
        <div class="video">
            <a href="https://www.youtube.com/embed/XjOdk8VZmtE">day 1 video of Tailoring</a>
            <input type="checkbox" name="video" value="https://www.youtube.com/embed/XjOdk8VZmtE"><br>
            <iframe width="200" height="100" src="https://www.youtube.com/embed/XjOdk8VZmtE" frameborder="0" allowfullscreen></iframe>
        </div>

        <div class="video">
            <a href="https://www.youtube.com/watch?v=ZJZ36zuejPQ">day 2 video of Tailoring</a>
            <input type="checkbox" name="video" value="https://www.youtube.com/watch?v=ZJZ36zuejPQ"><br>
            <iframe width="200" height="100" src="https://www.youtube.com/embed/XjOdk8VZmtE" frameborder="0" allowfullscreen></iframe>
        </div>

        <div class="video">
            <a href="https://www.youtube.com/embed/XjOdk8VZmtE">day 3 video of Tailoring</a>
            <input type="checkbox" name="video" value="https://www.youtube.com/embed/XjOdk8VZmtE"><br>
            <iframe width="200" height="100" src="https://www.youtube.com/embed/XjOdk8VZmtE" frameborder="0" allowfullscreen></iframe>
        </div>
   
    
         <div class="video">
         <a href="https://www.youtube.com/embed/XjOdk8VZmtE">day 4  video of Tailoring</a>
     <input type="checkbox" name="video" value="https://www.youtube.com/embed/XjOdk8VZmtE"><br>
  <iframe width="200" height="100" src="https://www.youtube.com/embed/XjOdk8VZmtE" frameborder="0" allowfullscreen></iframe><br><br>
      </div> </div>
      
     <div class="row">
        <div class="video"> 
         <a href="https://www.youtube.com/embed/XjOdk8VZmtE">day 5  video of Tailoring</a>
     <input type="checkbox" name="video" value="https://www.youtube.com/embed/XjOdk8VZmtE"><br>
    <iframe width="200" height="100" src="https://www.youtube.com/embed/XjOdk8VZmtE" frameborder="0" allowfullscreen></iframe><br><br>
 </div> </div>
   
   <div class="row justify-content-center">
    <div class="col-auto">
     <input type="button" class="btn btn-primary"  value="Select All" onclick="toggleCheck()">
        <input type="submit" class="btn btn-primary" value="Forward" onclick="submitForm()">
    </div>
</div>
</form>

<!-- JavaScript to handle form submission -->
<script>
    function submitForm() {
        var form = document.getElementById('videoForm');
        var selectedVideos = [];
        
        // Get all checked checkboxes with name 'video'
        var checkboxes = document.querySelectorAll('input[name="video"]:checked');
        
        // Loop through each checked checkbox to get its value (YouTube link)
        checkboxes.forEach(function(checkbox) {
            selectedVideos.push(checkbox.value); // Add the value (YouTube link) to the array
        });

        // Add the selected videos array as a hidden input field to the form
        var videosInput = document.createElement('input');
        videosInput.setAttribute('type', 'hidden');
        videosInput.setAttribute('name', 'selectedVideos');
        videosInput.setAttribute('value', JSON.stringify(selectedVideos));
        form.appendChild(videosInput);

        // Now the form is ready with the selected videos, submit it
        form.submit();
    }
</script>

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
        checkButton.value = 'Select All';
    } else {
        for (var i = 0; i < checkboxes.length; i++) {
            checkboxes[i].checked = true;
        }
        checkButton.value = 'Deselect All';
    }
}
</script>
        
        </div>
    </div>
</div>
<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/popper.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.slimscroll.min.js"></script>

</body>
</html>
