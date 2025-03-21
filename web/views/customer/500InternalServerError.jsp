<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>500 Internal server error</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/style/reset.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/style/style.css">
    </head>
    <body>
        <jsp:include page="/views/customer/components/header.jsp"></jsp:include>
        <h1>500 Internal server error</h1>
        <p>A problem has occured with the server please contact the maintainer.</p>
        <p><%= request.getAttribute("message")!=null?request.getAttribute("message"):""%></p>
    </body>
</html>