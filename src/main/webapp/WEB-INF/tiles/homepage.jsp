<%--
  Created by IntelliJ IDEA.
  User: justlex
  Date: 1/20/16
  Time: 4:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<a href="<c:url value="/tours/allavaliabletours"/>">
    <img src="${pageContext.request.contextPath}/static/img/allTours.jpg" width="400" height="100">
</a>
<br/>

<a href="<c:url value="/tours/shoppingtours"/>">
    <img src="${pageContext.request.contextPath}/static/img/shoppings.jpg" width="133.5" height="100">
</a>

<a href="<c:url value="/tours/vacationtours"/>">
    <img src="${pageContext.request.contextPath}/static/img/vacations.jpg" width="133.5" height="100">
</a>

<a href="<c:url value="/tours/excursiontours"/>">
    <img src="${pageContext.request.contextPath}/static/img/excursions.jpg" width="133.5" height="100">
</a>

<br/>
<sec:authorize access="isAuthenticated()">
    <a href="<c:url value="/personalroom"/>">
        <img src="${pageContext.request.contextPath}/static/img/personalRoom.jpg" width="400" height="100">
    </a>
</sec:authorize>

<br/>
<sec:authorize access="hasRole('ROLE_ADMIN')">
    <a href="<c:url value="/dashboard"/>">
        <img src="${pageContext.request.contextPath}/static/img/dashboard.jpg" width="400" height="100">
    </a>
</sec:authorize>
