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
    <title>Edit email</title>
    <link rel="stylesheet" href="/resources/css/style.css" />
</head>
<body>

<section class="login-page">
    <h2>Zmiana adresu email. Krok 1/2.</h2>


    <%--@elvariable id="changeToken" type="changeToken"--%>
    <form:form modelAttribute="changeToken" method="post" action="/emailChange">
        <form:errors path="*" cssClass="errorblock" element="div" /><br>
        <div class="form-group">
            <form:input type="email" path="newEmail" placeholder="Nowy Email" />
        </div>
        <form:hidden path="email" />
        <div class="form-group form-group--buttons">
            <button class="btn" type="submit">Wyślij</button>
            <a href="/user/profil" class="btn btn--without-border">Anuluj</a>
        </div>
    </form:form>
</section>

<%@ include file="footer.jsp" %>

</body>
</html>