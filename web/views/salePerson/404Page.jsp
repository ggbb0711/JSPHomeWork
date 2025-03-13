<%-- 
    Document   : 404Page
    Created on : Feb 27, 2025, 9:18:23 AM
    Author     : NGHIA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>404 Error</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/style/reset.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/style/style.css">
    </head>
    <body>
        <jsp:include page="/views/salePerson/components/header.jsp"></jsp:include>
        <h1>404 Cannot find resource</h1>
        <p><%= request.getAttribute("message")!=null?request.getAttribute("message"):""%></p>
    </body>
</html>
