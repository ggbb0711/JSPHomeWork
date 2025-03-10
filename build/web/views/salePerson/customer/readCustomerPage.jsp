<%-- 
    Document   : readCustomerPage
    Created on : 10-Mar-2025, 09:29:47
    Author     : bluax
--%>

<%@page import="model.Customer"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
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
        
        <h3>Find Customer</h3>
        <form action="${pageContext.request.contextPath}/sales-person/readCustomers" method="get" accept-charset="utf-8">
            <p>Enter Customer's Name:</p>
            <p><input type="text" value="<%= (request.getAttribute("findname")!=null)? request.getAttribute("findname"):"" %>"  
                      name="txtname" placeholder="enter name"/></p>
            <p><input type="submit" value="find"/></p>
        </form>
        <h4><% if(request.getAttribute("findCust")!=null) out.print(request.getAttribute("findCust")); %></h4>
        
        <%  
            ArrayList<Customer> list = (ArrayList<Customer>) request.getAttribute("customerList");
            if(list!=null && !list.isEmpty()){
        %>
        <table>
            <tr>
                <th>Cust ID</th>
                <th>Cust Name</th>
                <th>Phone</th>
                <th>Sex</th>
                <th>Address</th>
            </tr>
                
        <%
            for (Customer cs : list) {
        %>
        
            <tr>
                <td><%= cs.getCustID()%></td>
                <td><%= cs.getCustName()%></td>
                <td><%= cs.getPhone() %></td>
                <td><%= cs.getSex() %></td>
                <td><%= cs.getCustAddress()%></td>
            </tr>

        <%
                }
        %>
        </table>
        <%
            }
        %>
    </body>
</html>
