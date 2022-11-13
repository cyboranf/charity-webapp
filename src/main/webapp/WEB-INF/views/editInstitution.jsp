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
    <title>Adit Institution</title>
    <link rel="stylesheet" href="/resources/css/style.css" />
</head>
<body>

<section class="login-page">
    <h2>Edycja instytucji</h2>

    <div>
        <%--@elvariable id="institution" type="institution"--%>
        <form:form modelAttribute="institution" method="get" action="/admin/institution/edit">
            <form:errors path="*" cssClass="errorblock" element="div" /><br>
            <div class="form-group">
                <form:textarea path="name" placeholder="Nazwa" />
            </div>
            <div class="form-group">
                <form:textarea path="description" placeholder="Opis" />
            </div>
            <form:hidden path="id"/>
            <div class="form-group form-group--buttons">
                <button class="btn" type="submit">Edytuj</button>
                <a href="/admin/institutions" class="btn btn--without-border">Anuluj</a>
            </div>
        </form:form>
    </div>

</section>
<script src="/resources/js/app.js"></script>
</body>
</html>