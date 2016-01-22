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

<a class="font" href="<c:url value="/dashboard/addtour"/>">Add Tour</a>
<br/>
<a class="font" href="<c:url value="/dashboard/userslist"/>">List of current users</a>
<br/>
<a class="font" href="<c:url value="/dashboard/currentorders"/>">List of current orders</a>
