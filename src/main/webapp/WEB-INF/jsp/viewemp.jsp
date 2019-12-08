<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    <%@include file="/WEB-INF/css/viewemp.css" %>
</style>


<div class="employeesListNewTitle">Employees list</div>
<br><br><br><br>


<div>
    <table cellpadding="0" cellspacing="1" border="0" table-layout auto; width: 100%>
        <thead>
        <tr>
            <th class="tbl-header">Id</th>
            <th class="tbl-header">Imię</th>
            <th class="tbl-header">Nazwisko</th>
            <th class="tbl-header">Wynagrodzenie</th>
            <th class="tbl-header">Adres</th>
            <th class="tbl-header">Miasto</th>
            <th class="tbl-header">Wiek</th>
            <th class="tbl-header">Od kiedy pracuje</th>
            <th class="tbl-header">Benefity</th>
            <th class="tbl-header">Action</th>
        </tr>
        </thead>
    </table>
</div>
<div>
    <table cellpadding="0" cellspacing="0" border="0">
        <tbody>
        <c:forEach var="emp" items="${list}">
            <tr>
                <td class="tbl-header">${emp.id}</td>
                <td class="tbl-header">${emp.lastName}</td>
                <td class="tbl-header">${emp.firstName}</td>
                <td class="tbl-header">${emp.salary}</td>
                <td class="tbl-header">${emp.address}</td>
                <td class="tbl-header">${emp.city}</td>
                <td class="tbl-header">${emp.age}</td>
                <td class="tbl-header">${emp.startJobDate}</td>
                <td class="tbl-header">${emp.benefit}</td>
                <td class="tbl-header">
                    <form:form method="post" action="delete">
                        <input type="hidden" id="id" name="id" value="${emp.id}"/>
                        <input type="submit" class="button1" name="Delete" value="delete"/>
                    </form:form>
                    <form:form method="post" action="edit">
                        <input type="hidden" id="id" name="id" value="${emp.id}"/>
                        <input type="submit" class="button1" name="Edit" value="edit"/>
                    </form:form>
                    <form:form method="post" action="show">
                        <input type="hidden" id="id" name="id" value="${emp.id}"/>
                        <input type="submit" class="button1" name="Show" value="show"/>
                    </form:form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

