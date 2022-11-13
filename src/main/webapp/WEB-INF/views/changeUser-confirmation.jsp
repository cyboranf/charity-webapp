<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>Change password confirmation</title>
    <link rel="stylesheet" href="/resources/css/style.css" />
</head>
<body>
<header class="header--form-page">
    <nav class="container container--70">
        <ul class="nav--actions">
            <li class="logged-user">
                Witaj ${username}
                <ul class="dropdown">
                    <li><a href="/">Start</a></li>
                    <li><a href="/user/profil">Profil</a></li>
                    <li><a href="/donations">Moje zbiórki</a></li>
                    <li><a href="<c:out value='perform_logout'/>">Wyloguj</a></li>
                </ul>
            </li>
        </ul>

        <ul>
            <li><a href="${pageContext.request.contextPath}/" class="btn btn--without-border">Start</a></li>
            <li><a href="${pageContext.request.contextPath}/#steps" class="btn btn--without-border">O co chodzi?</a></li>
            <li><a href="${pageContext.request.contextPath}/#about-us" class="btn btn--without-border">O nas</a></li>
            <li><a href="${pageContext.request.contextPath}/#help" class="btn btn--without-border">Fundacje i organizacje</a></li>
            <li><a href="${pageContext.request.contextPath}form" class="btn btn--without-border">Przekaż dary</a></li>
            <li><a href="${pageContext.request.contextPath}/#contact" class="btn btn--without-border">Kontakt</a></li>
        </ul>
    </nav>

    <div class="slogan container container--90">
        <h2>
            Twoje dane zostały zmienione.
        </h2>
    </div>
</header>

<%@ include file="footer.jsp" %>

<script src="/resources/js/app.js"></script>
</body>
</html>