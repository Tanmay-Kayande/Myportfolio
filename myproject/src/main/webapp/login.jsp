<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">


<title>login with overlay image - Bootdey.com</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
<style type="text/css">
body {
	margin-top: 20px;
	background: #f6f9fc;
}

.account-block {
	padding: 0;
	background-image: url(https://bootdey.com/img/Content/bg1.jpg);
	background-repeat: no-repeat;
	background-size: cover;
	height: 100%;
	position: relative;
}

.account-block .overlay {
	-webkit-box-flex: 1;
	-ms-flex: 1;
	flex: 1;
	position: absolute;
	top: 0;
	bottom: 0;
	left: 0;
	right: 0;
	background-color: rgba(0, 0, 0, 0.4);
}

.account-block .account-testimonial {
	text-align: center;
	color: #fff;
	position: absolute;
	margin: 0 auto;
	padding: 0 1.75rem;
	bottom: 3rem;
	left: 0;
	right: 0;
}

.text-theme {
	color: #5369f8 !important;
}

.btn-theme {
	background-color: #5369f8;
	border-color: #5369f8;
	color: #fff;
}
</style>
</head>
<body>
	<div id="main-wrapper" class="container">
		<div class="row justify-content-center">
			<div class="col-xl-10">
				<div class="card border-0">
					<div class="card-body p-0">
						<div class="row no-gutters">
							<div class="col-lg-6">
								<div class="p-5">
									<div class="mb-5">
										<h3 class="h4 font-weight-bold text-theme">Login</h3>
									</div>
									<h6 class="h5 mb-0">Welcome back!</h6>
									<p class="text-muted mt-2 mb-5">Enter your username
										and password to access admin panel.</p>
									<form action="Auth" method="post">
										<div class="form-group">
											<label for="exampleInputEmail1">Username</label> 
							<input name="username" type="text" class="form-control" id="exampleInputEmail1">
										</div>
										<div class="form-group mb-5">
											<label for="exampleInputPassword1">Password</label> 
							<input name="password" type="password" class="form-control" id="exampleInputPassword1">
										</div>
										<button type="submit" class="btn btn-theme">Login</button>
									</form>
								</div>
							</div>
							<div class="col-lg-6 d-none d-lg-inline-block">
								<div class="account-block rounded-right">
									<div class="overlay rounded-right"></div>
									<div class="account-testimonial">
										<%@include file="message.jsp"%>
										<h4 class="text-white mb-4">Enter your Credentials!</h4>
										<p class="lead text-white">"Best investment i made for a
											long time. Can only recommend it for other users."</p>
										<p>- Admin User</p>
									</div>
								</div>
							</div>
						</div>
					</div>

				</div>

			</div>

		</div>

	</div>
	<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/js/bootstrap.bundle.min.js"></script>
	<script type="text/javascript">
		
	</script>
</body>
</html>
