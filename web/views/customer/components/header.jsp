

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<header class="header">
    <div class="header-navs">
        <a class="header-nav" href="">PROFILE</a>
        <a class="header-nav" href="${pageContext.request.contextPath}/customer/invoice">INVOICES</a>
    </div>
    <div class="header-user-info">
        <p>Hello user, <a class="header-nav" href="#">LOGOUT</a></p>
    </div>
</header>