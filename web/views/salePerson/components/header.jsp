<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<header class="header">
    <div class="header-navs">
        <a class="header-nav" href="${pageContext.request.contextPath}/sales-person/stats">REPORTS</a>
        <a class="header-nav" href="${pageContext.request.contextPath}/sales-person/parts">PARTS</a>
        <a class="header-nav" href="${pageContext.request.contextPath}/sales-person/customers">CUSTOMERS</a>
        <a class="header-nav" href="${pageContext.request.contextPath}/sales-person/cars">CARS</a>
        <a class="header-nav" href="${pageContext.request.contextPath}/sales-person/serviceTicket">SERVICE TICKETS</a>
        
    </div>
    
        <c:set var="sp" scope="session" value="${sessionScope.saleperson}" />
        
    <div class="header-user-info">
        <p>Hello ${sp.name}, <a class="header-nav" href="${pageContext.request.contextPath}/logout/sales-person">LOGOUT</a></p>
    </div>
</header>