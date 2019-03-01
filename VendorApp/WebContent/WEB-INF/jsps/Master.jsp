<!DOCTYPE html>
<html>
<head>
<style>
table {
    border-collapse: collapse;
    width: 100%;
}

th, td {
    text-align: left;
    padding: 8px;
}

tr:nth-child(even){background-color: #f2f2f2}

th {
    background-color: #4CAF50;
    color: blue;
}
</style>
<style>
.container {
    overflow: hidden;
    background-color: #333;
    font-family: Arial;
}

.container a {
    float: left;
    font-size: 16px;
    color: White;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}

.dropdown {
    float: left;
    overflow: hidden;
}

.dropdown .dropbtn {
    font-size: 16px;    
    border: none;
    outline: none;
    color: white;
    padding: 14px 16px;
    background-color: inherit;
}

.container a:hover, .dropdown:hover .dropbtn {
    background-color: red;
}

.dropdown-content {
    display: none;
    position: absolute;
    background-color: #f9f9f9;
    min-width: 160px;
    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
    z-index: 1;
}

.dropdown-content a {
    float: none;
    color: black;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
    text-align: left;
}

.dropdown-content a:hover {
    background-color: #ddd;
}

.dropdown:hover .dropdown-content {
    display: block;
}
</style>
</head>
<body>
<!-- <img src="../images/banner.jpg" width="1050" height="100"> -->
<div class="container">
  <a href="#home">Home</a>
 <!--  <a href="#news">News</a> -->
  <div class="dropdown">
    <button class="dropbtn">Location</button>
    <div class="dropdown-content">
      <a href="locReg">Register</a>
      <a href="viewAllLocs">View Data</a>
    </div>
  </div> 
     <div class="dropdown">
    <button class="dropbtn">Vendor</button>
    <div class="dropdown-content">
      <a href="venReg">Register</a>
      <a href="viewAllVens">View Data</a>
    </div>
  </div> 
   <div class="dropdown">
    <button class="dropbtn">Customer</button>
    <div class="dropdown-content">
      <a href="showCust">Register</a>
      <a href="viewAllCusts">View Data</a>
    </div>
  </div> 
   <div class="dropdown">
    <button class="dropbtn">Document</button>
    <div class="dropdown-content">
     <a href="showDocs">Upload</a>
     </div>
  </div> 
  <div class="dropdown">
    <button class="dropbtn">Report</button>
    <div class="dropdown-content">
      <a href="ViewLocReport">Pie-chart</a>
      <a href="ViewLocReport">Bar-Chart</a>
    </div>
  </div> 
  <div class="dropdown">
    <button class="dropbtn">Email</button>
    <div class="dropdown-content">
     <a href="showMail">Email</a>
    </div>
  </div> 
  <div class="dropdown">
			<button class="dropbtn">User</button>
			<div class="dropdown-content">
				<a href="userReg">UserReg</a> 
				<a href="showLogin">Login</a> 
				<a href="logoutUser">Logout</a>
					<a href="viewUsers">View All Users</a>
				</div>
		</div>
   <a href="logoutUser">Logout</a>
</div>
<div align="right">Welcome to User:${userName}</div>
</body>
</html>
