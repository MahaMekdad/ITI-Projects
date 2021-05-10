<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
    <body>
        <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
        <form:form method="POST" modelAttribute="user" action="${contextPath}/register">
            <b>Name:</b>
            <form:input path="name"/>
            <form:errors path="name" delimiter=","/>
            <br/>
            <b>Age:</b>
            <form:input path="age"/>
            <form:errors path="age" delimiter=","/>
            <br/>
            <b>Phone:</b>
            <form:input path="phone"/>
            <form:errors path="phone" delimiter=","/>
            <br/>
            <b>Email:</b>
            <form:input path="email"/>
            <form:errors path="email" delimiter=","/>
            <br/>
            <input type="submit"/>
        </form:form>
    </body>
</html>

