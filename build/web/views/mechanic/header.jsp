<%-- 
    Document   : header
    Created on : Mar 17, 2025, 1:56:58 PM
    Author     : USER
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="allcontain">
    <div class="header">
        <ul class="socialicon">
            <li><a href="#"><i class="fa fa-facebook"></i></a></li>
            <li><a href="#"><i class="fa fa-twitter"></i></a></li>
            <li><a href="#"><i class="fa fa-google-plus"></i></a></li>
            <li><a href="#"><i class="fa fa-pinterest"></i></a></li>
        </ul>
        <ul class="givusacall">
            <li>Give us a call : +66666666 </li>
        </ul>
        <ul class="logreg">
            <li><a href="#">Login </a> </li>
            <li><a href="#"><span class="register">Register</span></a></li>
        </ul>
    </div>
    <!-- Navbar Up -->
    <nav class="topnavbar navbar-default topnav">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed toggle-costume" data-toggle="collapse" data-target="#upmenu" aria-expanded="false">
                    <span class="sr-only"> Toggle navigaion</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand logo" href="#"><img src="image/logo1.png" alt="logo"></a>
            </div>	 
        </div>
        <div class="collapse navbar-collapse" id="upmenu">
            <ul class="nav navbar-nav" id="navbarontop">
                <li class="active"><a href="${pageContext.request.contextPath}/customer">HOME</a> </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle"	data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">CATEGORIES <span class="caret"></span></a>
                    <ul class="dropdown-menu dropdowncostume">
                        <li><a href="#">Sport</a></li>
                        <li><a href="#">Old</a></li>
                        <li><a href="#">New</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">DEALERS <span class="caret"></span></a>
                    <ul class="dropdown-menu dropdowncostume">
                        <li><a href="#">1</a></li>
                        <li><a href="#">2</a></li>
                        <li><a href="3">3</a></li>
                    </ul>
                </li>
                <c:if test="${sessionScope.customer != null}">

                    <li>
                        <a href="${pageContext.request.contextPath}/customer/invoice">My Invoices</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/customer/viewTickets">My Tickets</a>
                    </li>

                </c:if>
                <c:if test="${sessionScope.customer == null}">
                    <li>
                        <a href="login">Login</a>
                    </li>
                </c:if>

                <c:if test="${sessionScope.customer != null}">
                    <li class="dropdown user-dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                            Hello ${sessionScope.customer.custName} <span class="caret"></span>
                        </a>
                        <ul class="dropdown-menu dropdowncostume user-menu">
                            <li><a href="viewProfile">View Profile</a></li>
                            <li><a href="logout">Logout</a></li>
                        </ul>
                    </li>
                </c:if>

            </ul>
        </div>
    </nav>
</div>
