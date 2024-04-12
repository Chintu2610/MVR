
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>PayZigo - Your Digital Financial Companion</title>

    <!-- Bootstrap CSS CDN -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f0f0f0;
            display: flex;
        }

        main {
            flex: 1;
            overflow-y: auto; /* Enable vertical scrolling */
        }

        section {
            display: flex;
            justify-content: space-around;
            flex-wrap: wrap;
            padding: 20px;
        }

        .feature {
            width: 30%;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            margin: 10px;
            padding: 20px;
            box-sizing: border-box;
        }

        .feature img {
            max-width: 100%;
            border-radius: 4px;
        }

        footer {
            background-color: #2c3e50;
            color: #fff;
            text-align: center;
            padding: 10px;
            position: fixed;
            bottom: 0;
            width: 100%;
        }
    </style>
</head>

<body>
	 <!-- Main Wrapper -->
	  <%@ include file="sidebar.jsp" %> 
    <div class="main-wrapper">
    	
        
         <%@ include file="header.jsp" %> 
         <div class="page-wrapper">
         <div class="content container-fluid">
        <section>
            <!-- Your existing content here -->
            <div class="feature">

            <h1>Welcome </h1>
                <img src="electricity_image.jpg" alt="Electricity">

	
                <h2>Electricity</h2>
                <p>With PayZigo, easily pay electricity bills directly to the state electricity board.</p>
                <a href="#">More Info</a>
            </div>
            <!-- Repeat for other features -->
        </section>
    
    	
    </div>
    	<%-- <%@ include file="footer.jsp" %> --%>
    </div>
    
    </div>
</body>
</html>