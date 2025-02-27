<%-- 
    Document   : partsUsedStatsPage
    Created on : Feb 28, 2025, 12:31:32 AM
    Author     : NGHIA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Top mechanics</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/style/reset.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/style/style.css">
    </head>
    <body>
        <jsp:include page="/views/salePerson/components/header.jsp"></jsp:include>
        <jsp:include page="./components/subHeader.jsp"></jsp:include>
        <div class="page-container">
            <div>
                <h1>TOP MECHANICS</h1>
                <jsp:include page="./components/topMechanicTable.jsp"></jsp:include>
            </div>
        </div>
    </body>
</html>
