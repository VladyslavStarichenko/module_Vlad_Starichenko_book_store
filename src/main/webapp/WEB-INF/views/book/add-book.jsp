<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Book</title>

    <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
          rel="stylesheet">
    <style>
        .footer {
            height: 80px;
            width: 100%;
            color: #777777;
            background-color: #e7e7e7;
            margin-top: 100px;
            font-size: 16px;

        }

        .container {
            margin-top: 100px;
            top: 50%;
            bottom: 50%;
            width: 500px;
            height: auto;
            border: 1px solid black;
            margin-bottom: 190px;
            border-radius: 20px;
            background-color: lightgrey;
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

        .heading {
            margin-top: 20px;
            text-align: center;
        }

        .btn {
            width: 300px;
        }

        .footer > p {
            padding-top: 30px;
            text-align: center;
        }
        #navigation {
            background-color: lightgrey;
        }

        * {
            font-family: "Maiandra GD";
        }

        .form-group {
            width: 300px;
            margin-left: 80px;
        }

    </style>
</head>

<body>
<nav id="navigation" class="navbar navbar-default">

    <ul class="nav navbar-nav ">
        <li><H3 style="margin-left: 100px; margin-top: 7px; padding-top: 3px "> Books<svg style="margin-bottom:-2px; margin-left: 10px" xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-book" viewBox="0 0 16 16">
            <path d="M1 2.828c.885-.37 2.154-.769 3.388-.893 1.33-.134 2.458.063 3.112.752v9.746c-.935-.53-2.12-.603-3.213-.493-1.18.12-2.37.461-3.287.811V2.828zm7.5-.141c.654-.689 1.782-.886 3.112-.752 1.234.124 2.503.523 3.388.893v9.923c-.918-.35-2.107-.692-3.287-.81-1.094-.111-2.278-.039-3.213.492V2.687zM8 1.783C7.015.936 5.587.81 4.287.94c-1.514.153-3.042.672-3.994 1.105A.5.5 0 0 0 0 2.5v11a.5.5 0 0 0 .707.455c.882-.4 2.303-.881 3.68-1.02 1.409-.142 2.59.087 3.223.877a.5.5 0 0 0 .78 0c.633-.79 1.814-1.019 3.222-.877 1.378.139 2.8.62 3.681 1.02A.5.5 0 0 0 16 13.5v-11a.5.5 0 0 0-.293-.455c-.952-.433-2.48-.952-3.994-1.105C10.413.809 8.985.936 8 1.783z"/>
        </svg> </H3></li>
    </ul>
    <ul  style="margin-left:50px;" class="nav navbar-nav">
        <li><a href="/list-books.do" id="first">Books<svg style="margin-bottom: -2px; margin-left: 10px" xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-check2-all" viewBox="0 0 16 16">
            <path d="M12.354 4.354a.5.5 0 0 0-.708-.708L5 10.293 1.854 7.146a.5.5 0 1 0-.708.708l3.5 3.5a.5.5 0 0 0 .708 0l7-7zm-4.208 7-.896-.897.707-.707.543.543 6.646-6.647a.5.5 0 0 1 .708.708l-7 7a.5.5 0 0 1-.708 0z"/>
            <path d="m5.354 7.146.896.897-.707.707-.897-.896a.5.5 0 1 1 .708-.708z"/>
        </svg></a></li>
    </ul>

    <ul class="nav navbar-nav navbar-right">
        <li style="margin-right: 20px"><a href="/logout.do" id="third">Log out <svg style="margin-bottom: -2px; margin-left: 10px" xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-box-arrow-left" viewBox="0 0 16 16">
            <path fill-rule="evenodd" d="M6 12.5a.5.5 0 0 0 .5.5h8a.5.5 0 0 0 .5-.5v-9a.5.5 0 0 0-.5-.5h-8a.5.5 0 0 0-.5.5v2a.5.5 0 0 1-1 0v-2A1.5 1.5 0 0 1 6.5 2h8A1.5 1.5 0 0 1 16 3.5v9a1.5 1.5 0 0 1-1.5 1.5h-8A1.5 1.5 0 0 1 5 12.5v-2a.5.5 0 0 1 1 0v2z"/>
            <path fill-rule="evenodd" d="M.146 8.354a.5.5 0 0 1 0-.708l3-3a.5.5 0 1 1 .708.708L1.707 7.5H10.5a.5.5 0 0 1 0 1H1.707l2.147 2.146a.5.5 0 0 1-.708.708l-3-3z"/>
        </svg> </a></li>
    </ul>

</nav>


<div class="container">
    <h2 class="heading"> Add some new books! </h2>
    <hr>
    <p style="color: lightcoral; text-align: center" >${errorMessage}</p>
    <form method="POST" action="/add-book.do">
        <fieldset class="form-group">
            <label>Title</label> <input name="title" type="text"
                                            class="form-control"/> <BR/>
        </fieldset>
        <fieldset class="form-group">
            <label>Author</label> <input name="author" type="text"
                                        class="form-control"/> <BR/>
        </fieldset>
        <fieldset class="form-group">
            <label>Price</label> <input name="price" type="text"
                                         class="form-control"/> <BR/>
        </fieldset>
        <fieldset class="form-group">
            <label>Publisher</label> <input name="publisher" type="text"
                                        class="form-control"/> <BR/>
        </fieldset>
        <fieldset class="form-group">
            <label>Reseller</label>
            <input name="reseller" type="text" class="form-control"/> <BR/>
        </fieldset>
        <fieldset class="form-group">
            <label>PageCount</label>
            <input name="pagecount" type="text" class="form-control"/> <BR/>
        </fieldset>

        <fieldset class="form-group">
            <label>Vertical Size</label>
            <input name="verticalsize" type="text" class="form-control"/> <BR/>
        </fieldset>
        <fieldset class="form-group">
            <label>Horizontal Size</label>
            <input name="horizontalSize" type="text" class="form-control"/> <BR/>
        </fieldset>
        <fieldset class="form-group">
            <label>Weight</label>
            <input name="weight" type="text" class="form-control"/> <BR/>
        </fieldset>
        <fieldset class="form-group">
            <label>Language</label>
            <input name="language" type="text" class="form-control"/> <BR/>
        </fieldset>
        <fieldset class="form-group">
            <label>Is Translated</label>
            <input name="istranslated" type="text" class="form-control"/> <BR/>
        </fieldset>
        <fieldset class="form-group">
            <label>Address of Book</label>
            <input name="address" type="text" class="form-control"/> <BR/>
            <div class="btn-group" style="margin-left: 10px; margin-top: 10px;">
            <button type="button" class="btn btn-warning dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
                Choose necessary streets
            </button>
            <ul class="dropdown-menu" id="streets">
                <c:forEach items="${addresses}" var="address">
                    <li><input name="Address" type="checkbox" value="${address.addressName}"/>${address.addressName}</li>
                </c:forEach>
                <li><button type="button" class="btn btn-success" id="getStreets">+</button></li>
            </ul>

            </div>
        </fieldset>
        <hr>
        <center>
            <input id="btn" name="add" type="submit" class="btn btn-info" value="Add">
        </center>

    </form>

</div>
<script>
    const streets = document.getElementsByName('Address');
    let result = [], street = null;

    document.querySelector('#getStreets').addEventListener('click', function(event) {
        result.length = 0;

        for (let index = 0; index < streets.length; index++) {
            if (streets[index].checked) {
                street = streets[index].value;
                result.push(street);
            }
        }

        let resultString = result.reduce((result, current) => result + ';' + current,);

        document.querySelector('input[name="address"]').value = resultString;
    });
</script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>

</html>