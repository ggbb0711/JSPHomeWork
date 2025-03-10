<%-- 
    Document   : createServiceTicketPage
    Created on : 10-Mar-2025, 13:03:26
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
        
        <h4>Create Service Ticket</h4>
        <form action="${pageContext.request.contextPath}/sales-person/serviceTicket" method="post">
            <p>Enter Service Ticket ID</p>
            <p><input type="text" name="txtticketid" placeholder="Enter Service Ticket ID" /></p>
            <p>Choose Date Receive</p>
            <p><input type="date" name="txtdatereceive" /></p>
            <p>Choose Date Return</p>
            <p><input type="date" name="txtdatereturn" /></p>
            <p>Select Customer</p>
            <select name="txtcustid">
                <c:set var="custlist" scope="request" value="${requestScope.customerList}" />
                <c:if test="${not empty custlist}" >
                    <c:forEach var="cus" items="${custlist}" >
                        <option value="${cus.custID}"> ${cus.custID} - ${cus.custName} </option>
                    </c:forEach>
                </c:if>
            </select>
            <br/>
            <p>Select Car</p>
            <select name="txtcarid">
                <c:set var="carlist" scope="request" value="${requestScope.carlist}" />
                <c:if test="${not empty carlist}">
                    <c:forEach var="car" items="${carlist}" >
                        <option value="${car.carID}"> ${car.carID} - ${car.model} </option>
                    </c:forEach>
                </c:if>
            </select>
            <p><input type="submit" value="Create"/></p>
        </form>
                
    <c:if test="${not empty requestScope.createTicket}" >
        <c:out value="${requestScope.createTicket}" />
    </c:if>
</body>
</html>
