<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="border" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    <%@include file="/WEB-INF/css/carform.css" %>
</style>
<html>
<head>
    <title>Add new car</title>
</head>
<body>
<div class="container">
    <form:form method="post" action="saveCar" class="signUp">
    <form:hidden path="employees"/>
    <div class="carNewTitle">Add new car to your company!</div>
    <br><br><br><br>
    <input class="brandName" placeholder="brand name"/><br><br>
    <input class="modelName" placeholder="model name"/><br><br>
    <input class="registrationDate" placeholder="registration date" type="Date"/><br><br>
    <input class="employeeName" placeholder="drivers name" path="employees.id" type="text" name="employ"
           list="emp"/><br><br>

    <datalist id="emp">
        <c:forEach var="emp" items="${list}">
            <option value="${emp.id}" label="${emp.firstName} ${emp.lastName}"></option>
        </c:forEach>
    </datalist>

    <button type="submit" value="saveCar" style="border:none;">
        <div class="addCarButton">Add new car!</div>
        <br>
        </form:form>

</div>
</body>
</html>
