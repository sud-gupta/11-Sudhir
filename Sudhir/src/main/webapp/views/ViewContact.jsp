<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
	function deleteConfirm(){
		return confirm("Are you sure want to delete record ?");
		}

</script>

</head>
<body>
	<h1>view contact</h1>
	
	<font color='green'>${delMsg}</font>
	<h1></h1>
	<a href="/">+Add New Contact</a>

	<table border="1">
		<tr>
			<th>Name</th>
			<th>Email</th>
			<th>Contact No</th>
			<th>Action</th>
			<th>
		</tr>
		<c:forEach items="${contacts}" var="abc">
			<tr>
				<td>${abc.contactName}</td>
				<td>${abc.contactEmail}</td>
				<td>${abc.contactNum}</td>
				<td><a href="editContact?cid=${abc.contactId}">Edit</a>
				 <a	href="deleteContact?cid=${abc.contactId}" onclick="return deleteConfirm()">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>