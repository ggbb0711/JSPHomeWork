<%-- 
    Document   : invoicecustomer
    Created on : Mar 16, 2025, 2:05:11 PM
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:choose>
                <c:when test="${empty invoices}">
                    <p class="text-center">No sale invoices found.</p>
                </c:when>
                <c:otherwise>
                    <c:forEach items="${invoices}" var="invoice">
                        <div class="invoice-container">
                            <div class="row">
                                <div class="col-md-12">
                                    <!-- Invoice Information -->
                                    <div class="invoice-section">
                                        <h3>Invoice Information</h3>
                                        <p><strong>Invoice ID:</strong> ${invoice.invoiceID}</p>
                                        <p><strong>Invoice Date:</strong> 
                                            <fmt:formatDate value="${invoice.invoiceDate}" pattern="yyyy-MM-dd"/>
                                        </p>
                                    </div>

                                    <!-- Customer Information -->
                                    <div class="invoice-section">
                                        <h3>Customer Information</h3>
                                        <p><strong>Name:</strong> ${invoice.customer.custName}</p>
                                        <p><strong>Phone:</strong> ${invoice.customer.phone}</p>
                                    </div>

                                    <!-- Car Information -->
                                    <div class="invoice-section">
                                        <h3>Car Information</h3>
                                        <p><strong>Car ID:</strong> ${invoice.car.carId}</p>
                                        <p><strong>Serial Number:</strong> ${invoice.car.serialNumber}</p>
                                        <p><strong>Model:</strong> ${invoice.car.model}</p>
                                        <p><strong>Color:</strong> ${invoice.car.colour}</p>
                                        <p><strong>Year:</strong> ${invoice.car.year}</p>
                                    </div>

                                    <!-- Sales Person Information -->
                                    <div class="invoice-section">
                                        <h3>Sales Person Information</h3>
                                        <p><strong>Name:</strong> ${invoice.salePerson.salesName}</p>
                                        <!-- Add more sales person fields as needed -->
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </c:otherwise>
            </c:choose>
    
    </body>
</html>
