<style>
    <%@include file="/WEB-INF/css/phoneform.css" %>
</style>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Add new phone</title>
</head>
<body>
<div class="container">
    <form:form method="post" action="savePhone" class="signUp">
    <form:hidden path="employees"/>
    <div class="phoneNewTitle">Add new phone to your company!</div>
    <br><br><br><br>

    <input class="brandName" placeholder="brand name"/><br><br>
    <input class="modelName" placeholder="model name"/><br><br>
    <input class="employeeName" placeholder="users name" path="employees.id" type="text" name="employ"
           list="emp"/><br><br>

    <datalist id="emp">
        <c:forEach var="emp" items="${list}">
            <option value="${emp.id}" label="${emp.firstName} ${emp.lastName}"></option>
        </c:forEach>
    </datalist>

    <button type="submit" value="savePhone" style="border:none;">
        <div class="addPhoneButton">Add new phone!</div>
        <br>
        </form:form>
</div>
</body>
</html>
