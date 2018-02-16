<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Shopping List Item</title>
</head>
<body>
	<form action = "editItemServlet" method = "post">
		Store: <input type = "text" name = "store" value = "${itemToEdit.store}">
		Item: <input type = "text" name = "item" value = "${itemToEdit.item}">
		<input type = "hidden" name = "id" value = "${itemToEdit.id}">
		<input type = "submit" value = "Save Edited Item">
	</form>
</body>
</html>