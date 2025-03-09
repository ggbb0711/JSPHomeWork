<%-- 
    Document   : SalesServiceTicket
    Created on : 09-Mar-2025, 08:50:34
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
        <jsp:include page="/views/salePerson/components/header.jsp"></jsp:include>
        <c:set var="sp" scope="session" value="${sessionScope.saleperson}" />
        <c:if test="${empty sp}">
            <c:set var="error" scope="request" value="You must login" />
            <jsp:forward page="index.jsp" />
        </c:if>
        
        <c:if test="${not empty sp}" >
            <h3>Welcome back ${sp.name} </h3>

                <h3>Menu</h3>
                <h4>Create Service Ticket</h4>
                    <form action="createServiceTicketServlet">
                        <p><input type="text" name="txtticketid" placeholder="Enter Service Ticket ID" /></p>
                        <p>Date Receive</p>
                        <p><input type="date" name="txtdatereceive" /></p>
                        <p>Date Return</p>
                        <p><input type="date" name="txtdatereturn" /></p>
                        <select name="txtcustid">
                            <c:set var="custlist" scope="session" value="${sessionScope.customerList}" />
                            <c:if test="${not empty custlist}" >
                                <c:forEach var="cus" items="${custlist}" >
                                    <option value="${cus.custID}"> ${cus.custID} - ${cus.custName} </option>
                                </c:forEach>
                            </c:if>
                        </select>
                        <br/>
                        <select name="txtcarid">
                            <c:set var="carlist" scope="session" value="${sessionScope.carlist}" />
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
                    

                <h4>View Service Ticket</h4>
                <form action="findServiceTicketServlet" >
                    <p>Find Service Ticket</p>
                    <p><input type="text" name="txtid" placeholder="enter ticket id" /></p>
                    <p><input type="submit" value="Find" /></p>
                </form>
                
                <c:if test="${not empty requestScope.findserviceticket}" >
                    <c:out value="${requestScope.findserviceticket}" />
                </c:if>
                
                <c:set var="ticketlist" scope="session" value="${sessionScope.ticketlist}" />
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
                                <td>${ticket.custId}</td>
                                <td>${ticket.carId}</td>
                            </tr>
                        </c:forEach>
                        
                    </table>
                </c:if>
        </c:if>

    </body>
</html>
