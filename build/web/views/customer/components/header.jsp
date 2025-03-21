

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<header class="header">
    <div class="header-navs">
        <a class="header-nav" href="${pageContext.request.contextPath}/customer">AVAILABLE CARS</a>
        <a class="header-nav" href="${pageContext.request.contextPath}/customer/invoice">INVOICES</a>
        <a class="header-nav" href="${pageContext.request.contextPath}/customer/viewTickets">TICKETS</a>
        <a class="header-nav" href="${pageContext.request.contextPath}/customer/viewProfile">PROFILE</a>
    </div>
    <div class="header-user-info">
        <a class="shopping-cart-container" href="${pageContext.request.contextPath}/customer/cart">
            <c:if test="${sessionScope.cartItems.size()>0}">
                <div class="shopping-cart-notification">${sessionScope.cartItems.size()}</div>
            </c:if>
            <span class="material-symbols-outlined">
                shopping_cart
            </span>
        </a>
        <p>Hello ${sessionScope.customer.getCustName()}, <a class="header-nav" href="${pageContext.request.contextPath}">LOGOUT</a></p>
    </div>
</header>