<%-- 
    Document   : readServiceTicketPage
    Created on : 10-Mar-2025, 13:19:00
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

            <h4>View Service Ticket</h4>
            <form action="${pageContext.request.contextPath}/sales-person/readServiceTicket" method="get">
                <p>Find Service Ticket</p>
                <p><input type="text" name="txtid" placeholder="enter ticket id" /></p>
                <p><input type="submit" value="Find" /></p>
            </form>

        <c:if test="${not empty requestScope.findserviceticket}" >
            <c:out value="${requestScope.findserviceticket}" />
        </c:if>

    <c:set var="ticketlist" scope="request" value="${requestScope.ticketlist}" />
    <c:if test="${not empty ticketlist}" >
        <table>
            <tr>
                <th>Ticket ID</th>
                <th>Date Receive</th>
                <th>Date Return</th>
                <th>Customer ID</th>
                <th>Car ID</th>
            </tr>

            <c:forEach var="ticket" items="${ticketlist}" >
                <tr>
                    <td>${ticket.serviceTicketID}</td>
                    <td>${ticket.dateReceived}</td>
                    <td>${ticket.dateReturned}</td>
                    <td>${ticket.custID}</td>
                    <td>${ticket.carID}</td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</body>
</html>
