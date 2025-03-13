
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Available car</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/style/reset.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/style/style.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200&icon_names=shopping_cart" />
    </head>
    <body
        <div class="sticky-header">
            <jsp:include page="/views/customer/components/header.jsp"></jsp:include>
        </div>  
        <div class="page-container">
            <h1>AVAILABLE CAR</h1>
            <div>
                <table>
                    <tr>
                        <th>CarID</th>
                        <th>Serial number</th>
                        <th>Model</th>
                        <th>Colour</th>
                        <th>Year</th>
                        <th></th>
                    </tr>

                    <c:forEach var="data" items="${availableCar}">
                        <tr>
                            <td>${data.getCarID()}</td>
                            <td>${data.getSerialNumber()}</td>
                            <td>${data.getModel()}</td>
                            <td>${data.getColour()}</td>
                            <td>${data.getYear()}</td>
                            <td>
                                <form method="POST" action="${pageContext.request.contextPath}/customer/add-to-cart">
                                    <input type="hidden" value="${data.getCarID()}" name="carID">
                                    <input type="hidden" value="${data.getSerialNumber()}" name="serialNumber">
                                    <input type="hidden" value="${data.getModel()}" name="colour">
                                    <input type="hidden" value="${data.getColour()}" name="colour">
                                    <input type="hidden" value="${data.getYear()}" name="year">
                                    <input type="submit" class="form-submit-btn" value="Add to cart">
                                </form>
                            </td>
                        </tr>
                    </c:forEach>

                </table>
            </div>        
        </div>
    </body>
</html>
