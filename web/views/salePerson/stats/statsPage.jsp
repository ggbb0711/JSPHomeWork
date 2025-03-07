<%-- 
    Document   : statPage
    Created on : Feb 27, 2025, 10:36:35 PM
    Author     : NGHIA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.time.Year"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Car Stats</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/style/reset.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/style/style.css">
    </head>
    <body>
        <div class="sticky-header">
            <jsp:include page="/views/salePerson/components/header.jsp"></jsp:include>
            <jsp:include page="./components/subHeader.jsp"></jsp:include>
        </div>   
        <div class="page-container">
            <div>
                <h1>BEST SELLING CAR MODEL</h1>
                <jsp:include page="./components/carModelSoldTable.jsp"></jsp:include>
            </div>
            <form method="GET" action="${pageContext.request.contextPath}/sales-person/stats" style="display:flex; gap: 8px;">
                <div>
                    <h1>CAR SOLD</h1>
                    <label for="carSoldByYear">By year:</label>
                    <input type="number" min="1900" max="2099" step="1" value="<%=request.getParameter("carSoldByYear")==null?Year.now().getValue():request.getParameter("carSoldByYear")%>" id="carSoldByYear" name="carSoldByYear" class="form-control" style="width: auto;margin-bottom: 8px"/>
                    <input type="submit" class="form-submit-btn" value="Search">
                    <jsp:include page="./components/carSoldTable.jsp"></jsp:include>
                </div>
                <div>
                    <h1>CAR REVENUE</h1>
                    <label for="carRevenueByYear">By year:</label>
                    <input type="number" min="1900" max="2099" step="1" value="<%=request.getParameter("carSoldByYear")==null?Year.now().getValue():request.getParameter("carRevenueByYear")%>" id="carRevenueByYear" name="carRevenueByYear" class="form-control" style="width: auto;margin-bottom: 8px"/>
                    <input type="submit" class="form-submit-btn" value="Search">
                    <jsp:include page="./components/carRevenueTable.jsp"></jsp:include>
                </div>
            </form>
        </div>
    </body>
</html>
