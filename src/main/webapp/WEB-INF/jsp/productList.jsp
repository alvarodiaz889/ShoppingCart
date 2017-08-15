<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="xxx.css">
    <title>product</title>
</head>
<body>

<header>


</header>

<table class="table table-striped">
    <thead>

    <tr>
        <th>product Id</th>
        <th>Description</th>
        <th>Image</th>
        <th>Price</th>
        <th>Product type</th>
    </tr>
    </thead>

    <tbody>

    <c:forEach var="product" items="${products}">
        <tr>
            <td>${product.productId}</td>
            <td>${product.description}</td>
            <td>${product.image}</td>
            <td>${product.price}</td>
            <td>${product.type}</td>

            <td>
                <a href="/products/update?id=${product.productId}"><button type="submit" class="btn btn-warning">Update</button></a>
            </td>
            <td>
                <form action="/products/delete?productId=${product.productId}" method="post">
                    <button type="submit" class="btn btn-danger">Remove</button>

                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>

</table>

<a href="/products/update?productId=0"><button type="button" class="btn btn-primary">Add</button></a>
</div>

</body>
</html>


</body>
</html>