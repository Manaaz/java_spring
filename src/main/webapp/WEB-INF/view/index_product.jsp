<!DOCTYPE html>

<html>
<head>
    <%--<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css" />--%>
</head>

<body>
<h1>Welcome index page products!</h1>

<form:form action="processFormOpenCatalog" modelAttribute="product">
    <input type="submit" value="Open catalog" />
</form:form>

</body>
</html>