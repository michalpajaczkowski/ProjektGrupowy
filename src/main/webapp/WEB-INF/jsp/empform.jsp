<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="border" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    <%@include file="/WEB-INF/css/empform.css" %>
</style>
<html>
<head>
    <title>Add new employee</title>
</head>
<body>
<div class="container">
    <form:form method="post" action="save" class="signUp">
    <form:hidden path="id"/>
    <div class="employeeNewTitle">Add new employee to your company!</div>
    <br><br><br><br>
    <input class="firstName" placeholder="first name"/><br><br>
    <input class="lastName" placeholder="last name"/><br><br>
    <input class="adress" placeholder="adress"/><br><br>
    <input class="city" placeholder="city"/><br><br>
    <input class="email" placeholder="email"/><br><br>
    <input class="salary" placeholder="salary"/><br><br>
    <input class="age" placeholder="age"/><br><br>
    <input class="startJobDate" placeholder="job start date" type="Date"/><br><br>
    <input class="benefit" placeholder="have benefits" list="ben"/><br><br>
    <datalist id="ben">
        <option value="1" label="yes"></option>
        <option value="0" label="no"></option>
    </datalist>
    <br><br>

    <button type="submit" value="save" style="border:none;">
        <div class="addEmployeeButton">Add new employee!</div>
        <br>
        </form:form>

</div>
</body>
</html>