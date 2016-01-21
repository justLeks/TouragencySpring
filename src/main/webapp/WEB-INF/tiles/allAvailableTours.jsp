<%--
  Created by IntelliJ IDEA.
  User: justlex
  Date: 1/20/16
  Time: 4:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table class="flat-table flat-table-2">
    <tr>
        <td>Hotel</td>
        <td>Price</td>
        <td>Country</td>
        <td>Start Day</td>
        <td>End Day</td>
        <td>Food</td>
        <td>Hot</td>
        <td>Type</td>
    </tr>
    <c:forEach items="${tours}" var="tour">
        <tr>
            <td>${tour.hotelClass}</td>
            <td>${tour.price}</td>
            <td>${tour.destCountry}</td>
            <td>${tour.startDay}</td>
            <td>${tour.endDay}</td>
            <td>${tour.food}</td>
            <td>${tour.hot}</td>
            <td>${tour.tourType}</td>
        </tr>
    </c:forEach>
</table>