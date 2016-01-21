<%--
  Created by IntelliJ IDEA.
  User: justlex
  Date: 1/21/16
  Time: 6:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table class="flat-table flat-table-2">
    <tr>
        <td>ID</td>
        <td>Hotel Class</td>
        <td>Price</td>
        <td>Destination Country</td>
        <td>Start Day</td>
        <td>End Day</td>
        <td>Food</td>
        <td>Hot</td>
        <td>Tour Type</td>
    </tr>
    <c:forEach items="${shoppingTours}" var="tour">
        <tr>
            <td>${tour.idTour}</td>
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