<%--
  Created by IntelliJ IDEA.
  User: justlex
  Date: 1/20/16
  Time: 4:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<a href="<c:url value="/allavaliabletours"/>">
    <img src="${pageContext.request.contextPath}/static/img/allTours.jpg">
</a>
<br/>

<a href="<c:url value="/shoppingtours"/>">
    <img src="${pageContext.request.contextPath}/static/img/shoppings.jpg">
</a>

<a href="<c:url value="/vacationtours"/>">
    <img src="${pageContext.request.contextPath}/static/img/vacations.jpg">
</a>

<a href="<c:url value="/excursiontours"/>">
    <img src="${pageContext.request.contextPath}/static/img/excursions.jpg">
</a>

<br/>
<sec:authorize access="hasRole('ROLE_ADMIN')">
    <a href="<c:url value="/dashboard"/>">
        <img src="${pageContext.request.contextPath}/static/img/dashboard.jpg">
    </a>
</sec:authorize>
