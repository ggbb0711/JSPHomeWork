<%-- 
    Document   : deleteCustomerPage
    Created on : 10-Mar-2025, 12:05:48
    Author     : bluax
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/style/reset.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/style/style.css">
    </head>
    <body>
        <div class="sticky-header">
            <jsp:include page="/views/salePerson/components/header.jsp"></jsp:include>
            <jsp:include page="./components/subHeader.jsp"></jsp:include>
        </div>
        
        <h3>Delete Customer</h3>
        <p>Type ID:</p>
        <form action="${pageContext.request.contextPath}/sales-person/deleteCustomers" method="post">
            <input type="text" name="txtid" required=""/>
            <input type="submit" value="delete">
        </form>
   
        <%
            if(request.getAttribute("checkID")!= null){
                out.print("<h4>" + request.getAttribute("checkID") + "</h4>");
            }
            
            if(request.getAttribute("deleteCustomer")!= null){
                out.print("<h4>" + request.getAttribute("deleteCustomer") + "</h4>");
            }
        %>
    </body>
</html>
