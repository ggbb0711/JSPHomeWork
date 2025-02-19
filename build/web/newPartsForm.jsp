<%@page import="java.util.HashMap"%>

<%
    HashMap<String, String> formData = (HashMap<String, String>) request.getAttribute("formData");

    HashMap<String,String> inputError = (HashMap<String,String>) request.getAttribute("validation-err");
    String partIDErr = (inputError != null) ? inputError.get("partID") : null;
    String nameErr = (inputError != null) ? inputError.get("partName") : null;
    String purchasePriceErr = (inputError != null) ? inputError.get("purchasePrice") : null;
    String retailPriceErr = (inputError != null) ? inputError.get("retailPrice") : null;

    String invalidDataErr = (String) request.getAttribute("invalid-data-exception");
%>

<form action="parts" method="POST">
    <h1>Create new part</h1>
    <div>
        <label for="partID">ID:</label>
        <input name="partID" id="partID" required="" type="number" value="<%= (formData != null && formData.get("partID") != null) ? formData.get("partID") : "" %>">
        <p><%=(partIDErr!=null)?partIDErr:""%></p>
    </div>
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