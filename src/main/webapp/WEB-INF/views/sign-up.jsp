
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Sign Up</title>
    <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
          rel="stylesheet">

    <style>

        body {
            height: 100%;
        }

        #first:hover {
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

        form {

        }



        .footer {
            height: 80px;
            width: 100%;
            color: #777777;
            background-color: #e7e7e7;
            font-size: 16px;
            position: fixed;
        }

        .footer > p {
            margin-top: 27px;
            text-align: center;
        }

        #login {
            margin-right: 50px;
        }

        * {
            font-family: "Maiandra GD";
        }

        .text {
            text-align: center;
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

    <ul class="nav navbar-nav navbar-right">
        <li id="login"><a id="first" href="/login.do">Login<svg style="margin-bottom: -2px; margin-left:10px" xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-box-arrow-in-right" viewBox="0 0 16 16">
            <path fill-rule="evenodd" d="M6 3.5a.5.5 0 0 1 .5-.5h8a.5.5 0 0 1 .5.5v9a.5.5 0 0 1-.5.5h-8a.5.5 0 0 1-.5-.5v-2a.5.5 0 0 0-1 0v2A1.5 1.5 0 0 0 6.5 14h8a1.5 1.5 0 0 0 1.5-1.5v-9A1.5 1.5 0 0 0 14.5 2h-8A1.5 1.5 0 0 0 5 3.5v2a.5.5 0 0 0 1 0v-2z"/>
            <path fill-rule="evenodd" d="M11.854 8.354a.5.5 0 0 0 0-.708l-3-3a.5.5 0 1 0-.708.708L10.293 7.5H1.5a.5.5 0 0 0 0 1h8.793l-2.147 2.146a.5.5 0 0 0 .708.708l3-3z"/>
        </svg></a></li>
    </ul>

</nav>


<div class="container">
    <h1 class="text">Sign Up</h1>
    <hr>

    <form method="POST" action="/sign-up.do">
        <p style="color: lightcoral; text-align: center">${errorMessage}</p>
        <fieldset class="fieldset" class="form-group">
            <label>Name</label> <input name="name" type="text" class="form-control"/> <BR/>
        </fieldset>

        <fieldset class="fieldset" class="form-group">
            <label>Password</label> <input name="password" type="password" class="form-control"/> <BR/>
        </fieldset>
        <hr>
        <input type="submit" value="Sign Up" class="btn btn-info" style="width: 182.4px; margin-top: 5px; margin-left:135px"/>

    </form>

</div>

<footer class="footer">
    <p style="margin-top: 20px">All rights reserved</p>
</footer>

<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>

</html>