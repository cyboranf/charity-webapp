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
    <title>Edit User</title>
    <link rel="stylesheet" href="/resources/css/style.css" />
</head>
<body>

<section class="login-page">
    <h2>Edycja danych</h2>

    <%--@elvariable id="user" type="user"--%>
    <form:form modelAttribute="user" method="get" action="/user/edit">
        <form:errors path="*" cssClass="errorblock" element="div" /><br>
        <div class="form-group">
            <form:hidden path="email"  />
        </div>
        <div class="form-group">
            <form:input path="firstName" placeholder="Imię" />
        </div>
        <div class="form-group">
            <form:input path="lastName" placeholder="Nazwisko" />
        </div>
        <form:hidden path="id"/>
        <form:hidden path="password"/>
        <div class="form-group form-group--buttons">
            <button class="btn" type="submit">Edytuj</button>
            <a href="/user/profil" class="btn btn--without-border">Anuluj</a>
        </div>
    </form:form>
</section>

<%@ include file="footer.jsp" %>

</body>
</html>