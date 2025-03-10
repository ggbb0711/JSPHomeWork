<%-- 
    Document   : updateCarPage
    Created on : 10-Mar-2025, 11:33:47
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
        
        <h3>Update Car</h3>
        <form action="${pageContext.request.contextPath}/sales-person/updateCars" method="post">
            <p>Car's ID:</p>
            <p><input type="text" name="txtid" required="" placeholder="Enter car id"/></p>
            <p>Car's Serial Number:</p>
            <p><input type="text" name="txtserial" required="" placeholder="Enter serial"/></p>
            <p>Car's Model:</p>
            <p><input type="text" name="txtmodel" required="" placeholder="Enter model"/></p>
            <p>Car's Colour:</p>
            <p><input type="text" name="txtcolour" required="" placeholder="Enter colour"/></p>
            <p>Year of Production:</p>
            <p><input type="text" name="txtyear" required="" placeholder="Enter year"/></p>
            <p><input type="submit" value="update" /></p>
        </form>
            <c:if test="${not empty requestScope.updateStatus}">
                <h4><c:out value="${requestScope.updateStatus}" /></h4>
            </c:if>
    </body>
</html>
