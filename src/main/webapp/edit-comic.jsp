<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>edit comic</title>
</head>
<body>
<h2>Here you can edit your comics</h2>
<form action = "editComicServlet" method="post">
Edit Publisher: <input type ="text" name = "publisher" value= "${comicToEdit.publisher}">
Edit Series: <input type = "text" name = "seriesTitle" value= "${comicToEdit.seriesTitle}">
Edit Issue Number: <input type ="text" name = "issueNum" value= "${comicToEdit.issueNum}">
Edit Author: <input type = "text" name = "author" value= "${comicToEdit.author}">
Edit Illustrator: <input type = "text" name = "illustrator" value= "${comicToEdit.illustrator}">
<input type = "hidden" name = "id" value="${comicToEdit.id}">
<input type = "submit" value="Save Edited Item">
</form>

</body>
</html>