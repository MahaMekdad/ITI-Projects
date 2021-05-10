<!DOCTYPE html>
<html lang="en">
<head>
	<title>Login V1</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<script src="helper.js"></script>
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="css/util.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
<!--===============================================================================================-->
</head>
<body>
	
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
				<div class="login100-pic js-tilt" data-tilt>
					<img src="images/img-01.png" alt="IMG">
				</div>

				<form class="login100-form validate-form" method="post" action="chat.jsp">
					<span class="login100-form-title">
						Chat Login
					</span>

					<div class="wrap-input100 validate-input" data-validate = "Valid Username is required: ex@abc.xyz">
						<input class="input100" type="text" id="uname" name="uname" placeholder="Enter Your Username">
						<span class="focus-input100"></span>
					</div>

					<div class="wrap-input100 validate-input" data-validate = "Gender is required" class="text-center p-t-12">
						<input type="radio" id="male" name="gender" value="male">
						<label for="male">Male</label>
						<br>
						<span class="focus-input100"></span>
						<input type="radio" id="female" name="gender" value="female">
						<label for="female">Female</label><br>
					</div>
					
					<div class="container-login100-form-btn">
<%--						<a href="edit.jsp?userId=${user.id}"/>--%>
<%--							<button onclick="location.href='http://www.example.com'" type="button">--%>
<%--								www.example.com</button>--%>
<%--						'<input type="button" onClick="gotoNode(\'' + result.name + '\')" />'--%>

							<button type="submit" class="login100-form-btn" >
							Login
						</button>
<%--	onclick="location.href='chat.jsp?name='+uname;"--%>
<%--						<a href="' + uname + '">Google</a>--%>

<%--						<a class ="button" href='chat.jsp?name='+unname>Login</a>--%>
<%--				Link to <a href="https://www.google.com/" onclick="location.href=this.href+'?xyz='+val;return false;">--%>

					</div>
				</form>
			</div>
		</div>
	</div>

	<script>
		var uname = document.getElementById('uname').value;
		console.log(uname)
	</script>



<!--===============================================================================================-->
	<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/bootstrap/js/popper.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/tilt/tilt.jquery.min.js"></script>
	<script >
		$('.js-tilt').tilt({
			scale: 1.1
		})
	</script>
<!--===============================================================================================-->
	<script src="js/main.js"></script>

</body>
</html>