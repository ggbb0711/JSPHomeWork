<%@page import="java.util.HashMap"%>
<%@page import="utils.constant.Routes"%>

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
    <h1>Update part</h1>
    <%
        if(updatingPart!=null){%>
        <div>
            
            <span>ID: <%=updatingPart.get("partID")%> |</span>
            <span>Name: <%=updatingPart.get("partName")%> |</span>
            <span>Purchase price: <%=updatingPart.get("purchasePrice")%> |</span>
            <span>Retail price: <%=updatingPart.get("retailPrice")%> |</span>
        </div>
    <%}
    %>

    <form class="form-container" action="${pageContext.request.contextPath}${Routes.UPDATE_PARTS}?partId=<%=request.getParameter("partID")%>" method="POST">
        <input name="partID" id="partID" type="hidden" value="<%=request.getParameter("partID")%>">
        <div class="form-input-container">
            <label for="partName">Name:</label>
            <input class="form-control" name="partName" id="partName" value="<%= (formData != null && formData.get("partName") != null) ? formData.get("partName") : "" %>" required>
            <p class="form-error-input"><%=(nameErr!=null)?nameErr:""%></p>
        </div>
        <div class="form-input-container">
            <label for="purchasePrice">Purchase price:</label>
            <input class="form-control" type="number" name="purchasePrice" id="purchasePrice" value="<%= (formData != null && formData.get("purchasePrice") != null) ? formData.get("purchasePrice") : "" %>" required>
            <p class="form-error-input"><%=(purchasePriceErr!=null)?purchasePriceErr:""%></p>
        </div>
        <div class="form-input-container">
            <label for="retailPrice">Retail price:</label>
            <input class="form-control" type="number" name="retailPrice" id="retailPrice" value="<%= (formData != null && formData.get("retailPrice") != null) ? formData.get("retailPrice") : "" %>" required>
            <p class="form-error-input"><%=(retailPriceErr!=null)?retailPriceErr:""%></p>
        </div>
        <p class="form-error-input"><%=(invalidDataErr!=null)?invalidDataErr:""%></p>
        
        <input name="updating-partId" id="updating-partId" type="hidden" value="<%=updatingPart.get("partID")%>">
        <input name="updating-partName" id="updating-partName" type="hidden" value="<%=updatingPart.get("partName")%>">
        <input name="updating-purchasePrice" id="updating-purchasePrice" type="hidden" value="<%=updatingPart.get("purchasePrice")%>">
        <input name="updating-retailPrice" id="updating-retailPrice" type="hidden" value="<%=updatingPart.get("retailPrice")%>">
        
        <input class="form-submit-btn" type="submit" value="Update">
    </form>
</div>
