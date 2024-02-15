
<%@page import="com.dao.EducationDao"%>
<%@page import="com.pojo.EducationPojo"%>
<%@page import="com.dao.ProjectDao"%>
<%@page import="com.dao.MessageDao"%>
<%
String value = (String) session.getAttribute("login");
if (value == null) {
	response.sendRedirect("login.jsp");
	return;
}
%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">


<title>find jobs cards - Bootdey.com</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
<style type="text/css">
body {
	margin-top: 20px;
}

.shadow {
	box-shadow: 0 0 3px rgb(53 64 78/ 20%) !important;
}

.rounded {
	border-radius: 5px !important;
}

.bg-light {
	background-color: #f7f8fa !important;
}

.bg-primary, .btn-primary, .btn-outline-primary:hover,
	.btn-outline-primary:focus, .btn-outline-primary:active,
	.btn-outline-primary.active, .btn-outline-primary.focus,
	.btn-outline-primary:not(:disabled):not(.disabled):active,
	.badge-primary, .nav-pills .nav-link.active, .pagination .active a,
	.custom-control-input:checked ~.custom-control-label:before, #preloader #status .spinner>div,
	.social-icon li a:hover, .back-to-top:hover, .back-to-home a, ::selection,
	#topnav .navbar-toggle.open span:hover, .owl-theme .owl-dots .owl-dot.active span,
	.owl-theme .owl-dots.clickable .owl-dot:hover span, .watch-video a .play-icon-circle,
	.sidebar .widget .tagcloud>a:hover, .flatpickr-day.selected,
	.flatpickr-day.selected:hover, .tns-nav button.tns-nav-active,
	.form-check-input.form-check-input:checked {
	background-color: #6dc77a !important;
}

.badge {
	padding: 5px 8px;
	border-radius: 3px;
	letter-spacing: 0.5px;
	font-size: 12px;
}

.btn-primary, .btn-outline-primary:hover, .btn-outline-primary:focus,
	.btn-outline-primary:active, .btn-outline-primary.active,
	.btn-outline-primary.focus, .btn-outline-primary:not(:disabled):not(.disabled):active
	{
	box-shadow: 0 3px 7px rgb(109 199 122/ 50%) !important;
}

.btn-primary, .btn-outline-primary, .btn-outline-primary:hover,
	.btn-outline-primary:focus, .btn-outline-primary:active,
	.btn-outline-primary.active, .btn-outline-primary.focus,
	.btn-outline-primary:not(:disabled):not(.disabled):active,
	.bg-soft-primary .border, .alert-primary, .alert-outline-primary,
	.badge-outline-primary, .nav-pills .nav-link.active, .pagination .active a,
	.form-group .form-control:focus, .form-group .form-control.active,
	.custom-control-input:checked ~.custom-control-label:before,
	.custom-control-input:focus ~.custom-control-label::before,
	.form-control:focus, .social-icon li a:hover, #topnav .has-submenu.active.active .menu-arrow,
	#topnav.scroll .navigation-menu>li:hover>.menu-arrow, #topnav.scroll .navigation-menu>li.active>.menu-arrow,
	#topnav .navigation-menu>li:hover>.menu-arrow, .flatpickr-day.selected,
	.flatpickr-day.selected:hover, .form-check-input:focus,
	.form-check-input.form-check-input:checked, .container-filter li.active,
	.container-filter li:hover {
	border-color: #6dc77a !important;
}

.bg-primary, .btn-primary, .btn-outline-primary:hover,
	.btn-outline-primary:focus, .btn-outline-primary:active,
	.btn-outline-primary.active, .btn-outline-primary.focus,
	.btn-outline-primary:not(:disabled):not(.disabled):active,
	.badge-primary, .nav-pills .nav-link.active, .pagination .active a,
	.custom-control-input:checked ~.custom-control-label:before, #preloader #status .spinner>div,
	.social-icon li a:hover, .back-to-top:hover, .back-to-home a, ::selection,
	#topnav .navbar-toggle.open span:hover, .owl-theme .owl-dots .owl-dot.active span,
	.owl-theme .owl-dots.clickable .owl-dot:hover span, .watch-video a .play-icon-circle,
	.sidebar .widget .tagcloud>a:hover, .flatpickr-day.selected,
	.flatpickr-day.selected:hover, .tns-nav button.tns-nav-active,
	.form-check-input.form-check-input:checked {
	background-color: #6dc77a !important;
}

