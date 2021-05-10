<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<html>
    <head>
        <title>Welcome</title>
    </head>
    <body>
        <sec:authorize access="isAuthenticated()">
            Welcome: <sec:authentication property="principal.username"/>
        </sec:authorize>
        <br/>
        <h2>${title}</h2>
        <h3>${message}</h3>
        <br/>
        <sec:authorize access="hasRole('ROLE_ADMIN')">
            <h1>This is visible only cus u are an admin</h1>
        </sec:authorize>
        <br/>
        <sec:authorize access="isAuthenticated()">
            <a href="${pageContext.request.contextPath}/logout">Logout</a>
        </sec:authorize>
    </body>
</html>