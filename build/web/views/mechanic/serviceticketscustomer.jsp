<%-- 
    Document   : serviceticketscustomer
    Created on : Mar 16, 2025, 2:07:21 PM
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Service Tickets - GARAGE Management</title>
        <meta name="description" content="Service Ticket Management System">
        <meta name="author" content="YourName">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <link rel="stylesheet" type="text/css" href="source/bootstrap-3.3.6-dist/css/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="source/font-awesome-4.5.0/css/font-awesome.css">
        <link rel="stylesheet" type="text/css" href="style/slider.css">
        <link rel="stylesheet" type="text/css" href="style/mystyle.css">
        <link rel="stylesheet" type="text/css" href="source/custom-css/header-customer.css">

       
        <!-- Header -->
       

            <div class="allcontain">
                <h1 class="text-center">• SERVICE TICKETS •</h1>

            <c:choose>
                <c:when test="${empty tickets}">
                    <p class="text-center">No service tickets found.</p>
                </c:when>
                <c:otherwise>
                    <c:forEach items="${tickets}" var="ticket">
                        <div class="ticket-container">
                            <div class="row">
                                <div class="col-md-12">
                                    <!-- Ticket Information -->
                                    <div class="ticket-section">
                                        <h3>Ticket Information</h3>
                                        <p><strong>Ticket ID:</strong> ${ticket.serviceTicketID}</p>
                                        <p><strong>Date Received:</strong> 
                                            <fmt:formatDate value="${ticket.dateReturned}" pattern="yyyy-MM-dd"/>
                                        </p>
                                        <p><strong>Date Returned:</strong> 
                                            <c:choose>
                                                <c:when test="${empty ticket.dateReturned}">
                                                    Not yet returned
                                                </c:when>
                                                <c:otherwise>
                                                    <fmt:formatDate value="${ticket.dateReturned}" pattern="yyyy-MM-dd"/>
                                                </c:otherwise>
                                            </c:choose>
                                        </p>
                                        <p><strong>Cart ID:</strong> ${ticket.car.carID}</p>
                                        <p><strong>Serial Number:</strong> ${ticket.car.serialNumber}</p>
                                        <p><strong>Model:</strong> ${ticket.car.model}</p>
                                        <p><strong>Color:</strong> ${ticket.car.colour}</p>
                                        <p><strong>Year:</strong> ${ticket.car.year}</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </c:otherwise>
            </c:choose>
        </div>


        <script type="text/javascript" src="source/js/header-customer.js"></script>
        <script type="text/javascript" src="source/bootstrap-3.3.6-dist/js/jquery.js"></script>
        <script type="text/javascript" src="source/js/isotope.js"></script>
        <script type="text/javascript" src="source/js/myscript.js"></script> 
        <script type="text/javascript" src="source/bootstrap-3.3.6-dist/js/jquery.1.11.js"></script>
        <script type="text/javascript" src="source/bootstrap-3.3.6-dist/js/bootstrap.js"></script>
    </body>
</html>