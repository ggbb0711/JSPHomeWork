<%-- 
    Document   : wishlListDetailPage
    Created on : Mar 13, 2025, 9:32:55 AM
    Author     : NGHIA
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Wishlist details</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/style/reset.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/style/style.css">
    </head>
    <body>
        <div class="sticky-header">
            <jsp:include page="/views/salePerson/components/header.jsp"></jsp:include>
        </div>  
        
        <div class="page-container">
        <c:choose>
            <c:when test="${wishlistDetail.isIsCompleted()}">
                <p>This wishlist has been completed</p>
            </c:when>
            <c:otherwise>
                <form method="POST" action="${pageContext.request.contextPath}/sales-person/wishlistDetail">
                    <h1>WISHLIST DETAILS</h1>
                    <table>
                        <tr>
                            <th>WishlistID</th>
                            <th>Created at</th>
                        </tr>
                        <tr>
                            <td>${wishlistDetail.getId()}</td>
                            <td>${wishlistDetail.getCreatedAt()}</td>
                        </tr>
                    </table>    
                    <h1>CUSTOMER DETAILS</h1>
                    <table>
                        <tr>
                            <th>CustomerID</th>
                            <th>Name</th>
                            <th>Phone</th>
                            <th>Sex</th>
                            <th>Address</th>
                        </tr>
                        <tr>
                            <td>${wishlistDetail.getCustomer().getCustID()}</td>
                            <td>${wishlistDetail.getCustomer().getCustName()}</td>
                            <td>${wishlistDetail.getCustomer().getPhone()}</td>
                            <td>${wishlistDetail.getCustomer().getSex()}</td>
                            <td>${wishlistDetail.getCustomer().getCustAddress()}</td>
                        </tr>
                    </table>
                    
                    <h1>WISHLIST DETAILS</h1>
                    <table>
                        <tr>
                            <th>CarID</th>
                            <th>Serialnumber</th>
                            <th>Model</th>
                            <th>Colour</th>
                            <th>Year</th>
                            <th>Price</th>
                        </tr>
                        <c:forEach var="data" items="${wishlistDetail.getDetails()}">
                            <tr>
                                <td>${data.getCarID()}</td>
                                <td>${data.getSerialNumber()}</td>
                                <td>${data.getModel()}</td>
                                <td>${data.getColour()}</td>
                                <td>${data.getYear()}</td>
                                <td>
                                    <input type="number" required="" min="0" name="revenue">
                                    <input type="hidden" name="carID" value="${data.getCarID()}" >
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                    <input type="hidden" name="custID" value="${wishlistDetail.getCustomer().getCustID()}">
                    <input type="hidden" name="wishlistID" value="${wishlistDetail.getId()}">
                    <input type="submit" value="Create invoices" class="form-submit-btn" style="margin-top: 8px">
                    <span class="form-error-input">${message}</span>
                </form>
                
            </c:otherwise>
        </c:choose>
            
        </div>
    </body>
</html>
