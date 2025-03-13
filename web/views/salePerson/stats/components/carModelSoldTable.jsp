<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="scrollable-table">
    <table>
        <tr>
            <th>Total model sold</th>
            <th>Model</th>
        </tr>

        <c:forEach var="data" items="${carModelSoldDataList}">
            <tr>
                <td>${data.getCarSold()}</td>
                <td>${data.getCar().getModel()}</td>
            </tr>
        </c:forEach>

    </table>
</div>

