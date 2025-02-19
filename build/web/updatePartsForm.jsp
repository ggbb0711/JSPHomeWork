<%@page import="java.util.HashMap"%>

<%
    HashMap<String, String> formData = (HashMap<String, String>) request.getAttribute("formData");
    HashMap<String,String> updatingPart = (HashMap<String,String>) request.getAttribute("updating-part");

    HashMap<String,String> inputError = (HashMap<String,String>) request.getAttribute("validation-err");
    String nameErr = (inputError != null) ? inputError.get("partName") : null;
    String purchasePriceErr = (inputError != null) ? inputError.get("purchasePrice") : null;
    String retailPriceErr = (inputError != null) ? inputError.get("retailPrice") : null;

    String invalidDataErr = (String) request.getAttribute("invalid-data-exception");
%>

<div>
    <%
        if(updatingPart!=null){%>
        <div>
            
            <span>ID: <%=updatingPart.get("partID")%></span>
            <span>Name: <%=updatingPart.get("partName")%></span>
            <span>Purchase price: <%=updatingPart.get("purchasePrice")%></span>
            <span>Retail price: <%=updatingPart.get("retailPrice")%></span>
        </div>
    <%}
    %>
    <form action="parts" method="POST">
        <h1>Update part</h1>
        <input name="partID" id="partID" required="" type="hidden" value="<%=request.getParameter("partID")%>">
        <div>
            <label for="partName">Name:</label>
            <input name="partName" id="partName" value="<%= (formData != null && formData.get("partName") != null) ? formData.get("partName") : "" %>">
            <p><%=(nameErr!=null)?nameErr:""%></p>
        </div>
        <div>
            <label for="purchasePrice">Purchase price:</label>
            <input type="number" name="purchasePrice" id="purchasePrice" value="<%= (formData != null && formData.get("purchasePrice") != null) ? formData.get("purchasePrice") : "" %>">
            <p><%=(purchasePriceErr!=null)?purchasePriceErr:""%></p>
        </div>
        <div>
            <label for="retailPrice">Retail price:</label>
            <input type="number" name="retailPrice" id="retailPrice" value="<%= (formData != null && formData.get("retailPrice") != null) ? formData.get("retailPrice") : "" %>">
            <p><%=(retailPriceErr!=null)?retailPriceErr:""%></p>
        </div>
        <p><%=(invalidDataErr!=null)?invalidDataErr:""%></p>
        <input type="submit">
    </form>
</div>
