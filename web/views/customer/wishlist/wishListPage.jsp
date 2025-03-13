<%-- 
    Document   : wishListPage
    Created on : Mar 11, 2025, 9:24:32 AM
    Author     : NGHIA
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Wishlist</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/style/reset.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/style/style.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200&icon_names=shopping_cart" />
    </head>
    <body>
        <div class="sticky-header">
            <jsp:include page="/views/customer/components/header.jsp"></jsp:include>
        </div>  
        <div class="page-container">
            <h1>CURRENT CART</h1>
            <c:choose>
                <c:when test="${not empty sessionScope.cartItems}">
                    <div>
                        <table>
                            <tr>
                                <th>CarID</th>
                                <th>Serial number</th>
                                <th>Model</th>
                                <th>Colour</th>
                                <th>Year</th>
                            </tr>

                            <c:forEach var="data" items="${sessionScope.cartItems}">
                                <tr>
                                    <td>${data.getCarID()}</td>
                                    <td>${data.getSerialNumber()}</td>
                                    <td>${data.getModel()}</td>
                                    <td>${data.getColour()}</td>
                                    <td>${data.getYear()}</td>
                                </tr>
                            </c:forEach>

                        </table>
                    </div>
                </c:when>
                <c:otherwise>
                    <p>There is no car in your cart right now</p>
                </c:otherwise>
            </c:choose>
            <c:if test="${not empty sessionScope.cartItems}">
                <form action="${pageContext.request.contextPath}/customer/cart" method="POST" style="margin-top: 4px">
                    <input class="form-submit-btn" type="submit" value="Create new cart">
                </form>
            </c:if>
            <span class="form-error-input">${requestScope.wishlistMsg}</span>
        </div>
        
    </body>
</html>
