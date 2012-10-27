<!doctype html>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Simple CRUD Page</title>
</head>

<body>
    <div class="page-header">
        <h1>Simple CRUD Page</h1>
    </div>

    <div id="person-form">
        <form:form method="post" action="add" commandName="person" class="form-vertical">
            <form:label path="firstName">First Name</form:label>
            <form:input path="firstName"/>
            <form:label path="lastName">Last Name</form:label>
            <form:input path="lastName"/>
            <input type="submit" value="Add Person" class="btn"/>
        </form:form>
    </div>

    <div id="people-list">
        <c:if test="${!empty peopleList}">
            <h3>People</h3>
            <table class="table table-bordered table-striped">
                <thead>
                <tr>
                    <th>Name</th>
                    <th>&nbsp;</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${peopleList}" var="person">
                    <tr>
                        <td>${person.lastName}, ${person.firstName}</td>
                        <td>
                            <form action="delete/${person.id}" method="post">
                                <input type="submit" class="btn btn-danger btn-mini" value="Delete"/>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:if>
    </div>
</body>
</html>
