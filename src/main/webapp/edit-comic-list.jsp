<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit A Customer Comic List</title>
</head>
<body>
<form action = "editComicListServlet" method="post">
<input type ="hidden" name = "id" value= "${custListToEdit.id}">
Customer List Name: <input type ="text" name = "custListName" value= "${custListToEdit.custListName}"><br />
Trip date: <input type ="text" name = "month" placeholder="mm" size="4" value= "${month}"> <input type ="text" name = "day" placeholder="dd" size="4" value= "${date}">, <input type ="text" name = "year" placeholder="yyyy" size="4" value= "${year}">
Customer Name: <input type = "text" name = "customerName" value= "${custListToEdit.customer.customerName}"><br />

Available Comics:<br />

<select name="allComicsToAdd" multiple size="12">
<c:forEach items="${requestScope.showAllComics}" var="currentcomic">
   <option value = "${currentcomic.id}">${currentcomic.publisher} | ${currentcomic.seriesTitle} | ${currentcomic.issueNum}> | ${currentcomic.author} | ${currentcomic.illustrator}</option>
</c:forEach>
</select>
<br />
<input type = "submit" value="Edit comics and customer lists">
</form>
<a href = "index.html">Go add new comics instead.</a>
</body>
</html>