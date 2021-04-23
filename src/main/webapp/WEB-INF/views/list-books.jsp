<!DOCTYPE html>
<html>
<head>
    <title>Todo list</title>



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
            width: 70%;
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

        .modal {
            position: relative;
            margin-top: 300px;
            margin-left: auto;
            margin-right: auto;
            border: 1px solid black;
            border-radius: 10px;
            z-index: 10;
            background-color: white;
            width: 500px;
            max-width: 80%;
            transform: scale(0);
            transition: 200ms ease-in-out;
        }

        .modal.active {
            transform: scale(1);
        }

        .modal-header {
            padding: 10px 15px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .modal-header .title {
            font-size: 1.25rem;
            font-weight: bold;
        }

        .modal-header .close-button {
            cursor: pointer;
            border: none;
            outline: none;
            background: none;
            font-size: 1.25rem;
            font-weight: bold;
        }

        .modal-body {
            padding: 10px 15px;
        }

        #overlay {
            position: fixed;
            top: 0;
            right: 0;
            left: 0;
            bottom: 0;
            transition: 200ms ease-in-out;
            background-color: rgba(0, 0, 0, .5);
            pointer-events: none;
        }

        #overlay:active {
            opacity: 1;
            pointer-events: all;
        }


    </style>
</head>

<body  >
<nav class="navbar navbar-default">
    <ul class="nav navbar-nav ">
        <li><H3 style="margin-left: 100px; margin-top: 7px; padding-top: 3px"> Todo Tasks </H3></li>
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
        <th style="text-align:  center;  ">Deleting</th>
        <th style="text-align: center">Updating</th>
        </thead>
        <tbody>
        <c:forEach items="${books}" var="book">

            <tr style="text-align: center">
                <td >${book.title}</td>
                <td>${book.author}</td>
                <c:forEach items="${book.addressList}" var="address">
                <td style="margin-top: 5px">
                    <p>${address.addressName}</p>

                </td>
                </c:forEach>
                <td style="margin-top: 5px">
                    <a style="text-decoration: none #c37180; margin-top: 5px"  class="btn btn-danger"  href="/delete-book.do?title=${book.title}&author=${book.author}&addresses${book.addressList}">Delete<svg style="margin-left: 10px; margin-bottom: -2px" xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash" viewBox="0 0 16 16">
                        <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z"/>
                        <path fill-rule="evenodd" d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z"/>
                    </svg></a>

                </td>
                <td>
                    <a class="btn btn-warning" href="/update-book.do?oldAuthor=${book.author}&oldTitle=${book.title}">Update<svg style="margin-bottom: -2px; margin-left: 10px" xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-up-square" viewBox="0 0 16 16">
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

