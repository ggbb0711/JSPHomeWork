
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="scrollable-table">
    <table>
        <tr>
            <th>MechanicID</th>
            <th>Mechanic name</th>
            <th>Ticket done</th>
            <th>Average rate</th>
            <th>Total hours</th>
        </tr>

        <c:forEach var="data" items="${topMechanicData}">
            <tr>
                <td>${data.getMechanic().getMechanicID()}</td>
                <td>${data.getMechanic().getMechanicName()}</td>
                <td>${data.getTicketDone()}</td>
                <td>${data.getAverageRate()}</td>
                <td>${data.getTotalHours()}</td>
            </tr>
        </c:forEach>

    </table>
</div>
