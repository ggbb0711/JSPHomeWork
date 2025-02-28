<%-- 
    Document   : partPage
    Created on : Feb 27, 2025, 12:19:24 PM
    Author     : NGHIA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="utils.constant.Routes"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Parts</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/style/reset.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/style/style.css">
    </head>
    <body>
        <div class="sticky-header">
            <jsp:include page="/views/salePerson/components/header.jsp"></jsp:include>
        </div>        <div class="page-container">
            <a href="${pageContext.request.contextPath}/sales-person/CreatePartsServlet">
                <button class="btn btn-primary">+ Add</button>
            </a>
            <jsp:include page="./components/partList.jsp"></jsp:include>
        </div>
    </body>
</html>
