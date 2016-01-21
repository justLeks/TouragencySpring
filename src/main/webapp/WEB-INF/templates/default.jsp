<%--
  Created by IntelliJ IDEA.
  User: justlex
  Date: 1/20/16
  Time: 4:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<html>
<head>
    <link href="${pageContext.request.contextPath}/static/css/styles.css" rel="stylesheet" type="text/css"/>
    <title><tiles:insertAttribute name="title"/></title>
</head>
<body>
<div class="header">
    <tiles:insertAttribute name="header"/>
</div>
<br/>
<div class="body">
    <tiles:insertAttribute name="body"/>
</div>
<hr>
<div class="footer">
    <tiles:insertAttribute name="footer"/>
</div>
</body>

</html>

