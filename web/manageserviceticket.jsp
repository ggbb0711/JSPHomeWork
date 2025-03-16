<%-- 
    Document   : manageserviceticket
    Created on : Mar 16, 2025, 2:06:01 PM
    Author     : USER
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Admin Dashboard</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
        <link rel="stylesheet" type="text/css" href="source/custon-css/dashboard-custom.css">
    </head>
    <body>

        <jsp:include page="common/side-bar-dashboard.jsp"></jsp:include>

            <!-- Main Content -->
            <div class="content">
                <h2>Manage Service Ticket</h2>

                <!-- Search Form -->
                <form action="manage-service-tickets">
                    <div class="row mb-3">
                        <div class="col-md-3">
                            <input type="text" name="carId" id="searchCarId" class="form-control" placeholder="Search by Car ID">
                        </div>
                        <div class="col-md-3">
                            <input type="text" name="custId" id="searchCustomerId" class="form-control" placeholder="Search by Customer ID">
                        </div>
                        <div class="col-md-3">
                            <input type="date" name="dateReceived" id="searchDateReceived" class="form-control">
                        </div>
                        <div class="col-md-3 d-flex">
                            <button class="btn btn-primary me-2" name="action" value="filter">Search</button>
                            <a href="manage-service-tickets" class="btn btn-secondary">Reset</a>
                        </div>
                    </div>
                </form>          

                <!-- Service Ticket Table -->
                <table class="table table-bordered">
                    <thead class="table-dark">
                        <tr>
                            <th>Service Ticket ID</th>
                            <th>Date Received</th>
                            <th>Date Returned</th>
                            <th>Customer</th>
                            <th>Car</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody id="ticketTableBody">
                    <c:forEach items="${tickets}" var="tickets">
                        <tr>
                            <td>${tickets.serviceTicketID}</td>
                            <td>${tickets.dateReceived}</td>
                            <td>${tickets.dateReturned}</td>
                            <td>${tickets.customer.custID} | ${tickets.customer.custName}</td>
                            <td>${tickets.car.carId} | ${tickets.car.model}</td>
                            <td>
                                <a href="manage-service-tickets?action=Edit&ticketId=${tickets.serviceTicketID}" class="btn btn-warning btn-sm">Edit</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>