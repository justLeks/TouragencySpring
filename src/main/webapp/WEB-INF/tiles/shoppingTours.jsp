<%--
  Created by IntelliJ IDEA.
  User: justlex
  Date: 1/21/16
  Time: 6:12 AM
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
        <td></td>
    </tr>
    <c:forEach items="${shoppingTours}" var="tour">
        <form method="post" action="<c:url value="/tours/buytour"/>">
            <input type="hidden" name="idTour" value="${tour.idTour}">
            <input type="hidden" name="price" value="${tour.price}">
            <tr>
                <td>${tour.hotelClass}</td>
                <td>${tour.price}</td>
                <td>${tour.destCountry}</td>
                <td>${tour.startDay}</td>
                <td>${tour.endDay}</td>
                <td>${tour.food}</td>
                <td>${tour.hot}</td>
                <td>${tour.tourType}</td>
                <td>
                    <button class="myButtonRed" type="submit">Buy!</button>
                </td>
            </tr>
        </form>
    </c:forEach>
</table>