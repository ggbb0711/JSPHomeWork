<%-- 
    Document   : 403ForbiddenPage
    Created on : Mar 14, 2025, 9:50:32 PM
    Author     : NGHIA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>403 Forbidden</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/style/reset.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/style/style.css">
    </head>
    <body>
        <h1>403 Forbidden</h1>
        <p>You are not login</p>
        <a href="${pageContext.request.contextPath}/">
            <button class="btn btn-primary">To login</button>
        </a>
    </body>
</html>
