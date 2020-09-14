<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h2>Contact info form</h2>
	<font color='green'>${succMsg}</font>
	<font color='red'>${errorMsg}</font>
	
	<form:form action="/saveContact" method="POST" modelAttribute="contact">
		<table>
		<tr>
		<td>contact name</td>
		<td><form:input path="contactName"/></td>
		<form:hidden path="contactId"/>
		</tr>
		<tr>
		<td>contact Email</td>
		<td><form:input path="contactEmail"/></td>
		</tr>
		<tr>
		<td>contact number</td>
		<td><form:input path="contactNum"/></td>
		</tr>
		<tr>
		<td><input type="submit" value="submit"/>  </td>
		</tr>
		</table>
	
	</form:form>

<a href="/viewContacts">view all contacts</a>



</body>
</html>