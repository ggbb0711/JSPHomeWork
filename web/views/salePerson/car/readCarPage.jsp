<%-- 
    Document   : readCarPage
    Created on : 10-Mar-2025, 11:26:45
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
        
        <h3>Find car</h3>
        <form action="${pageContext.request.contextPath}/sales-person/readCars" method="get">
                    <p><input type="text" name="txtserialnumber" value="${not empty requestScope.findserial ? requestScope.findserial:''}" placeholder="enter serial number"></p>
                    <p><input type="text" name="txtmodel" value="${not empty requestScope.findmodel ? requestScope.findmodel : '' }"
                              placeholder="enter model"></p>
                    <p><input type="text" name="txtyear" value="${not empty requestScope.findyear ? requestScope.findyear :''}" placeholder="enter year" ></p>
                    <p><input type="submit" value="find"></p>
                </form>
                
                <c:set var="carlist" scope="request" value="${requestScope.carlist}" />
                    <c:if test="${not empty requestScope.findCar}">
                        <c:out value="${requestScope.findCar}"/>
                    </c:if>
                    <c:if test="${not empty carlist}">
                        <table>
                            <tr>
                                <th>Car ID</th>
                                <th>Serial Number</th>
                                <th>Model</th>
                                <th>Colour</th>
                                <th>Year</th>
                            </tr>
                        
                            
                            <c:forEach var="car" items="${carlist}">
                                <tr>
                                    <td>${car.carID}</td>
                                    <td>${car.serialNumber}</td>
                                    <td>${car.model}</td>
                                    <td>${car.colour}</td>
                                    <td>${car.year}</td>
                                </tr>
                            </c:forEach>
                        
                        </table>
                    </c:if>
        
    </body>
</html>
