<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>List of Persons</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="../../resources/styles.css">
    <style>
        .detailsContainer
        {
            width: 40%;
            margin: 10px auto;
        }
    </style>

</head>
<body>

<section>
    <div class="jumbotron">
        <div class="container">
            <h1>${title}</h1>
        </div>
    </div>

</section>

<div class="detailsContainer">


    <form method="post" action="../user/add" >

        <input type="hidden" name="userId" value="${user.userId}">
        <p>First Name:</p>
        <p>
            <input class="form-control" type="text" name="firstName" value="${user.firstName}" required >
        </p>

        <p>Last Name:</p>
        <p>
            <input class="form-control" type="text" name="lastName" value="${user.lastName}" required >
        </p>

        <p>Email:</p>
        <p>
            <input class="form-control" type="email" name="email" value="${user.email}" >
        </p>

        <p>Age:</p>
        <p>
            <input class="form-control" type="numeric" name="age" value="${user.age}" >
        </p>

        <p>Phone:</p>
        <p>
            <input class="form-control" type="text" name="phone" value="${user.phone}" >
        </p>

        <p>User:</p>
        <p>
            <input class="form-control" type="text" name="username" value="${user.username}">
        </p>

        <p>Password:</p>
        <p>
            <input class="form-control" type="password" name="password" value="${user.password}">
        </p>


        <hr/>
        <!-- Data for the address -->
        <input class="form-control" type="hidden" name="addressId" value="${user.address.addressId}" >
        <p>City:</p>
        <p>
            <input class="form-control" type="text" name="city" value="${user.address.city}" >
        </p>

        <p>Country:</p>
        <p>
            <input class="form-control" type="text" name="country" value="${user.address.country}" >
        </p>

        <p>State:</p>
        <p>
            <input class="form-control" type="text" name="state" value="${user.address.state}" >
        </p>

        <p>Zipcode:</p>
        <p>
            <input class="form-control" type="text" name="zipcode" value="${user.address.zipcode}" >
        </p>

        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

        <c:choose>
            <c:when test="${create}">
                <button type="submit" class="btn btn-success">Create</button>
            </c:when>
            <c:otherwise>
                <button type="submit" class="btn btn-success">Update</button>
            </c:otherwise>
        </c:choose>

    </form>

</div>

</body>
</html>