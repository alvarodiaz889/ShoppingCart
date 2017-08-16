<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
    <title>Cart</title>
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">WishShoppingCart</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="#">Home</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="#"><span class="glyphicon glyphicon-shopping-cart"></span>Cart</a></li>
            <li><a href="#"><span class="glyphicon glyphicon-user"></span> Hello!</a></li>
        </ul>
    </div>
</nav>

<div class="container">
    <form:form class="form-horizontal" action="/shop/order" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <div class="form-group">
            <h3>Shipping Address Information</h3><br>
            <div class="col-sm-12">
                <h6>Error!</h6>
                <form:errors path="fullname" cssStyle="color:red"/>
            </div>
            <label class="control-label col-sm-2" for="fullName">Full Name:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="fullName" name="fullname" placeholder="Enter fullname" >
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="city">City:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="city" name="city" placeholder="Enter city" >
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="zipcode">Zipcode:</label>
            <div class="col-sm-10">
                <input type="number" class="form-control" id="zipcode" name="zipcode" placeholder="Enter zipcoide" >
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="state">State:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="state" name="state" placeholder="Enter state">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="country">Country:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="country" name="country" placeholder="Enter country">
            </div>
        </div>

        <h3>Credit Card Information</h3><br>
        <div class="form-group">
            <label class="control-label col-sm-2" for="cardnumber">Credit card number:</label>
            <div class="col-sm-10">
                <input type="number" class="form-control" name="cardNumber" id="cardnumber"
                       placeholder="NNNN-NNNN-NNNN-NNNN format" pattern="\b\d{4}[ -]?\d{4}[ -]?\d{4}[ -]?\d{4}\b">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="name">Name on card:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="name" id="name" placeholder="Enter Card name">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="expiryDate">Expiration Date:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="expiryDate" id="expiryDate"
                       placeholder="Enter expiry date format : MM/DDDD">
            </div>
        </div>
        <div class="form-group">
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-success">Submit</button>
                </div>
            </div>
        </div>
    </form:form>
    <a href="<c:url value="url"/>"
       class="btn btn-danger" onclick="return confirm('Are you sure?')">Go Back</a>
</div>
</body>
</html>