<%--
  Created by IntelliJ IDEA.
  User: justlex
  Date: 1/22/16
  Time: 5:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table class="flat-table flat-table-3" align="center">
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
        <form method="post" action="<c:url value="/personalroom/orderedtours/paid"/>">
            <input type="hidden" name="idOrder" value="${info.idOrder}">
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
                <c:choose>
                    <c:when test="${info.confirmed == false}">
                        <td>Waiting for confirmation</td>
                        <td>Not confirmed yet</td>
                    </c:when>
                    <c:otherwise>
                        <td>Confirmed!</td>
                        <c:choose>
                            <c:when test="${info.paid == false}">
                                <td>
                                    <button class="myButtonGrey" type="submit">Pay!</button>
                                </td>
                            </c:when>
                            <c:otherwise>
                                <td>Paid!</td>
                            </c:otherwise>
                        </c:choose>
                    </c:otherwise>
                </c:choose>
            </tr>
        </form>
    </c:forEach>
</table>