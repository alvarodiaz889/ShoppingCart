<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <title>Cart</title>
</head>
<body>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">WishSoppingCart</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="#">Home</a></li>
            <li><a href="#">Page 1</a></li>
            <li><a href="#">Page 2</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="#"><span class="glyphicon glyphicon-shopping-cart"></span> Cart</a></li>
            <li><a href="#"><span class="glyphicon glyphicon-user"></span> Hello User!</a></li>
        </ul>
    </div>
</nav>
<div class="container-wrapper">
    <div class = "container">
        <section>
            <div class="jumbotron">
                <div class="container">
                    <h1>Checkout</h1>
                    <p>Thanks for your purchase!, your product is on the way!</p>
                </div>
            </div>
        </section>
    </div>
</div>
</body>
</html>