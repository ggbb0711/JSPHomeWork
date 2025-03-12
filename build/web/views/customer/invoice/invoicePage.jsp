<%-- 
    Document   : invoicePage
    Created on : Feb 28, 2025, 9:41:59 AM
    Author     : NGHIA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Your invoices</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/style/reset.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/style/style.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200&icon_names=shopping_cart" />
    </head>
    <body>
        <div class="sticky-header">
            <jsp:include page="/views/customer/components/header.jsp"></jsp:include>
        </div>  
        <div class="page-container">
            <h1>YOUR INVOICES</h1>
            <div class="scrollable-table">
                <table>
                    <tr>
                        <th>CarID</th>
                        <th>Serial number</th>
                        <th>Model</th>
                        <th>Colour</th>
                        <th>Year</th>
                        <th>Purchase date</th>
                        <th>Money spent</th>
                    </tr>

                    <c:forEach var="data" items="${customerInvoices}">
                        <tr>
                            <td>${data.getCar().getCarID()}</td>
                            <td>${data.getCar().getSerialNumber()}</td>
                            <td>${data.getCar().getModel()}</td>
                            <td>${data.getCar().getColour()}</td>
                            <td>${data.getCar().getYear()}</td>
                            <td>${data.getInvoiceDate()}</td>
                            <td>${data.getRevenue()}</td>
                        </tr>
                    </c:forEach>

                </table>
            </div>

        </div>
    </body>
</html>
