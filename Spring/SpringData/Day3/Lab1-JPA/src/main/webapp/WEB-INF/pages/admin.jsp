<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<html>
    <head>
        <title>Admin</title>
    </head>
    <body>
        <h2>${title}</h2>
        <h3>${message}</h3>
        <br/>
        <sec:authorize access="isAuthenticated()">
            <a href="${pageContext.request.contextPath}/logout">Logout</a>
        </sec:authorize>
    </body>
</html>