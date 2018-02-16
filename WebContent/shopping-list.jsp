<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shopping List</title>
</head>
<body>
	<h3>Shopping List</h3>
	<form method = "post" action = "editShoppingListServlet">
		<table>
			<c:forEach items = "${requestScope.allItems}" var = "currentItem">
				<tr>
					<td><input type = "radio" name = "id" value = "${currentItem.id}"></td>
					<td width = "200">${currentItem.store}</td>
					<td width = "200">${currentItem.item}</td>
				</tr>
			</c:forEach>
		</table>
		<br />
		<input name="doThisToItem" value="Edit Selected Item" type="submit" style="margin-right: 2em" /> 
		<input name="doThisToItem" value="Delete Selected Item" type="submit" style="margin-right: 2em" />
		<input name="doThisToItem" value="Add New Item" type="submit" />
	</form>
</body>
</html>