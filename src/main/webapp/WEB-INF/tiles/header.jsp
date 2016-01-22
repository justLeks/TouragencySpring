<%--
  Created by IntelliJ IDEA.
  User: justlex
  Date: 1/20/16
  Time: 4:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<a class="homepage" href=<c:url value="/"/>>Spring Touragency</a>

<%--<sec:authorize access="isAuthenticated()" var="loggedIn"/>--%>

<%--<c:if test="${loggedIn}">--%>
    <%--<sec:authentication property="principal.username"/>--%>
<%--</c:if>--%>

<sec:authorize  access="isAuthenticated()">
    <a class="login" href="<c:url value="/logout"/>">Log Out</a>
</sec:authorize>

<sec:authorize access="!isAuthenticated()">
    <a class="login" href=<c:url value="/login"/>>Log in</a>
</sec:authorize>