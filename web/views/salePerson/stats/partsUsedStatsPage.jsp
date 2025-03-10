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
        <title>Parts Used Stats</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/style/reset.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/style/style.css">
    </head>
    <body>
        <div class="sticky-header">
            <jsp:include page="/views/salePerson/components/header.jsp"></jsp:include>
            <jsp:include page="./components/subHeader.jsp"></jsp:include>
        </div>   
        <div class="page-container">
            <div>
                <h1>MOST USED PARTS</h1>
                <jsp:include page="./components/mostUsedPartsTable.jsp"></jsp:include>
            </div>
        </div>
    </body>
</html>
