<%-- 
    Document   : updateCustomerPage
    Created on : 10-Mar-2025, 09:57:48
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
        
        <h3>Update Customer</h3>
        <form action="${pageContext.request.contextPath}/sales-person/updateCustomers" method="post" accept-charset="utf-8" >
            <p>Customer's ID:</p>
            <p><input type="text" name="txtid" required="" placeholder="enter id" ></p>
            <p>Customer's Name:</p>
            <p><input type="text" name="txtname" required="" placeholder="enter name" ></p>
            <p>Customer's Phone:</p>
            <p><input type="text" name="txtphone" required="" placeholder="enter phone" ></p>
            <p>Customer's Sex:</p>
            <p><input type=radio value="F" name="txtsex" checked="" >Female
                <input type="radio" value="M" name="txtsex">Male
            </p>
            <p>Customer's Address:</p>
            <p><textarea name="txtaddress" placeholder="enter address" required="" ></textarea></p>
            <p><input type="submit" value="Update"></p>
        </form>
        <% 
            if(request.getAttribute("updateStatus")!=null){
                out.print("<h4>" + request.getAttribute("updateStatus") + "</h4>");
            }
        %>
    </body>
</html>
