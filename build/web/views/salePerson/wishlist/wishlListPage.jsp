<%-- 
    Document   : wishListPage
    Created on : Mar 13, 2025, 9:17:19 AM
    Author     : NGHIA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Wishlist</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/style/reset.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/style/style.css">
    </head>
    <body>
        <div class="sticky-header">
            <jsp:include page="/views/salePerson/components/header.jsp"></jsp:include>
        </div>   
        
        <div class="page-container">
            <h1>CUSTOMER WISHLISTS</h1>
            <div>
                <table>
                    <tr>
                        <th>Id</th>
                        <th>CustID</th>
                        <th>Created at</th>
                        <th></th>
                    </tr>

                    <c:forEach var="data" items="${wishlists}">
                        <tr>
                            <td>${data.getId()}</td>
                            <td>${data.getCustid()}</td>
                            <td>${data.getCreatedAt()}</td>
                            <td>
                                <a href="${pageContext.request.contextPath}/sales-person/wishlistDetail?id=${data.getId()}">
                                    <button class="btn btn-primary">Details</button>
                                </a>
                            </td>
                        </tr>
                    </c:forEach>

                </table>
            </div>
        </div>
    </body>
</html>
