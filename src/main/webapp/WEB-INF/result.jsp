<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Results</title>
</head>
<body>
<b>Results</b>
<c:forEach items="${results}" var="result">
<p>${result.getString("Type")}</p>
<p>${result.getString("Year")}</p>
<p>${result.getString("Title")}</p>
<p>Poster: <img src="${result.getString("Poster")}"/>
</c:forEach>
</body>
</html>