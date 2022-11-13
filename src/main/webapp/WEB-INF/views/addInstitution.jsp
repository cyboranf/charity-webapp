<%@ page contentType="text/html;charset=UTF-8" %>
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
    <title>Add Institution</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.css"/>
    <link rel="stylesheet" href="/resources/css/style.css" />

</head>
<body>

<%@ include file="headerAdmin.jsp" %>

<section class="login-page">
    <h2>Nowa instytucja</h2>

    <div>
        <%--@elvariable id="institution" type="institution"--%>
        <form:form modelAttribute="institution" method="post">
            <form:errors path="*" cssClass="errorblock" element="div" /><br>
            <div class="form-group">
                <form:textarea path="name" placeholder="Nazwa" />
            </div>
            <div class="form-group">
                <form:textarea path="description" placeholder="Opis" />
            </div>
            <div class="form-group form-group--buttons">
                <button class="btn" type="submit">Dodaj</button>
                <a href="/admin/institutions" class="btn btn--without-border">Anuluj</a>
            </div>
        </form:form>
    </div>

</section>
<script src="/resources/js/app.js"></script>
</body>
</html>