.btn {
	padding: 8px 20px;
	outline: none;
	text-decoration: none;
	font-size: 16px;
	letter-spacing: 0.5px;
	transition: all 0.3s;
	font-weight: 600;
	border-radius: 5px;
}

.btn-primary {
	background-color: #6dc77a !important;
	border: 1px solid #6dc77a !important;
	color: #fff !important;
	box-shadow: 0 3px 7px rgb(109 199 122/ 50%);
}

a {
	text-decoration: none;
}

 {box-sizing: border-box;}

/* Button used to open the contact form - fixed at the bottom of the page */
.open-button {
  
  background-color: #555;
  color: white;
  padding: 12px 20px;
  border: none;
  cursor: pointer;
  opacity: 0.8;
  bottom: 30px;
  margin-right: auto;
  margin-left: auot;
  margin-bottom: 30px;
  margin-top:10px; 
}

/* The popup form - hidden by default */
.form-popup {
  display: none;
  position: fixed;
  bottom: 0;
  right: 15px;
  border: 3px solid #f1f1f1;
  z-index: 9;
}

/* Add styles to the form container */
.form-container {
  max-width: 300px;
  padding: 10px;
  background-color: white;
}

/* Full-width input fields */
.form-container input[type=text], .form-container input[type=password] {
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  border: none;
  background: #f1f1f1;
}

/* When the inputs get focus, do something */
.form-container input[type=text]:focus, .form-container input[type=password]:focus {
  background-color: #ddd;
  outline: none;
}

/* Set a style for the submit/login button */
.form-container .btn {
  background-color: #04AA6D;
  color: white;
  padding: 16px 20px;
  border: none;
  cursor: pointer;
  width: 100%;
  margin-bottom:10px;
  opacity: 0.8;
}

/* Add a red background color to the cancel button */
.form-container .cancel {
  background-color: red;
}

/* Add some hover effects to buttons */
.form-container .btn:hover, .open-button:hover {
  opacity: 1;
}

</style>
</head>

