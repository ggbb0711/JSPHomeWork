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

        <style>
            .ticket-container {
                padding: 20px;
                margin: 20px auto;
                max-width: 800px;
                border: 1px solid #e0e0e0;
                border-radius: 8px;
                background-color: #ffffff;
                box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
                transition: box-shadow 0.3s ease;
            }

            .ticket-container:hover {
                box-shadow: 0 4px 10px rgba(0, 0, 0, 0.15);
            }

            .ticket-section {
                margin-bottom: 25px;
                padding: 20px;
                background-color: #f7f7f7;
                border-radius: 5px;
            }

            .ticket-section h3 {
                color: #2c3e50;
                font-size: 1.5em;
                margin-bottom: 20px;
                padding-bottom: 10px;
                border-bottom: 2px solid #3498db;
                font-weight: 600;
            }

            .ticket-section p {
                margin: 10px 0;
                font-size: 1.1em;
                color: #444;
                line-height: 1.6;
            }

            .ticket-section strong {
                color: #2c3e50;
                font-weight: 600;
                min-width: 130px;
                display: inline-block;
            }

            .ticket-section p:not(:last-child) {
                border-bottom: 1px dashed #eee;
                padding-bottom: 10px;
            }
        </style>
    </head>
    <body>
        <!-- Header -->
        <jsp:include page="common/header.jsp"></jsp:include>

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
                                        <p><strong>Cart ID:</strong> ${ticket.car.carId}</p>
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

        <!-- Footer -->
        <jsp:include page="common/footer.jsp"></jsp:include>

        <script type="text/javascript" src="source/js/header-customer.js"></script>
        <script type="text/javascript" src="source/bootstrap-3.3.6-dist/js/jquery.js"></script>
        <script type="text/javascript" src="source/js/isotope.js"></script>
        <script type="text/javascript" src="source/js/myscript.js"></script> 
        <script type="text/javascript" src="source/bootstrap-3.3.6-dist/js/jquery.1.11.js"></script>
        <script type="text/javascript" src="source/bootstrap-3.3.6-dist/js/bootstrap.js"></script>
    </body>
</html>