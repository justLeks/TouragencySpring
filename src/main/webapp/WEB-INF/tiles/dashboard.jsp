<%--
  Created by IntelliJ IDEA.
  User: justlex
  Date: 1/21/16
  Time: 7:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<a href="<c:url value="/dashboard/addtour"/>">
    <img src="${pageContext.request.contextPath}/static/img/addTour.jpg">
</a>
<br/>

<a href="<c:url value="/dashboard/userslist"/>">
    <img src="${pageContext.request.contextPath}/static/img/currentUsers.jpg">
</a>

<a href="<c:url value="/dashboard/currentorders"/>">
    <img src="${pageContext.request.contextPath}/static/img/currentOrders.jpg">
</a>