<body>
	
	<div class="container mt-5 pt-4">
	
	<h3 style = "text-align: center;"><%@include file = "message.jsp" %></h3>
	
		<div class="row align-items-end mb-4 pb-2">
			<div class="col-md-8">
				<div class="section-title text-center text-md-start">
					<h4 class="title mb-4">ADMIN PANEL</h4>
					<p class="text-muted mb-0 para-desc">An admin panel, short for
						administrative panel, is a web-based or software interface that
						provides authorized individuals or administrators with the tools
						and functionalities to manage, monitor, and control various
						aspects of a system, application, or website.</p>
				</div>
			</div>

		</div>
		<div class="row">
			<div class="col-lg-4 col-md-6 col-12 mt-4 pt-2">
				<div class="card border-0 bg-light rounded shadow">
					<div class="card-body p-4">
					
					<%int count = new MessageDao().count(); %>
						<span class="badge rounded-pill bg-primary float-md-end mb-3 mb-sm-0"><%=count %> CONTACT	</span>
						<h5>Contact List</h5>
						<div class="mt-3">
							<span class="text-muted d-block"><i class="fa fa-home"
								aria-hidden="true"></i> <a href="#" target="_blank"
								class="text-muted">TANMAY</a></span> <span class="text-muted d-block"><i
								class="fa fa-map-marker" aria-hidden="true"></i> INDIA</span>
						</div>
						<div class="mt-3">
							<a href="read-message.jsp" class="btn btn-primary">Read
								Message</a>
						</div>
					</div>
				</div>
			</div>
			
			<div class="col-lg-4 col-md-6 col-12 mt-4 pt-2">
				<div class="card border-0 bg-light rounded shadow">
					<div class="card-body p-4">
					
						<%int project_count = new ProjectDao().count(); %>
						<span class="badge rounded-pill bg-primary float-md-end mb-3 mb-sm-0"><%=project_count %> Projects	</span>
						<h5>Add Projects</h5>
						<div class="mt-3">
							<span class="text-muted d-block"><i class="fa fa-home"
								aria-hidden="true"></i> <a href="#" target="_blank"
								class="text-muted">TANMAY</a></span> <span class="text-muted d-block"><i
								class="fa fa-map-marker" aria-hidden="true"></i> INDIA</span>
						</div>
						<div class="mt-3">
							<a href="project.jsp" class="btn btn-primary">Add Project</a>
						</div>
					</div>
				</div>
			</div>

			<div class="col-lg-4 col-md-6 col-12 mt-4 pt-2">
				<div class="card border-0 bg-light rounded shadow">
					<div class="card-body p-4">
						<span class="badge rounded-pill bg-primary float-md-end mb-3 mb-sm-0"><%=project_count %> Projects	</span>
						<h5>Update Projects</h5>
						<div class="mt-3">
							<span class="text-muted d-block"><i class="fa fa-home"
								aria-hidden="true"></i> <a href="#" target="_blank"
								class="text-muted">TANMAY</a></span> <span class="text-muted d-block"><i
								class="fa fa-map-marker" aria-hidden="true"></i> INDIA</span>
						</div>
						<div class="mt-3">
							<a href="update-project.jsp" class="btn btn-primary">Update Project</a>
						</div>
					</div>
				</div>
			</div>			
			
			<div class="col-lg-4 col-md-6 col-12 mt-4 pt-2">
				<div class="card border-0 bg-light rounded shadow">
					<div class="card-body p-4">
					<%int edu_count = new EducationDao().countEdu();%>
						<span class="badge rounded-pill bg-primary float-md-end mb-3 mb-sm-0"><%=edu_count %> Education	</span>
						<h5>Education</h5>
						<div class="mt-3">
							<span class="text-muted d-block"><i class="fa fa-home"
								aria-hidden="true"></i> <a href="#" target="_blank"
								class="text-muted">TANMAY</a></span> <span class="text-muted d-block"><i
								class="fa fa-map-marker" aria-hidden="true"></i> INDIA</span>
						</div>
						<div class="mt-3">
							<a href="education.jsp" class="btn btn-primary">Edit Education</a>
						</div>
					</div>
				</div>
			</div>
			
			
			<div class="col-lg-4 col-md-6 col-12 mt-4 pt-2">
				<div class="card border-0 bg-light rounded shadow">
					<div class="card-body p-4">
					
						<span class="badge rounded-pill bg-primary float-md-end mb-3 mb-sm-0"> Certificates	</span>
						<h5>Certificates</h5>
						<div class="mt-3">
							<span class="text-muted d-block"><i class="fa fa-home"
								aria-hidden="true"></i> <a href="#" target="_blank"
								class="text-muted">TANMAY</a></span> <span class="text-muted d-block"><i
								class="fa fa-map-marker" aria-hidden="true"></i> INDIA</span>
						</div>
						<div class="mt-3">
							<a href="certificates.jsp" class="btn btn-primary">Edit Certificates</a>
						</div>
					</div>
				</div>
			</div>
			
			


			<div style="text-align: center; padding-top: 50px;" class="mt-3">
			
			<!-- A button to open the popup form -->
			<button class="open-button" onclick="openForm()">CHANGE
				CREDENTIALS</button>

			<!-- The form -->
			<div class="form-popup" id="myForm">
				<form action="Auth" method="post" class="form-container">
					<h2>Change Password</h2>

					<label for="email"><b>Old Password</b></label> <input type="text"
						placeholder="Enter old password" name="opass" required> <label
						for="psw"><b>New Password</b></label> <input type="password"
						placeholder="Enter Password" name="npass" required> <label
						for="psw"><b>Confirm Password</b></label> <input type="password"
						placeholder="Enter Confirm Password" name="cpass" required>

					<input type="hidden" name="check" value="change">

					<button type="submit" class="btn">Update</button>
					<button type="button" class="btn cancel" onclick="closeForm()">Close</button>
				</form>
			</div>
				<form action="Auth" method="post">
					<input type ="hidden" name = "check" value = "Logout">
					<button class="btn btn-primary">LOGOUT</button>
				</form>
			</div>

		</div>
	</div>

	<script>
		function openForm() {
			document.getElementById("myForm").style.display = "block";
		}

		function closeForm() {
			document.getElementById("myForm").style.display = "none";
		}
	</script>
	<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"></script>
	<script type="text/javascript">
		
	</script>
</body>

</html>
