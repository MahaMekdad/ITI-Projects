<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <body>
        <h1>Users</h1>
        <c:if test="${! empty users}">
            <c:forEach items="${users}" var = "i">
                <label>${i}</label>
            </c:forEach>
        </c:if>
        <!-- <c:forEach items="${users}" var = "i">
                <label>${i}</label>
            </c:forEach> -->
        <c:if test="${! empty user}">
            <label>${user}</label>
        </c:if>
    </body>
</html>