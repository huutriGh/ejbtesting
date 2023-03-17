<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nguyen huu tri
  Date: 17/03/2023
  Time: 8:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="person" method="post">
    <p>
        <input name="id" type="hidden" value="${person.id}">
    </p>
    <p>
        <input name="name" type="text" value="${person.name}" placeholder="Name">
    </p>

    <p>
        <c:forEach items="${person.phones}" var="phone">
            <input name="number_${phone.id}"  value="${phone.number}" placeholder="Number" >
        </c:forEach>
    </p>

    <p>
        <input type="submit" value="update" name="action">
    </p>


</form>
</body>
</html>
