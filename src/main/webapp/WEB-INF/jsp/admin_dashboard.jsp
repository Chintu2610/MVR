<%@ page import="java.util.Map" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="java.text.DecimalFormat" %>
<%@ page import="java.math.BigDecimal" %>

<%
HttpSession sdsession = request.getSession(true);
String name = (String) sdsession.getAttribute("name");
String username = (String) sdsession.getAttribute("name");
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
    <title>Admin Dashboard</title>
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
                                <li class="breadcrumb-item active">Dashboard</li>
                            </ul>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-6 col-sm-6 col-lg-6 col-xl-3">
                        <div class="card dash-widget">
                            <div class="card-body">
                                    <span class="dash-widget-icon"><i class="fa fa-users"></i></span>
                                    <div class="dash-widget-info">
                                        <h4><a href="service" style="text-decoration: none; color: inherit;">  
                                        <br><span>Services</span>
                                        </a></h4>
                                        
                                        
                                    </div>
                            </div>
                        </div>
                    </div>

                    <div class="col-md-6 col-sm-6 col-lg-6 col-xl-4">
                        <div class="card dash-widget">
                            <div class="card-body">
                               
                                    <span class="dash-widget-icon"><i class="fa fa-user"></i></span>
                                    <div class="dash-widget-info">
                                     
                                       <%--  <% int totalDeposits = DepositDAO.totalCount();%> --%>
                                        <h4><a href="users" style="text-decoration: none; color: inherit;"> <%-- <%= totalDeposits %> --%>
                                        <br><span> Users</span>
                                        </a></h4>
                                    </div>
                                
                            </div>
                        </div>
                    </div>

                    <div class="col-md-6 col-sm-6 col-lg-6 col-xl-4">
                        <div class="card dash-widget">
                            <div class="card-body">
                                
                                    <span class="dash-widget-icon"><i class="fa fa-bank"></i></span>
                                    <div class="dash-widget-info">
                                    
                                       <%--  <% int totalWithdrawals = WithdrawalDAO.totalCount(); %> --%>
                                        <h4><a href="payment" style="text-decoration: none; color: inherit;">  <%-- <%= totalWithdrawals %> --%>
                                      <br><span> Payments</span>
                                         </a></h4>
                                    </div>
                              
                            </div>
                        </div>
                    </div>
					</div>
					<div class="row">
                    <div class="col-md-6 col-sm-6 col-lg-6 col-xl-3">
                        <div class="card dash-widget">
                            <div class="card-body">
               
                                    <span class="dash-widget-icon"><i class="fa fa-share"></i></span>
                                    <div class="dash-widget-info">
                                      
                                   <%--      <%int referralCount = ReffertalDAO.ReferaltotalCount();%> --%>
                                        <h4><a href="referrals_user.jsp" style="text-decoration: none; color: inherit;"> <%-- <%= referralCount %> --%>
                                        <br><span>Jobs </span>
                                          </a></h4>
                                    </div>
                               
                            </div>
                        </div>
                    </div>
                    
                    <div class="col-md-6 col-sm-6 col-lg-6 col-xl-4">
                        <div class="card dash-widget">
                            <div class="card-body">
                               
                                    <span class="dash-widget-icon"><i class="fa fa-bell"></i></span>
                                    <div class="dash-widget-info">
                                      
                                     
                                        <h4><a href="notification" style="text-decoration: none; color: inherit;"> <%--  <%=ReferralBonus %> --%>
                                     <br><span> Notifications</span>
                                        </a></h4>
                                    </div>
                           
                            </div>
                        </div>
                    </div>
                </div>
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