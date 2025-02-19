<!DOCTYPE html>

<%@page import="java.util.ArrayList"%>
<%@page import="model.Parts"%>


<div>
    <form action="parts">
        <input type="search" name="partName" id="partName" placeholder="Enter part name..." value="<%=request.getParameter("partName")!=null?request.getParameter("partName"):""%>">
        <input type="submit">
    </form>
    
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Purchase Price</th>
            <th>Retail Price</th>
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
                        <div>
                            <form action="parts" method="POST">
                                <input type="hidden" value="delete" name="action">
                                <input type="hidden" value="<%= list.get(i).getPartID()%>" name="id">
                                <input value="Delete" type="submit">
                            </form>
                            <a href="part-update">Update</a>
                        </div>
                    </td>
                </tr>
            <%}
        %>
    </table>

</div>