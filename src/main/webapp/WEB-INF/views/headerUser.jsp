<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>Charitas</title>

    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
</head>
<body>

<header class="help">
    <nav class="container container--70">
        <ul class="nav--actions">
            <li class="logged-user">
                <h3>Witaj ${firstName}</h3>
                <ul class="dropdown">
                    <li><a href="/">Start</a></li>
                    <li><a href="/user/profil">Profil</a></li>
                    <li><a href="/donations">Moje zbiórki</a></li>
                    <li><a href="<c:out value='perform_logout'/>">Wyloguj</a></li>
                </ul>
            </li>
        </ul>
    </nav>
</header>