<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>NoDelete</title>
    <link rel="stylesheet" href="/resources/css/style.css" />
</head>
<body>
<header class="header--form-page">
    <br>
    <nav class="container container--70">
        <ul>
            <li><a href="/" class="btn btn--without-border active">Start</a></li>
            <li><a href="/#steps" class="btn btn--without-border">O co chodzi?</a></li>
            <li><a href="/#about-us" class="btn btn--without-border">O nas</a></li>
            <li><a href="/#help" class="btn btn--without-border">Fundacje i organizacje</a></li>
            <li><a href="/#contact" class="btn btn--without-border">Kontakt</a></li>
        </ul>
    </nav>

    <div class="slogan container container--90">
        <h2>
            Twoje konto zostało zablokowane.
            Skontaktuj się z administratorem.
        </h2>
        <br>
    </div>
</header>

<%@ include file="footer.jsp" %>

<script src="resources/js/app.js"></script>
</body>
</html>