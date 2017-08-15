<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>



<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">

    <link rel="stylesheet" type="text/css" href="xxx.css">

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <%-- <!-- jQuery library -->
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
     <!-- Latest compiled JavaScript -->
     <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>--%>

    <title>product</title>


</head>
<body>

<header>


</header>

<form method="post" action="../products/savedproducts" >
    <p> ProductID: </p>
    <%--<p>
        <input class="input1" type="text" name="productId" value="${product.productId}"></p>
    --%>

    <p> Description: </p>
    <p>
        <input class="input1" type="text" name="description"value="${product.description}"></p>

    <p> ImageLink: </p>
    <p> <input class="input1" type="file" name="image" value="${product.image}" ></p>


    <p> Price: </p>
    <p>
        <input class="input1" type="text" name="price" value="${product.price}"></p>

    <%--<p> Type: </p>
    <p>
        <input class="input1" type="checkbox" name="type" value="${product.type}"></p>--%>

    <p>
        <strong>Product type</strong> <select name="type">
        <option value="CLOTHING">CLOTHING</option>
        <option value="SHOES">SHOES</option>
        <option value="BOOKS">BOOKS</option>
        <option value="AUDIO">AUDIO</option>
        <option value="ELECTRONICS">ELECTRONICS</option>
        <option value="HOUSEHOLDITEMS">HOUSEHOLDITEMS</option>
        <option value="FURNITURE">FURNITURE</option>
    </select>
    </p>

    <button type="submit" class="btn btn-success"> Save </button>


</form>
<form action="/products/deletedproducts?productId=${productId}" RequestMethod.DELETE>

    <button type="submit" class="btn btn-danger">Remove</button></form>


</body>
</html>