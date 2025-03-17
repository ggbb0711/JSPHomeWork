<%-- 
    Document   : editserviceticket
    Created on : Mar 16, 2025, 2:03:21 PM
    Author     : USER
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Edit Service Ticket</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="source/custon-css/dashboard-custom.css">
    </head>
    <body>
        <jsp:include page="common/side-bar-dashboard.jsp"></jsp:include>

            <!-- Main Content -->
            <div class="content">
                <h2>Edit Service Ticket</h2>
                <input type="hidden" name="ticketId" value="${ticket.serviceTicketID}">

            <!-- Ticket Information -->
            <h4>Service Ticket Information</h4>
            <div class="mb-3">
                <label class="form-label">Service Ticket ID:</label>
                <input type="text" class="form-control" value="${ticket.serviceTicketID}" disabled>
            </div>
            <div class="mb-3">
                <label class="form-label">Date Received:</label>
                <input type="date" class="form-control" value="${ticket.dateReceived}" disabled>
            </div>
            <div class="mb-3">
                <label class="form-label">Date Returned:</label>
                <input type="date" class="form-control" value="${ticket.dateReturned}" disabled>
            </div>

            <!-- Customer Information -->
            <h4>Customer Information</h4>
            <div class="mb-3">
                <label class="form-label">Customer Name:</label>
                <input type="text" class="form-control" value="${ticket.customer.custName}" disabled>
            </div>
            <div class="mb-3">
                <label class="form-label">Phone:</label>
                <input type="text" class="form-control" value="${ticket.customer.phone}" disabled>
            </div>

            <!-- Car Information -->
            <h4>Car Information</h4>
            <div class="mb-3">
                <label class="form-label">Model:</label>
                <input type="text" class="form-control" value="${ticket.car.model}" disabled>
            </div>
            <div class="mb-3">
                <label class="form-label">Color:</label>
                <input type="text" class="form-control" value="${ticket.car.colour}" disabled>
            </div>

            <!-- Service Mechanic Information -->
            <h4>Service Mechanic Information</h4>
            <div class="table-responsive">
                <table class="table table-striped table-bordered">
                    <thead>
                        <tr>
                            <th>Mechanic</th>
                            <th>Service Name</th>
                            <th>Hours Worked</th>
                            <th>Comment</th>
                            <th>Rate per Hour</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="servicesMechanic" items="${servicesMechanic}">
                        <form action="editTicket" method="POST">
                            <tr>
                                <!-- Hiển thị Mechanic ID và Name, tránh load trùng -->
                                <td>
                                    <c:set var="mechanicName" value="Unknown Mechanic" />
                                    <c:set var="found" value="false" />
                                    <c:set var="mechanicId" value="" />

                                    <c:forEach var="mechanic" items="${mechanics}">
                                        <c:if test="${mechanic.mechanicID == servicesMechanic.mechanicID && found == 'false'}">
                                            <c:set var="mechanicName" value="${mechanic.mechanicID} | ${mechanic.mechanicName}" />
                                            <c:set var="mechanicId" value="${mechanic.mechanicID}" />
                                            <c:set var="found" value="true" />
                                        </c:if>
                                    </c:forEach>

                                    <!-- Input hiển thị Mechanic Name -->
                                    <input type="text" class="form-control" value="${mechanicName}" disabled>

                                    <!-- Input ẩn để submit mechanicId -->
                                    <input type="hidden" name="mechanicId" value="${mechanicId}">
                                </td>

                                <!-- Hiển thị Service ID và Name, tránh load trùng -->
                                <td>
                                    <c:set var="serviceName" value="Unknown Service" />
                                    <c:set var="foundService" value="false" />
                                    <c:forEach var="service" items="${services}">
                                        <c:if test="${service.serviceID == servicesMechanic.serviceID && foundService == 'false'}">
                                            <c:set var="serviceName" value="${service.serviceID} | ${service.serviceName}" />
                                            <c:set var="foundService" value="true" />
                                        </c:if>
                                    </c:forEach>
                                    <input type="text" class="form-control" value="${serviceName}" disabled>
                                    <input type="hidden" name="serviceId" value="${servicesMechanic.serviceID}">
                                </td>

                                <td><input type="number" name="hours" class="form-control" value="${servicesMechanic.hours}"></td>
                                <td><input type="text" name="comment" class="form-control" value="${servicesMechanic.commment}"></td>
                                <td><input type="number" name="rate" class="form-control" value="${servicesMechanic.rate}"></td>
                                <td>
                                    <button type="submit" name="ticketId" value="${servicesMechanic.serviceTicketID}" class="btn btn-primary btn-sm">Update</button>
                                </td>
                            </tr>
                        </form>
                    </c:forEach>
                    </tbody>
                </table>
            </div>

            <!-- Cancel Button -->
            <a href="manage-service-tickets" class="btn btn-secondary">Cancel</a>

        </div>
    </body>
</html>