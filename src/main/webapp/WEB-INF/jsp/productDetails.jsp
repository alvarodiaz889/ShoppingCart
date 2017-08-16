<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">



    <style>
        .productdisplay{
            float: right;
            margin-right: 500px;
        }
    </style>


    <title>Product Details</title>
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
    <div class="container">
        <section>
            <div class="jumbotron">
                <div class="container">
                    <h1>Product Details</h1>
                    <p>Your product details!</p>
                </div>
            </div>

        </section>
    </div>
</div>

<img src="${product.image}" width="200" height="130" style="padding: 10px 10px"/>
<div class="productdisplay">
    <p>${product.description}</p>
    <p>${product.price}</p>
    <p>${product.type}</p>


    <form action="/product/addToCart" method="post">
        <label>Quantity:</label>
        <input type="number"min="1" class="item_quantity"  value="1" name="quantity">
      <%--  <script>
            $(".item_quantity").(onclick

        </script>--%>

        <input type="hidden"   value="${product.productId}" name="productId" >
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <button class="btn btn-success">Add to cart</button>
    </form>


        <a href="/product/" class="btn btn-success">Back to shopping</a>

</div>


</body>
</html>

