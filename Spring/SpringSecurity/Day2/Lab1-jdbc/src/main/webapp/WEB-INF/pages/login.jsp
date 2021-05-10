<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
    <head>
        <title>Login</title>
    </head>
    <body>
        <c:if test="${! empty msg}">
            <label>${msg}</label>
        </c:if>
        <c:if test="${! empty error}">
            <label>${error}</label>
        </c:if>
        <form name="loginForm" action="<c:url value='/submitlogin'/>" method="POST">
            <table>
                <tr>
                    <td>User:</td>
                    <td><input type="text" name="user"/></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input type="password" name="pass"/></td>
                </tr>
                <tr colspan="2">
                    <td><input type="submit" value="submit"/></td>
                </tr>
                <tr>
                    <label for="remember-me">Remember me</label>
                    <input name="remember-me" type="checkbox"/>
                </tr>
            </table>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>

        <!-- <form:form name="loginForm" action="${pageContext.request.contextPath}/submitlogin'/>" method="POST">
            <table>
                <tr>
                    <td>User:</td>
                    <td><input type="text" name="user"/></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input type="password" name="pass"/></td>
                </tr>
                <tr colspan="2">
                    <td><input type="submit" value="submit"/></td>
                </tr>
                <tr>
                    <input name="remember-me" type="checkbox"/>
                </tr>
            </table>
        </form:form> -->
    </body>
</html>