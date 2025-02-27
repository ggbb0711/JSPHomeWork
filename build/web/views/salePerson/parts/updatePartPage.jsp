<%-- 
    Document   : updatePartPage
    Created on : Feb 27, 2025, 1:21:42 PM
    Author     : NGHIA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Parts</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/style/reset.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/style/style.css">
    </head>
    <body>
        <jsp:include page="/views/salePerson/components/header.jsp"></jsp:include>
        <div class="page-container">
            <jsp:include page="./components/updatePartsForm.jsp"></jsp:include>
        </div>
    </body>
</html>
