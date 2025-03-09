<%-- 
    Document   : SalesDashboard
    Created on : 20-Feb-2025, 12:26:12
    Author     : bluax
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.Customer"%>
<%@page import="model.SalePerson"%>
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
            <jsp:include page="/views/salePerson/components/header.jsp"></jsp:include>


        <%
            SalePerson sp = (SalePerson) session.getAttribute("saleperson");
            if(sp == null){
                request.setAttribute("error", "You must login");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }else{    
        %>
        
        <h3>Welcome back <%= sp.getName() %></h3>

        
        <h2>Customer Menu</h2>
        
        <h3>Create Customer</h3>
        <p><a href="createCust.jsp">click here to create Customer</a></p>
        
        
        <h3>Find Customer</h3>
        <form action="findCustomerServlet">
            <p><input type="text" value="<%= (request.getParameter("findname")!=null)? request.getParameter("findname"):"" %>"  
                      name="txtname" placeholder="enter name"/></p>
            <p><input type="submit" value="find"/></p>
        </form>
        <h4><% if(request.getAttribute("findCust")!=null) out.print(request.getAttribute("findCust")); %></h4>
        
        <%  
            ArrayList<Customer> list = (ArrayList<Customer>) session.getAttribute("customerList");
            if(list!=null && !list.isEmpty()){
        %>
        <table>
            <tr>
                <th>CustID</th>
                <th>CustName</th>
                <th>Phone</th>
                <th>Sex</th>
                <th>Address</th>
            </tr>
                
        <%
            for (Customer cs : list) {
        %>
        
            <tr>
                <td><%= cs.getCustID() %></td>
                <td><%= cs.getCustName() %></td>
                <td><%= cs.getPhone() %></td>
                <td><%= cs.getSex() %></td>
                <td><%= cs.getCustAddress() %></td>
            </tr>
               
                    
        
        <%
                }
        %>
        </table>
        <%
            }
        %>
        <h3>Update Customer</h3>        
        <p><a href="updateCustomerInfo.jsp">click here to update Customer info</a></p>
        
        
        <!-- Chu yeu de delete may cai minh tao chu chua hoan thien de xoa 1 du lieu da cho -->
        <h3>Delete Customer</h3>
        <p>Type ID:</p>
        <form action="deleteCustomerServlet">
            <input type="text" name="txtid" required=""/>
            <input type="submit" value="delete">
        </form>
        <%
            if(request.getAttribute("checkID")!= null){
                out.print(request.getAttribute("checkID"));
            }
            
            if(request.getAttribute("deleteCustomer")!= null){
                out.print(request.getAttribute("deleteCustomer"));
            }
        %>    
        
        <%
            }
        %>
        
        </body>
</html>
