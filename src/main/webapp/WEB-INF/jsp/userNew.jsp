<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>User Detail</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="../resources/styles.css">

</head>
<body>
<div class="detailsContainer">

    <h1>User Detail </h1>
    <form method="post" action="../user/add" >

        <p>First Name:</p>
        <p>
            <input type="text" name="firstName" required >
        </p>

        <p>Last Name:</p>
        <p>
            <input type="text" name="lastName" required >
        </p>

        <p>Email:</p>
        <p>
            <input type="email" name="email" >
        </p>

        <p>Age:</p>
        <p>
            <input type="numeric" name="age" >
        </p>

        <p>Phone:</p>
        <p>
            <input type="text" name="phone">
        </p>

        <p>User:</p>
        <p>
            <input type="text" name="username">
        </p>

        <p>Password:</p>
        <p>
            <input type="password" name="password">
        </p>

        <hr/>
        <!-- Data for the address -->
        <input type="hidden" name="addressId" >
        <p>City:</p>
        <p>
            <input type="text" name="city"  >
        </p>

        <p>Country:</p>
        <p>
            <input type="text" name="country" >
        </p>

        <p>State:</p>
        <p>
            <input type="text" name="state"  >
        </p>

        <p>Zipcode:</p>
        <p>
            <input type="text" name="zipcode"  >
        </p>

        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

        <button type="submit" class="btn btn-success">Create</button>

    </form>

</div>
</body>
</html>