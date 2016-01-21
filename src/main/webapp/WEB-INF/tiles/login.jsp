<%--
  Created by IntelliJ IDEA.
  User: justlex
  Date: 1/21/16
  Time: 1:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h3>Login with Username and Password</h3>
<form name='f' action='${pageContext.request.contextPath}/login' method='POST'>
    <table>
        <tr>
            <td>User:</td>
            <td><input type='text' name='username' value=''></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type='password' name='password'/></td>
        </tr>
        <tr>
            <td></td>
            <td colspan='2'><input name="submit" type="submit" value="Login"/></td>
        </tr>
        <input name="_csrf" type="hidden" value="982d7ddb-3b5b-4480-8a39-ffae2f3dd875"/>
    </table>
</form>
<a href="<c:url value="/signup"/>">Create Account</a>