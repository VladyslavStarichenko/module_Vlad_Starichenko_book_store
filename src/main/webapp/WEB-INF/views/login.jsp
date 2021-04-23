<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<title>Todos</title>
	<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
		  rel="stylesheet">


	<style>

		body {
			height: 100%;
		}

		#first:hover {
			background-color: lightgrey;
		}

		#second:hover {
			background-color: lightgrey;
		}

		#third:hover {
			background-color: lightgrey;
		}

		.container {
			top: 50%;
			bottom: 50%;
			width: 500px;
			height: 400px;
			border: 1px solid black;
			margin-bottom: 190px;
			border-radius: 20px;
			background-color: lightgrey;
		}


		.text  {
			font-size: 30px;
			text-align: center;
		}


		.footer {
			height: 80px;
			width: 100%;
			color: #777777;
			background-color: #e7e7e7;
			font-size: 16px;
			margin-top: 400px;
		}

		.footer > p {
			margin-top: 27px;
			text-align: center;
		}*{
			 font-family: "Maiandra GD";
		 }
		fieldset {
			width: 300px;
			margin-left: 80px;
		}

	</style>
</head>

<body>

<nav class="navbar navbar-default">

	<ul class="nav navbar-nav ">
		<li><H3 style="margin-left: 100px; margin-top: 7px; padding-top: 3px "> Todo Tasks </H3></li>
	</ul>
	<ul class="nav navbar-nav" style="margin-left: 50px">
		<li><a href="/list-todos.do" id="first">Todos<svg style="margin-bottom: -2px; margin-left: 10px" xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-check2-all" viewBox="0 0 16 16">
			<path d="M12.354 4.354a.5.5 0 0 0-.708-.708L5 10.293 1.854 7.146a.5.5 0 1 0-.708.708l3.5 3.5a.5.5 0 0 0 .708 0l7-7zm-4.208 7-.896-.897.707-.707.543.543 6.646-6.647a.5.5 0 0 1 .708.708l-7 7a.5.5 0 0 1-.708 0z"/>
			<path d="m5.354 7.146.896.897-.707.707-.897-.896a.5.5 0 1 1 .708-.708z"/>
		</svg></a></li>
	</ul>

	<ul class="nav navbar-nav navbar-right">
		<li style="margin-right: 20px"><a href="/sign-up.do" id="third">Sign Up<svg style="margin-bottom: -2px; margin-left:10px" xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-file-person" viewBox="0 0 16 16">
			<path d="M12 1a1 1 0 0 1 1 1v10.755S12 11 8 11s-5 1.755-5 1.755V2a1 1 0 0 1 1-1h8zM4 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h8a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H4z"/>
			<path d="M8 10a3 3 0 1 0 0-6 3 3 0 0 0 0 6z"/>
		</svg></a></li>
	</ul>

</nav>


<div class="container">
	<h1 class="text">Log in</h1>
	<hr>
	<form action="/login.do" method="post">
		<p style="color: lightcoral; text-align: center" >${errorMessage}</p>
		<fieldset class="fieldset" class="form-group">
			<label>Name</label> <input name="name" type="text" class="form-control" value="${name}"/> <BR/>
		</fieldset>

		<fieldset class="fieldset" class="form-group">
			<label>Password</label> <input name="password" type="password" class="form-control"/> <BR/>
		</fieldset>
		<hr>
		<button type="submit" value="Login" class="btn btn-info" style="width: 182.4px; margin-top: 5px; margin-left:135px" >
			Login<svg style="margin-bottom: -2px; margin-left:10px" xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-box-arrow-in-right" viewBox="0 0 16 16">
			<path fill-rule="evenodd" d="M6 3.5a.5.5 0 0 1 .5-.5h8a.5.5 0 0 1 .5.5v9a.5.5 0 0 1-.5.5h-8a.5.5 0 0 1-.5-.5v-2a.5.5 0 0 0-1 0v2A1.5 1.5 0 0 0 6.5 14h8a1.5 1.5 0 0 0 1.5-1.5v-9A1.5 1.5 0 0 0 14.5 2h-8A1.5 1.5 0 0 0 5 3.5v2a.5.5 0 0 0 1 0v-2z"/>
			<path fill-rule="evenodd" d="M11.854 8.354a.5.5 0 0 0 0-.708l-3-3a.5.5 0 1 0-.708.708L10.293 7.5H1.5a.5.5 0 0 0 0 1h8.793l-2.147 2.146a.5.5 0 0 0 .708.708l3-3z"/>
		</svg>
		</button>
	</form>

</div>

<footer class="footer">
	<p>All rights reserved</p>
</footer>

<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>

</html>