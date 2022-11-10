<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>Admin</title>
    <link rel="stylesheet" href="/resources/css/style.css"/>
    <link rel="stylesheet" href="/resources/css/bootstrap.css"/>
</head>
<body>

<%@ include file="headerAdmin.jsp" %>

<section class="login-page" >

    <h2>Panel Admina</h2>
    <div>
        <table class="table font-large">
            <thead>
            <tr>
                <th>Imię</th>
                <th>Nazwisko</th>
                <th>Email</th>
                <th>Uprawnienia</th>
                <th>Dostęp</th>
                <td></td>
                <td></td>
                <td></td>
            </tr>
            </thead>
            <tbody>
            <c:forEach items='${users}' var="user">
                <tr>
                    <td>${user.firstName}</td>
                    <td>${user.lastName}</td>
                    <td>${user.email}</td>
                    <td>${user.authority.authority}</td>
                    <td>
                        <c:out value="${user.access == false ? 'NIE': 'TAK'}"/>
                    </td>
                    <td><a class="btn btn-outline-primary btn--large" href="${pageContext.request.contextPath}/admin/userAccess/${user.id}">Zmień dostęp</a></td>
                    <td><a class="btn btn-outline-primary btn--large" href="${pageContext.request.contextPath}/admin/userAuthority/${user.id}">Zmień rolę</a></td>
                    <td><a class="btn btn-outline-danger btn--large" href="${pageContext.request.contextPath}/admin/userDelete/${user.id}">Usuń</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

</section>
<script src="/resources/js/app.js"></script>
</body>
</html>