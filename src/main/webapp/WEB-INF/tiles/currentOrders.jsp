<%--
  Created by IntelliJ IDEA.
  User: justlex
  Date: 1/22/16
  Time: 4:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table class="flat-table flat-table-3" align="center">
    <tr>
        <td>Name</td>
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
        <td></td>
    </tr>
    <c:forEach items="${currentOrders}" var="order">
        <form method="post" action="<c:url value="/dashboard/currentorders/confirmed"/>">
            <input type="hidden" name="idOrder" value="${order.idOrder}">
            <tr>
                <td>${order.username}</td>
                <td>${order.hotelClass}</td>
                <td>${order.finalPrice}</td>
                <td>${order.destCountry}</td>
                <td>${order.startDay}</td>
                <td>${order.endDay}</td>
                <td>${order.food}</td>
                <td>${order.hot}</td>
                <td>${order.tourType}</td>
                <td>${order.date}</td>
                <c:choose>
                    <c:when test="${order.confirmed == false}">
                        <td>
                            <button class="myButtonGrey" type="submit">Confirm</button>
                        </td>
                        <td>Not confirmed</td>
                    </c:when>
                    <c:otherwise>
                        <td>Confirmed</td>
                        <c:choose>
                            <c:when test="${order.paid == false}">
                                <td>Not paid</td>
                            </c:when>
                            <c:otherwise>
                                <td>Paid</td>
                            </c:otherwise>
                        </c:choose>
                    </c:otherwise>
                </c:choose>
            </tr>
        </form>
    </c:forEach>
</table>