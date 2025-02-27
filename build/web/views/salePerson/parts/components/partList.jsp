<!DOCTYPE html>

<%@page import="java.util.ArrayList"%>
<%@page import="model.Parts"%>
<%@page import="utils.constant.Routes"%>


<div>
    <form action="parts" class="form-input-container">
        <input class="form-control part-search-input" type="search" name="partName" id="partName" placeholder="Enter part name..." value="<%=request.getParameter("partName")!=null?request.getParameter("partName"):""%>">
        <input class="form-submit-btn" type="submit" value="Search">
    </form>
    
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Purchase Price</th>
            <th>Retail Price</th>
            <th></th>
        </tr>
        
        <%
            ArrayList<Parts> list = (ArrayList<Parts>) request.getAttribute("partList");
            for(int i=0;i<list.size();i++){%>
                <tr>
                    <td><%= list.get(i).getPartID()%></td>
                    <td><%= list.get(i).getPartName()%></td>
                    <td><%= list.get(i).getPurchasePrice()%></td>
                    <td><%= list.get(i).getRetailPrice()%></td>
                    <td>
                        <div style="display: flex; gap: 4px">
                            <a href="${pageContext.request.contextPath}/sales-person/part-update?partID=<%= list.get(i).getPartID()%>">
                                <button class="btn btn-primary">Edit</button>
                            </a>
                            <form action="${pageContext.request.contextPath}/sales-person/DeletePartServlet" method="POST">
                                <input type="hidden" value="delete" name="action">
                                <input type="hidden" value="<%= list.get(i).getPartID()%>" name="partID">
                                <input class="btn btn-danger" value="Delete" type="submit">
                            </form>
                            
                        </div>
                    </td>
                </tr>
            <%}
        %>
    </table>

</div>