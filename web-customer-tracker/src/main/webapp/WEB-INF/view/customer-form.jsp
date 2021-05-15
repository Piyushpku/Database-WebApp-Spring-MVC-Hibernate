<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

<head>
	<title>Add Customer</title>
	
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />
		  
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/add-customer-style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Save Customer</h3>
		<form:form action="saveCustomer" modelAttribute="customer" method="POST">
		
		<table>
			<tbody>
				<tr>
					<td><label>First Name:</td>
					<td><form:input path="first"/></td>
				</tr>
				
				<tr>
					<td><label>Last Name:</td>
					<td><form:input path="last"/></td>
				</tr>
				
				<tr>
					<td><label>Email Id:</td>
					<td><form:input path="email"/></td>
				</tr>
				
				<tr>
					<td><label></td>
					<td><input type="submit" value="Save" class=save></td>
				</tr>
			
			</tbody>
		
		</table>
		
		</form:form>
		<div style="clear; both;"></div>
		<p>
		<a href="${pageContext.request.contextPath}/customer/list">Back to the List</a>
		</p>
	</div>
	

</body>

</html>









