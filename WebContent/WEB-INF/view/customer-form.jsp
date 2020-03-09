<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<title> Save Customer</title>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css">

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
		  
		  <style>
		  .error {color:red}
		  </style>
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
		
			<form:hidden path="id"/>
			
			<table>
				<tbody>
					<tr>
						<td><label>First name:</label></td>
						<td><form:input path="firstName"/>
						<form:errors path="firstName" cssClass="error"/></td> 
					</tr>
						
					<tr>
						<td><label>Last name:</label></td>
						<td><form:input path="lastName"/>
						<form:errors path="lastName" cssClass="error"/></td>
					</tr>
						
					<tr>
						<td><label>Email:</label></td>
						<td><form:input path="email"/>
						<form:errors path="email" cssClass="error"/></td>
					</tr>
				</tbody>
			</table>
		<div id="container">
			<h3>Additional Info</h3>
		</div>
			<table>
				<tbody>
					<tr>
						<td><label>Address Line:</label></td>
						<td><form:input path="customerDetail.addressLine"/></td>
					</tr>
					
					<tr>
						<td><label>City:</label></td>
						<td><form:input path="customerDetail.city"/></td>
					</tr>
					
					<tr>
						<td><label>Zip-Code:</label></td>
						<td><form:input path="customerDetail.zipCode"/></td>
					</tr>
					
					<tr>
						<td><label>Phone Number:</label></td>
						<td><form:input path="customerDetail.phoneNumber"/></td>
					</tr>
					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save"/></td>
					</tr>
				</tbody>
			</table>	
			
		</form:form>
		
		<div style="clear; both;">
			<p>
				<a href="${pageContext.request.contextPath}/customer/list"> Back to List</a>
			</p>
		</div>
	</div>

</body>

</html>