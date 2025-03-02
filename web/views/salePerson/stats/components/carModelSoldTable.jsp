<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="scrollable-table">
    <table>
        <tr>
            <th>Total model sold</th>
            <th>CarID</th>
            <th>Serial number</th>
            <th>Model</th>
            <th>Colour</th>
            <th>Year</th>
        </tr>

        <c:forEach var="data" items="${carModelSoldDataList}">
            <tr>
                <td>${data.getCarSold()}</td>
                <td>${data.getCar().getCarID()}</td>
                <td>${data.getCar().getSerialNumber()}</td>
                <td>${data.getCar().getModel()}</td>
                <td>${data.getCar().getColour()}</td>
                <td>${data.getCar().getYear()}</td>
            </tr>
        </c:forEach>

    </table>
</div>

