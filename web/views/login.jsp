<%-- 
    Document   : card
    Created on : Feb 27, 2025, 9:22:10 PM
    Author     : NGHIA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/style/reset.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/style/style.css">
    </head>
    <body class="screen-container">
        <div class="login-card">
            <h1>LOGIN AS:</h1>
            <a href="${pageContext.request.contextPath}/login/sales-person">
                <button class="btn btn-primary">SALE PERSON</button>
            </a>
            <a href="${pageContext.request.contextPath}/customer/login">
                <button class="btn btn-primary">CUSTOMER</button>
            </a>
        </div>
    </body>
</html>
