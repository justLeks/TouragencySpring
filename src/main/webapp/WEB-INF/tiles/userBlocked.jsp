<%--
  Created by IntelliJ IDEA.
  User: justlex
  Date: 1/21/16
  Time: 4:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

User ${blockedUser.username} was successfully blocked
<br/>
<a class="font" href="<c:url value="/dashboard/userslist"/>">Back to user's list</a>
