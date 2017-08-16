<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <title>product</title>
<style>
    input{
        width: 400px;

       border-radius: 4px;
       background-color: white;
      margin-left: 20px;
        padding-right: 5px;  }

.navcolor{
    background-color: #0c0c0c;

}
.searchP{
    margin-left: 10px;
}
.searchLoc{
    margin-top: 20px;

}
    .styleUsersList{
        width: 200px;
        margin-left: 200px;
        padding: 10px;
       /* background-color: #1ab7ea;*/
        display: inline-block;
    }
    #bodyContainer{
        margin-bottom: 100px;
        background-color: white;

    }
    .styleUser{float: right;
        margin-top: 15px;

    }
</style>


</head>
<body>
<div class="container-wrapper">
<div id="wrapper">
    <!-- Navigation -->
    <nav class="navbar navbar-default navbar-static-top navcolor" role="navigation" style="margin-bottom: 0">
        <div class="navbar-header ">

            <button type="button" class="navbar-toggle" data-toggle="collapse"
                    data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>

            <p class="searchLoc">
            <form action="/search" method="post">
                <input type="text" name="productName">
                <%--a href="/products6?id=${product.productId}"--%>
                <button type="submit" class="btn btn-success searchP">Search</button>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </form>

            </p>

            <a class="navbar-brand" href="/">WishShoppingCart</a>
        </div>

        <ul class="nav navbar-top-links navbar-right">

            <!-- /.dropdown -->
            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                    <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
                </a>
                <ul class="dropdown-menu dropdown-user">
                    <li><a href="#"><i class="fa fa-user fa-fw"></i> User Profile</a>
                    </li>
                    <li><a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a>
                    </li>
                    <li class="divider"></li>
                    <li><a href="/logout"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                    </li>
                </ul>

            </li>

        </ul>
        <a class="styleUser" href="#">Username</a>
    </nav>


        </div>
        <!-- /.row -->
                    <!-- /.panel-heading -->
                    <div id="bodyContainer">


                        <a href="/user/all"><h3 class="styleUsersList">List of users</h3></a>
                        <a href="/product/table"><h3 class="styleUsersList">List of Products</h3></a>
                    </div>

    <ul class="forImagelist">
    <c:forEach var="product" items="${products}">
        <li>
           <a href="/product/details?id=${product.productId}">
               <img src="data:image/jpg;base64,${strData}"
            width="50%" height="50%" style="padding: 10px 10px"/>
            </a>


                <h4>${product.description}</h4>

            <p>
                <fmt:formatNumber type="currency">${product.price}</fmt:formatNumber>


            </p>
            <p>
                <a href="#" class="btn btn-success">Add to cart</a>
            </p>


        </li>

    </c:forEach>
    </ul>
</div>
</body>
</html>