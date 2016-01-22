<%--
  Created by IntelliJ IDEA.
  User: justlex
  Date: 1/22/16
  Time: 1:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table class="flat-table flat-table-2" align="center">
    <tr>
        <td>Hotel</td>
        <td>Price</td>
        <td>Country</td>
        <td>Start Day</td>
        <td>End Day</td>
        <td>Food</td>
        <td>Hot</td>
        <td>Type</td>
        <td>Date</td>
        <td>Confirmed</td>
        <td>Paid</td>
    </tr>
    <c:forEach items="${orderInfo}" var="info">
        <tr>
            <td>${info.hotelClass}</td>
            <td>${info.finalPrice}</td>
            <td>${info.destCountry}</td>
            <td>${info.startDay}</td>
            <td>${info.endDay}</td>
            <td>${info.food}</td>
            <td>${info.hot}</td>
            <td>${info.tourType}</td>
            <td>${info.date}</td>
            <td>${info.confirmed}</td>
            <td>${info.paid}</td>
        </tr>
    </c:forEach>
</table>