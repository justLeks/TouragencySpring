<%--
  Created by IntelliJ IDEA.
  User: justlex
  Date: 1/20/16
  Time: 10:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h3>Create a New Account</h3>
<h5 class="error"><c:out value="${userExists}"/></h5>
<form:form method="post" action="${pageContext.request.contextPath}/createuser" commandName="user">
    <table align="center">
        <tr>
            <td>Name:</td>
            <td>
                <form:input path="username" name="username"/>
                <br/>
                <form:errors path="username" cssClass="error"/>
            </td>
        </tr>
        <tr>
            <td>Email:</td>
            <td>
                <form:input path="email" name="email"/>
                <br/>
                <form:errors path="email" cssClass="error"/>
            </td>
        </tr>
        <tr>
            <td>Password:</td>
            <td>
                <form:input path="password" name="password" type="password"/>
                <br/>
                <form:errors path="password" cssClass="error"/>
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <input name="save" value="Create account" type="submit"/>
            </td>
        </tr>
    </table>
</form:form>