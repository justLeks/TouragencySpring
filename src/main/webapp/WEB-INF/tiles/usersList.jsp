<%--
  Created by IntelliJ IDEA.
  User: justlex
  Date: 1/21/16
  Time: 3:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table class="flat-table flat-table-1" align="center">
    <tr>
        <td>Name</td>
        <td>Email</td>
        <td>Password</td>
        <td>Authority</td>
        <td>Enabled</td>
        <td>&ensp;&ensp;</td>
    </tr>
    <c:forEach items="${users}" var="user">
        <form method="post" action="<c:url value="/dashboard/userblocked"/>">
            <input type="hidden" name="email" value="${user.email}"/>
            <tr>
                <td>${user.username}</td>
                <td>${user.email}</td>
                <td>${user.password}</td>
                <td>${user.authority}</td>
                <td>${user.enabled}</td>
                <td><button class="myButtonBlue" type="submit">Block</button></td>
            </tr>
        </form>
    </c:forEach>
</table>