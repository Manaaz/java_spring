<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>
<body>
<form:form action="processForm" modelAttribute="product">
    id: <form:input path="id" />
    <br>
    title: <form:input path="title" />
    <br>
    cost: <form:input path="cost" />
</form:form>
</body>
</html>