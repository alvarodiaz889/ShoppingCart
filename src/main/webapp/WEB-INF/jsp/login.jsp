<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <title>Products</title>
</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1>Welcome to Wish Shopping Cart</h1>
        </div>
    </div>
</section>
<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">Please sign in</h3>
                </div>
                <div class="panel-body">
                    <c:url var="loginUrl" value="/login" />
                    <form action="/login" method="post" class="form-horizontal">
                        <c:if test="${param.error != null}">
                            <div class="alert alert-danger">
                                <p>Invalid username and password.</p>
                            </div>
                        </c:if>
                        <c:if test="${param.logout != null}">
                            <div class="alert alert-success">
                                <p>You have been logged out successfully.</p>
                            </div>
                        </c:if>
                        <c:if test="${param.accessDenied !=null}">
                            <div class="alert alert-danger">
                                <p>Access Denied: You are not authorised!</p>
                            </div>
                        </c:if>
                        <div class="input-group input-sm">
                            <label class="input-group-addon" for="user_name"><i
                                    class="fa fa-user"></i></label> <input type="text" class="form-control"
                                                                           id="user_name" name="user_name" placeholder="Enter Username" required>
                        </div>
                        <div class="input-group input-sm">
                            <label class="input-group-addon" for="pass_word"><i
                                    class="fa fa-lock"></i></label> <input type="password"
                                                                           class="form-control" id="pass_word" name="pass_word" placeholder="Enter Password" required>
                        </div>
                        <div class="form-actions">
                            <input type="submit" class="btn btn-block btn-primary btn-default" value="Log in">
                        </div>
                    </form>
                    <a href="/register"><input class="btn btn-block btn-warning btn-default" value="Sign Up"></a>
                </div>
            </div>
        </div>
    </div>
</div>
</body>