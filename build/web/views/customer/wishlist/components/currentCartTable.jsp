<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="scrollable-table">
    <table>
        <tr>
            <th>CarID</th>
            <th>Serial number</th>
            <th>Model</th>
            <th>Colour</th>
            <th>Year</th>
        </tr>

        <c:forEach var="data" items="${sessionScope.cartItems}">
            <tr>
                <td>${data.getCarID()}</td>
                <td>${data.getSerialNumber()}</td>
                <td>${data.getModel()}</td>
                <td>${data.getColour()}</td>
                <td>${data.getYear()}</td>
            </tr>
        </c:forEach>

    </table>
</div>
