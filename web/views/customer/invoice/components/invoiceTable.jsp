<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="scrollable-table">
    <table>
        <tr>
            <th>CarID</th>
            <th>Serial number</th>
            <th>Model</th>
            <th>Colour</th>
            <th>Year</th>
            <th>Purchase date</th>
            <th>Money spent</th>
        </tr>

        <c:forEach var="data" items="${customerInvoices}">
            <tr>
                <td>${data.getCar().getCarID()}</td>
                <td>${data.getCar().getSerialNumber()}</td>
                <td>${data.getCar().getModel()}</td>
                <td>${data.getCar().getColour()}</td>
                <td>${data.getCar().getYear()}</td>
                <td>${data.getInvoiceDate()}</td>
                <td>${data.getRevenue()}</td>
            </tr>
        </c:forEach>

    </table>
</div>
