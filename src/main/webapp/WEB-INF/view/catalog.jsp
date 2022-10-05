<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css" />
</head>

<body>
<h1>Catalog</h1>

<table border=1>
    <tr>
        <td>id</td>
        <td>title</td>
        <td>cost</td>
    </tr>
    <c:forEach var="item" items="${products}">
        <tr>
            <td>${item.id}</td>
            <td>${item.title}</td>
            <td>${item.cost}</td>
        </tr>
    </c:forEach>
</table>

<br>

<form:form action="addProduct">
    <input type="submit" value="Submit" />
</form:form>

</body>
</html>