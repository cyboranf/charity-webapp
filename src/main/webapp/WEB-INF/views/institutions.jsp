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
    <title>Institutions</title>
    <link rel="stylesheet" href="/resources/css/style.css"/>
    <link rel="stylesheet" href="/resources/css/bootstrap.css"/>
</head>
<body>

<%@ include file="headerAdmin.jsp" %>

<section class="login-page" >
    <h2>Instytucje</h2>
    <div>
        <table class="table font-large">
            <thead>
            <tr>
                <th>Nazwa</th>
                <th>Opis</th>
                <td></td>
                <td></td>
            </tr>
            </thead>
            <tbody>
            <c:forEach items='${institutions}' var="institution">
                <tr>
                    <td>${institution.name}</td>
                    <td>${institution.description}</td>
                    <td><a class="btn btn-outline-primary btn--large" href="${pageContext.request.contextPath}/admin/institution/edit/${institution.id}">Edytuj</a></td>
                    <td><a class="btn btn-outline-danger btn--large" href="${pageContext.request.contextPath}/admin/institution/del/${institution.id}">Usuń</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div class="row">
            <div class="col-3 pl-5">
                <form action="/admin/institution/add">
                    <button class="btn btn-outline-success btn--large">Dodaj</button>
                </form>
            </div>
        </div>
    </div>

</section>
<script src="/resources/js/app.js"></script>
</body>
</html>