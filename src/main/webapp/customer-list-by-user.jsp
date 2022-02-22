<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Comic List</title>
</head>
<body>
	<form method="post" action="comicNavigationServlet">
		<table>
			<c:forEach items="${requestScope.allComics}" var="currentcomiclist">
				<tr>
					<td><input type="radio" name="id" value="${currentcomiclist.id}"></td>
					<td><h2>${currentcomiclist.custListName}</h2></td>
				</tr>
				<tr>
					<td colspan="6">Trip Date: ${currentcomiclist.tripDate}</td>
				</tr>
				<tr>
					<td colspan="6">Customer: ${currentcomiclist.customer.customerName}</td>
				</tr>
				<c:forEach var="listVal" items="${currentcomiclist.listOfComics}">
					<tr>
						<td></td>
						<td colspan="6">${listVal.publisher}, ${listVal.seriesTitle}, ${listVal.issueNum}, ${listVal.author}, ${listVal.illustrator}</td>
					</tr>
				</c:forEach>
			</c:forEach>
		</table>
		<input type="submit" value="edit" name="doThisToComic"> 
		<input type="submit" value="delete" name="doThisToComic"> 
		<input type="submit" value="add" name="doThisToComic">

	</form>
	<a href="addComicsForListServlet">Create a new customer list</a>
	<br />
	<a href="index.html">Insert a new comic</a>
</body>
</html>