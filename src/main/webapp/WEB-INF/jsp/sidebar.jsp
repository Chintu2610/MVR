<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
    aside {
        width: 230px;
        background-color: #2c3e50;
        margin-top: 50px;
        padding: 20px;
        height: 100vh;
        position: fixed;
        box-sizing: border-box; /* Include padding and borders in the total height */
    }

    .sublist {
        display: none;
        margin-left: 10px;
    }

    .sublist li {
        list-style-type: none;
        margin-bottom: 5px;
    }

    .toggle {
        cursor: pointer;
        text-decoration: underline;
        color: #000;
    }
</style>
</head>
<body>
<aside>
    <ul class="list-group">
        
       <!--  <li class="list-group-item"><a href="dashboard">Dashboard</a></li> -->
         <li class="list-group-item"><a href="service">Service</a></li>
          <li class="list-group-item"><a href="admin_dashboard">Admin Dashboard</a></li>
       <!--  <li class="list-group-item toggle" onclick="toggleSublist('sublist-activation')">Services</li>
        <ul class="sublist" id="sublist-activation">
            <li class="list-group-item"><a href="SendMoney">Tailoring</a></li> 
            <li class="list-group-item"><a href="SendMoney">Papad</a></li>            
        </ul> -->
        
        <li class="list-group-item"><a href="payment">Payments</a></li>
        
        <li class="list-group-item"><a href="rawmaterial">Raw Materials</a></li>

         <li class="list-group-item"><a href="assign_work">Assign Work</a></li>
         
         <li class="list-group-item"><a href="works">All available Works</a></li>
         
         <li class="list-group-item"><a href="trainingassignee">Training Assignee</a></li>
        
         <li class="list-group-item"><a href="training">Training </a></li>
    
    	 <li class="list-group-item"><a href="users">User Details </a></li>
    </ul>
</aside>

<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<script>
    $(document).ready(function() {
        // Add click event to toggle sublist
        $('.toggle').click(function() {
            $(this).next('.sublist').slideToggle();
        });

        // Prevent sublist items from closing the sublist
        $('.sublist li').click(function(event) {
            event.stopPropagation();
        });
    });
</script>

</body>
</html>