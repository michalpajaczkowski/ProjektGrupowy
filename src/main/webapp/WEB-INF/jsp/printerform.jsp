<style>
    <%@include file="/WEB-INF/css/printerform.css" %>
</style>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Add new printer</title>
</head>
<body>
<div class="container">
    <form:form method="post" action="savePrinter" class="signUp">
    <form:hidden path="id"/>

    <div class="printerNewTitle">Add new printer to your company!</div>
    <br><br><br><br>
    <input class="modelName" placeholder="model name"/><br><br>
    <input class="cmyk" placeholder="CMYK" path="model" type="text" list = "c" /><br><br>
    <datalist id="c">
        <option value="true"></option>
        <option value="false"></option>
    </datalist>
    <input class="location" placeholder="printers location" path="localization"/><br><br>
    <input class="employeeName" placeholder="employee name" path="employees.id" type="text" name="employ"
           list="emp"/><br><br>
    <datalist id="emp">
        <c:forEach var="emp" items="${list}">
            <option value="${emp.id}" label="${emp.firstName} ${emp.lastName}"></option>
        </c:forEach>
    </datalist>

    <button type="submit" value="savePrinter" style="border:none;">
        <div class="addPrinterButton">Add new printer!</div>
        <br>
        </form:form>

</div>
</body>
</html>
