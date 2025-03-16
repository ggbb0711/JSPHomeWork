<%-- 
    Document   : manageservice
    Created on : Mar 16, 2025, 2:06:32 PM
    Author     : USER
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Manage Services</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
        <link rel="stylesheet" type="text/css" href="source/custon-css/dashboard-custom.css">
    </head>
    <body>
        <jsp:include page="common/side-bar-dashboard.jsp"></jsp:include>

            <!-- Main Content -->
            <div class="content">
                <h2>Manage Services</h2>

                <!-- Search Form -->
                <form action="manage-services">
                    <div class="row mb-3">
                        <div class="col-md-4">
                            <input type="text" name="serviceName" id="searchServiceName" class="form-control" 
                                   placeholder="Search by Service Name" value="${param.serviceName}">
                    </div>
                    <div class="col-md-4">
                        <input type="number" step="0.01" name="hourlyRate" id="searchHourlyRate" class="form-control" 
                               placeholder="Search by Hourly Rate" value="${param.hourlyRate}">
                    </div>
                    <div class="col-md-4 d-flex">
                        <button class="btn btn-primary me-2" name="action" value="search">Search</button>
                        <a href="manage-services" class="btn btn-secondary me-2">Reset</a>
                        <button type="button" class="btn btn-success" data-bs-toggle="modal" 
                                data-bs-target="#addServiceModal">Add New Service</button>
                    </div>
                </div>
            </form>

            <!-- Service Table -->
            <table class="table table-bordered">
                <thead class="table-dark">
                    <tr>
                        <th>Service ID</th>
                        <th>Service Name</th>
                        <th>Hourly Rate ($)</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody id="serviceTableBody">
                    <c:forEach items="${services}" var="service">
                        <tr>
                            <td>${service.serviceID}</td>
                            <td>${service.serviceName}</td>
                            <td>${service.hourlyRate}</td>
                            <td>
                                <a href="manage-services?action=edit&serviceId=${service.serviceID}" 
                                   class="btn btn-warning btn-sm">Edit</a>
                                <a href="manage-services?action=delete&serviceId=${service.serviceID}" 
                                   class="btn btn-danger btn-sm" 
                                   onclick="return confirm('Are you sure you want to delete this service?');">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>

        <!-- Add Service Modal -->
        <div class="modal fade" id="addServiceModal" tabindex="-1" aria-labelledby="addServiceModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form action="manage-services" method="post">
                        <div class="modal-header">
                            <h5 class="modal-title" id="addServiceModalLabel">Add New Service</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <div class="mb-3">
                                <label for="serviceName" class="form-label">Service Name</label>
                                <input type="text" class="form-control" id="serviceName" name="serviceName" required>
                            </div>
                            <div class="mb-3">
                                <label for="hourlyRate" class="form-label">Hourly Rate ($)</label>
                                <input type="number" step="0.01" class="form-control" id="hourlyRate" name="hourlyRate" required>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                            <button type="submit" class="btn btn-primary" name="action" value="add">Add Service</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>