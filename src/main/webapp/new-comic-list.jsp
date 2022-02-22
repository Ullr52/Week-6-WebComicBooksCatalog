<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create a new list</title>
</head>
<body>
<form action = "createNewComicListServlet" method="post">
List Name: <input type="text" name = "custListName"><br />
Trip Date: <input type="text" name = "month" placeholder="mm" size="4">
<input type="text" name = "day" placeholder="dd" size="4">
<input type="text" name = "year" placeholder="yyyy" size="4">
Customer Name: <input type="text" name = "customerName"><br />

Available Comics:<br />
<select name = "allComicsToAdd" multiple size = "12">
<c:forEach items = "${requestScope.showAllComics}" var="currentcomic">
<option value = "${currentcomic.id}"> ${currentcomic.publisher} | ${currentcomic.seriesTitle} |  ${currentcomic.issueNum} | ${currentcomic.author} | ${currentcomic.illustrator} </option>
</c:forEach>
</select>
<br />
<input type="submit" value="Create Want List and Add Comics">

</form>
<a href="index.html">Go add new comics instead</a>
</body>
</html>