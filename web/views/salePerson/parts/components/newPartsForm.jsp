<%@page import="java.util.HashMap"%>
<%@page import="utils.constant.Routes"%>

<%
    HashMap<String, String> formData = (HashMap<String, String>) request.getAttribute("formData");

    HashMap<String,String> inputError = (HashMap<String,String>) request.getAttribute("validation-err");
    String partIDErr = (inputError != null) ? inputError.get("partID") : null;
    String nameErr = (inputError != null) ? inputError.get("partName") : null;
    String purchasePriceErr = (inputError != null) ? inputError.get("purchasePrice") : null;
    String retailPriceErr = (inputError != null) ? inputError.get("retailPrice") : null;

    String invalidDataErr = (String) request.getAttribute("invalid-data-exception");
%>

<div>
    <h1>Create new part</h1>
    <form class="form-container" action="${pageContext.request.contextPath}/sales-person/create" method="POST">
        <div class="form-input-container">
            <label for="partID">ID:</label>
            <input class="form-control" name="partID" id="partID" required="" type="number" value="<%= (formData != null && formData.get("partID") != null) ? formData.get("partID") : "" %>">
            <p class="form-error-input"><%=(partIDErr!=null)?partIDErr:""%></p>
        </div>
        <div class="form-input-container">
            <label for="partName">Name:</label>
            <input class="form-control" name="partName" id="partName" value="<%= (formData != null && formData.get("partName") != null) ? formData.get("partName") : "" %>">
            <p class="form-error-input"><%=(nameErr!=null)?nameErr:""%></p>
        </div>
        <div class="form-input-container">
            <label for="purchasePrice">Purchase price:</label>
            <input class="form-control" type="number" name="purchasePrice" id="purchasePrice" value="<%= (formData != null && formData.get("purchasePrice") != null) ? formData.get("purchasePrice") : "" %>">
            <p class="form-error-input"><%=(purchasePriceErr!=null)?purchasePriceErr:""%></p>
        </div>
        <div class="form-input-container">
            <label for="retailPrice">Retail price:</label>
            <input class="form-control" type="number" name="retailPrice" id="retailPrice" value="<%= (formData != null && formData.get("retailPrice") != null) ? formData.get("retailPrice") : "" %>">
            <p class="form-error-input"><%=(retailPriceErr!=null)?retailPriceErr:""%></p>
        </div>
        <p class="form-error-input"><%=(invalidDataErr!=null)?invalidDataErr:""%></p>
        <input class="form-submit-btn" type="submit">
    </form>
</div>



