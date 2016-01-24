<%--
  Created by IntelliJ IDEA.
  User: justlex
  Date: 1/20/16
  Time: 8:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h3>Fill the tour's parameters</h3>
<form:form method="post" action="${pageContext.request.contextPath}/dashboard/createtour" commandName="tour">
    <form:input path="idTour" type="hidden" name="idTour"/>
    <table align="center">
        <tr>
            <td>Price:</td>
            <td>
                <form:input path="price" name="price"/>
                <br/>
                <form:errors path="price" cssClass="error"/>
            </td>
        </tr>
        <tr>
            <td>Destination Country:</td>
            <td>
                <form:input path="destCountry" name="destCountry"/>
                <br/>
                <form:errors path="destCountry" cssClass="error"/>
            </td>
        </tr>
        <tr>
            <td>Start Day:</td>
            <td>
                <form:input path="startDay" name="startDay"/>
                <br/>
                <form:errors path="startDay" cssClass="error"/>
            </td>
        </tr>
        <tr>
            <td>End Day:</td>
            <td>
                <form:input path="endDay" name="endDay"/>
                <br/>
                <form:errors path="endDay" cssClass="error"/>
            </td>
        </tr>
        <tr>
            <td>Food:</td>
            <td>
                <form:select path="food" name="food">
                    <option value="AI">AI</option>
                    <option value="OD">OD</option>
                    <option value="OS">OS</option>
                    <option value="DS">DS</option>
                    <option value="NN">NN</option>
                </form:select>
            </td>
        </tr>
        <tr>
            <td>Hotel class:</td>
            <td>
                <form:select path="hotelClass" name="hotelClass">
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                    <option value="5">5</option>
                </form:select>
            </td>
        </tr>
        <tr>
            <td>Hot:</td>
            <td>
                <form:select path="hot" name="hot">
                    <option value="true">yes</option>
                    <option value="false">not</option>
                </form:select>
            </td>
        </tr>
        <tr>
            <td>Tour Type:</td>
            <td>
                <form:select path="tourType" name="tourType">
                    <option value="Vacation">Vacation</option>
                    <option value="Shopping">Shopping</option>
                    <option value="Excursion">Excursion</option>
                </form:select>
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <input name="save" value="Add Tour" type="submit"/>
            </td>
        </tr>
    </table>
</form:form>