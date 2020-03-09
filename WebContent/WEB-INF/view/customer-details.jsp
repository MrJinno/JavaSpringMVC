<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title> Details</title>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css">

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Detailed Information</h3>
			
			<table>
				<tbody>
					<tr>
						<td><label>First name:</label></td>
						<td>${customer.firstName}</td>
					</tr>
						
					<tr>
						<td><label>Last name:</label></td>
						<td>${customer.lastName}</td>
					</tr>
						
					<tr>
						<td><label>Email:</label></td>
						<td>${customer.email}</td>
					</tr>

					<tr>
						<td><label>Address Line:</label></td>
						<td>${customer.customerDetail.addressLine}</td>
					</tr>
					
					<tr>
						<td><label>City:</label></td>
						<td>${customer.customerDetail.city}</td>
					</tr>
					
					<tr>
						<td><label>Zip-Code:</label></td>
						<td>${customer.customerDetail.zipCode}</td>
					</tr>
					
					<tr>
						<td><label>Phone Number:</label></td>
						<td>${customer.customerDetail.phoneNumber}</td>
					</tr>
				</tbody>
			</table>	
		<div style="clear; both;">
			<p>
				<a href="${pageContext.request.contextPath}/customer/list"> Back to List</a>
			</p>
		</div>
	</div>

</body>

</html>