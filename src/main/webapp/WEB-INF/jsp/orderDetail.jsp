<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Order Detail</title>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="../../resources/script.js"></script>


</head>
<body>
	<div class="detailsContainer">
	
		<h1>Order Detail </h1>	
		
						
			<p><label>Order Date:</label></p>
			<p id="txt_Date">
				<%= new java.text.SimpleDateFormat("MM/dd/yyyy").format(new java.util.Date()) %>
			</p>
					
			<p><label>Person:</label></p>	
				
			<span>
				<label>${user.firstName} </label>-<label>${user.lastName} </label>	
			</span>
			
			<hr/>
			
			<h2><b>Order Lines</b></h2>	
			
			<p>
				<label>Products:</label>
				<select id="list_Products"  multiple class="form-control selectClass">
					<c:forEach var="ol" items="${orderLines}">
						<option value="${ol.orderLineId}">${ol.product.description}</option>
					</c:forEach>
				</select>

			</p>		

			
			<span>
				 <a href="/productTiles"><button id="btn_Add" class="btn btn-primary">Add</button></a>
				 <button id="btn_Remove" class="btn btn-danger">Remove All</button>
			</span>			
					
			<hr/>
			
			<button id="btn_Save" class="btn btn-success">Create</button>
			<input id="hiddenField" type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	
	</div>
</body>
</html>