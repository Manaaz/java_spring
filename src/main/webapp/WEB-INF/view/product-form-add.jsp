<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>
<body>
<form:form action="addProductOpenCatalog" modelAttribute="product">
    id: <form:input path="id" />
    <br>
    title: <form:input path="title" />
    <br>
    cost: <form:input path="cost" />
    <br>
    <input type="submit" value="Add new product" />
</form:form>
</body>
</html>