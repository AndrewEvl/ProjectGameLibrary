<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Countries</h1>
<h3>Страны</h3>
<form method="post">
    <select name="listCountries" id="listCountries">
        <c:forEach items="${requestScope.listCountries}" var="listCountries">
            <option value="${listCountries.id}">${listCountries.name} </option>
        </c:forEach>
    </select>
</form>
</body>
</html>
