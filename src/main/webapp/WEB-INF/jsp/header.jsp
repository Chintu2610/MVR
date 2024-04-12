<%@ page import="java.util.List"%>
<%@ page import="javax.servlet.http.HttpServletRequest" %>



<%
HttpSession sdsession = request.getSession(true);

// Retrieve the username attribute from the session
String name = (String) sdsession.getAttribute("name");
String username = (String) sdsession.getAttribute("email");
String roleIDString = (String) sdsession.getAttribute("RoleID");
// Check if the user is logged in or redirect to the login page
/* if (username == null) {
response.sendRedirect("login"); // Change "login.jsp" to your actual login page
} else { */
  

%>


<!DOCTYPE html>


<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Your Page Title</title>
    <!-- Add your CSS and other meta tags here -->
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/M.css">
    
</head>
<body>
    <div class="header">
     
        <div class="header-left">
    
          <img src="assets/mvrlogo.jpeg" width="110" height="58" alt="">
            
            <%-- <%} %> --%>
        </div>
       
        <div class="page-title-box">
            <h3>MVR GROUP OF SMALL SCALE UNITS</h3>
        </div>
        
        <a id="mobile_btn" class="mobile_btn" href="#sidebar"><i class="fa fa-bars"></i></a>

        <!-- Header Menu -->
        <ul class="nav user-menu">

            
         
           
            <li class="nav-item dropdown has-arrow main-drop">
                <a href="#" class="dropdown-toggle nav-link" data-toggle="dropdown"> 
                   <div class="user-img">
                            <img src="assets/user.jpg" alt="User Picture">
                              <span class="status online"></span>
                   </div>
                   </a>

               
                <div class="dropdown-menu">
                  
                <a class="dropdown-item" href="profile">My Profile</a>
                    <a class="dropdown-item" href="logout">Logout</a>
                </div>
            </li>
            <!-- /User Profile -->
        </ul>
        <!-- /Header Menu -->

        <!-- Mobile Menu -->
        <div class="dropdown mobile-user-menu">
            <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><i class="fa fa-ellipsis-v"></i></a>
            <div class="dropdown-menu dropdown-menu-right">
               <a class="dropdown-item" href="profile-list-emp.jsp">My Profile</a> 
                <!-- <a class="dropdown-item" href="settings.jsp">Settings</a> -->
                <a class="dropdown-item" href="login.jsp">Logout</a>
            </div>
        </div>
        <!-- /Mobile Menu -->
    </div>

    <!-- Add your content here -->

    <!-- Add your JavaScript includes and scripts here -->
     <script src="js/jquery-3.2.1.min.js"></script>

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

    <!-- Custom JS -->
    <!-- <script src="js/app.js"></script> -->
</body>

</html>