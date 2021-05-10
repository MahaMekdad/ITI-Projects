<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
    <body>
        <form method="POST" action="uploadFile" enctype="multipart/form-data">
            File to upload: <input type="file" name="file">
            Name: <input type="text" name="name">
            <input type="submit" value="Upload"> 
        </form>
    </body>
</html>