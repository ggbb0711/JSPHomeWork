<%-- 
    Document   : deleteCarPage
    Created on : 10-Mar-2025, 11:45:07
    Author     : bluax
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/style/reset.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/style/style.css">
    </head>
    <body>
        <div class="sticky-header">
            <jsp:include page="/views/salePerson/components/header.jsp"></jsp:include>
            <jsp:include page="./components/subHeader.jsp"></jsp:include>
        </div>
        
        <h3>Delete Car</h3>
                
        <form action="${pageContext.request.contextPath}/sales-person/deleteCars" method="post">
            <p>Enter Car id</p>
            <p><input type="text" name="txtid" placeholder="enter car ID" /></p>
            <p><input type="submit" value="delete" /></p>
        </form>
            <c:if test="${not empty requestScope.deleteCar }">
                <h4><c:out value="${requestScope.deleteCar}" /></h4>
            </c:if>
    </body>
</html>
