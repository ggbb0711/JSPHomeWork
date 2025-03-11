<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="scrollable-table">
    <table>
        <tr>
            <th>CarID</th>
            <th>Serial number</th>
            <th>Model</th>
            <th>Colour</th>
            <th>Year</th>
            <th></th>
        </tr>

        <c:forEach var="data" items="${availableCar}">
            <tr>
                <td>${data.getCarID()}</td>
                <td>${data.getSerialNumber()}</td>
                <td>${data.getModel()}</td>
                <td>${data.getColour()}</td>
                <td>${data.getYear()}</td>
                <td><form method="POST" action="${pageContext.request.contextPath}/customer/add-to-cart"></form></td>
            </tr>
        </c:forEach>

    </table>
</div>
