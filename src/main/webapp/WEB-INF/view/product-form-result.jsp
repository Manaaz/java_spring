<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>
<body>

<h1>Product Form Result</h1>
<br>
id: ${product.id}
<br>
title: ${product.title}
<br>
cost: ${product.cost}
<br>

<form:form action="../processFormOpenCatalog" modelAttribute="product">
    <input type="submit" value="Open catalog" />
</form:form>

</body>
</html>