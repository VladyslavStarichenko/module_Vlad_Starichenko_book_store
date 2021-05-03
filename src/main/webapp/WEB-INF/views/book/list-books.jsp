<!DOCTYPE html>
<html>
<head>
    <title>Book Store</title>



    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
          rel="stylesheet">


    <style>

        .footer {
            height: 80px;
            width: 100%;
            color: #777777;
            background-color: #e7e7e7;
            font-size: 16px;
            margin-top: 400px;

        }

        .footer > p {
            padding-top: 30px;
            text-align: center;

        }


        #second:hover {
            background-color: lightgrey;
        }

        #third:hover {
            background-color: lightgrey;
        }
        .btn{
            width: 150px;
        }
        .container{
            width: auto;
            height: auto;
            margin-left: auto;
            margin-right: auto;
            border: 1px solid black;
            background-color: lightgrey;
            border-radius:20px ;
            margin-top: 30px;
        }
        .heading{
            text-align: center;
        }*{
             font-family: "Maiandra GD";
         } *, *::after, *::before {
               box-sizing: border-box;
           }


    </style>
</head>

<body  >
<nav class="navbar navbar-default">
    <ul class="nav navbar-nav ">
        <li><H3 style="margin-left: 100px; margin-top: 7px; padding-top: 3px"> Books <svg style="margin-bottom:-2px; margin-left: 5px" xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-book" viewBox="0 0 16 16">
            <path d="M1 2.828c.885-.37 2.154-.769 3.388-.893 1.33-.134 2.458.063 3.112.752v9.746c-.935-.53-2.12-.603-3.213-.493-1.18.12-2.37.461-3.287.811V2.828zm7.5-.141c.654-.689 1.782-.886 3.112-.752 1.234.124 2.503.523 3.388.893v9.923c-.918-.35-2.107-.692-3.287-.81-1.094-.111-2.278-.039-3.213.492V2.687zM8 1.783C7.015.936 5.587.81 4.287.94c-1.514.153-3.042.672-3.994 1.105A.5.5 0 0 0 0 2.5v11a.5.5 0 0 0 .707.455c.882-.4 2.303-.881 3.68-1.02 1.409-.142 2.59.087 3.223.877a.5.5 0 0 0 .78 0c.633-.79 1.814-1.019 3.222-.877 1.378.139 2.8.62 3.681 1.02A.5.5 0 0 0 16 13.5v-11a.5.5 0 0 0-.293-.455c-.952-.433-2.48-.952-3.994-1.105C10.413.809 8.985.936 8 1.783z"/>
        </svg> </H3></li>
        <li style="margin-left: 70px">
            <a href="/list-address.do" id="second">Addresses</a>
        </li>
    </ul>

    <ul class="nav navbar-nav navbar-right">

        <li style="margin-right: 20px"><a href="/logout.do" id="third">Log out <svg style="margin-bottom: -2px; margin-left: 10px" xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-box-arrow-left" viewBox="0 0 16 16">
            <path fill-rule="evenodd" d="M6 12.5a.5.5 0 0 0 .5.5h8a.5.5 0 0 0 .5-.5v-9a.5.5 0 0 0-.5-.5h-8a.5.5 0 0 0-.5.5v2a.5.5 0 0 1-1 0v-2A1.5 1.5 0 0 1 6.5 2h8A1.5 1.5 0 0 1 16 3.5v9a1.5 1.5 0 0 1-1.5 1.5h-8A1.5 1.5 0 0 1 5 12.5v-2a.5.5 0 0 1 1 0v2z"/>
            <path fill-rule="evenodd" d="M.146 8.354a.5.5 0 0 1 0-.708l3-3a.5.5 0 1 1 .708.708L1.707 7.5H10.5a.5.5 0 0 1 0 1H1.707l2.147 2.146a.5.5 0 0 1-.708.708l-3-3z"/>
        </svg> </a></li>
    </ul>

</nav>

<div class="container">

    <H1 class="heading">Welcome, ${name}</H1>

    <table style="margin-top:30px" class="table table-dark">

        <thead >
        <th style="text-align: center">Title</th>
        <th style="text-align: center">Author</th>
        <th style="text-align: center">Addresses</th>
        <th style="text-align:  center;  ">Price</th>
        <th style="text-align:  center;  ">Reseller</th>
        <th style="text-align:  center;  ">Publisher</th>
        <th style="text-align:  center;  ">Publish Date</th>
        <th style="text-align:  center;  ">Page Count</th>
        <th style="text-align:  center;  ">Deleting</th>
        <th style="text-align: center">Updating</th>
        </thead>
        <tbody>
        <c:forEach items="${books}" var="book">

            <tr style="text-align: center">
                <td >${book.title}</td>
                <td>${book.author}</td>
                <td style="margin-top: 5px">
                    <c:forEach items="${book.addressList}" var="address">
                    <p>${address.addressName}</p>
                    </c:forEach>
                </td>

                <td>${book.price}&#163</td>
                <td>${book.reseller}</td>
                <td>${book.publisher} </td>
                <td>${book.publishDate}</td>
                <td>${book.pageCount}</td>
                <td style="margin-top: 5px">
                    <a style="text-decoration: none #c37180; margin-top: 5px"  class="btn btn-danger"  href="/delete-book.do?title=${book.title}&author=${book.author}">Delete<svg style="margin-left: 10px; margin-bottom: -2px" xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash" viewBox="0 0 16 16">
                        <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z"/>
                        <path fill-rule="evenodd" d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z"/>
                    </svg></a>
                </td>
                <td>
                    <a class="btn btn-warning" href="/update-book.do?oldTitle=${book.title}&oldAuthor=${book.author}">Update<svg style="margin-bottom: -2px; margin-left: 10px" xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-up-square" viewBox="0 0 16 16">
                        <path fill-rule="evenodd" d="M15 2a1 1 0 0 0-1-1H2a1 1 0 0 0-1 1v12a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1V2zM0 2a2 2 0 0 1 2-2h12a2 2 0 0 1 2 2v12a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V2zm8.5 9.5a.5.5 0 0 1-1 0V5.707L5.354 7.854a.5.5 0 1 1-.708-.708l3-3a.5.5 0 0 1 .708 0l3 3a.5.5 0 0 1-.708.708L8.5 5.707V11.5z"/>
                    </svg></a>
                </td>

            </tr>
        </c:forEach>

        </tbody>
    </table>



    <center>
        <a  class="btn btn-info" style="margin-bottom: 20px; width: 300px" href="/add-book.do">Add New Book <svg style="margin-bottom: -2px; margin-left: 10px" xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-plus-square" viewBox="0 0 16 16">
            <path d="M14 1a1 1 0 0 1 1 1v12a1 1 0 0 1-1 1H2a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1h12zM2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2z"/>
            <path d="M8 4a.5.5 0 0 1 .5.5v3h3a.5.5 0 0 1 0 1h-3v3a.5.5 0 0 1-1 0v-3h-3a.5.5 0 0 1 0-1h3v-3A.5.5 0 0 1 8 4z"/>
        </svg></a>
    </center>
</div>

<footer class="footer">
    <p style="margin-top: 20px">All rights reserved</p>
</footer>
</body>

