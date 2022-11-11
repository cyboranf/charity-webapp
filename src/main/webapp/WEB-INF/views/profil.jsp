<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>Document</title>
    <link rel="stylesheet" href="/resources/css/style.css" />
</head>
<body>

<%@ include file="headerUser.jsp" %>

<section class="login-page">
    <h2>Moje dane</h2>

    <%--@elvariable id="user" type="user"--%>
    <form:form modelAttribute="user" method="post">
        <div class="form-group">
            <span class="font-large">Email:  ${user.email}</span>
        </div>
        <div class="form-group">
            <span class="font-large">Imię:  ${user.firstName}</span>
        </div>
        <div class="form-group">
            <span class="font-large">Nazwisko:  ${user.lastName}</span>
        </div>
        <div class="form-group form-group--buttons">
            <a href="/user/edit/${user.id}" class="btn">Zmiana danych</a>
            <a href="/user/changePassword/${user.id}" class="btn">Zmiana hasła</a>
            <a href="/emailChange/${user.id}" class="btn">Zmiana email</a>
        </div>
    </form:form>
</section>
<script src="/resources/js/app.js"></script>
</body>
</html>