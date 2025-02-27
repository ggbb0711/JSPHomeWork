
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="scrollable-table">
    <table>
        <tr>
            <th>PartID</th>
            <th>Number of used</th>
            <th>Total price</th>
            <th>PartName</th>
            <th>PurchasePrice</th>
            <th>RetailPrice</th>
        </tr>

        <c:forEach var="data" items="${partUsedData}">
            <tr>
                <td>${data.getPart().getPartID()}</td>
                <td>${data.getNumberUsed()}</td>
                <td>${data.getPrice()}</td>
                <td>${data.getPart().getPartName()}</td>
                <td>${data.getPart().getPurchasePrice()}</td>
                <td>${data.getPart().getRetailPrice()}</td>
            </tr>
        </c:forEach>

    </table>
</div>
