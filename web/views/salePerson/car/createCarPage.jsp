<%-- 
    Document   : createCarPage
    Created on : 10-Mar-2025, 10:42:07
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
        
        <h3>Create Car</h3>
        <form action="${pageContext.request.contextPath}/sales-person/cars" method="post">
            <p>Enter Car's ID:</p>
            <p><input type="text" name="txtcarid" required="" placeholder="Enter car id" /></p>
            <p>Enter Car's Serial Number:</p>
            <p><input type="text" name="txtserialnumber" required="" placeholder="Enter Car Serial" /></p>
            <p>Enter Car's Model:</p>
            <p><input type="text" name="txtmodel" required="" placeholder="Enter model" /></p>
            <p>Enter Car's Colour:</p>
            <p><input type="text" name="txtcolour" required="" placeholder="Enter colour" /></p>
            <p>Enter Year of Production:</p>
            <p><input type="text" name="txtyear" required="" placeholder="Enter year" /></p>
            <p><input type="submit" name="Create" /></p>
        </form>
        
        <c:if test="${not empty requestScope.checkID}">
            <h4><c:out value="${requestScope.checkID}"/></h4>
        </c:if >
        
        <c:if test="${not empty requestScope.createCar}">
            <h4><c:out value="${requestScope.createCar}" /></h4>
        </c:if>
    </body>
</html>
