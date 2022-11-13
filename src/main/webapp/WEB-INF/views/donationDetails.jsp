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
    <title>Document</title>
    <link rel="stylesheet" href="/resources/css/style.css"/>
</head>
<body>

<section id="donation" class="form--steps">
    <div class="form--steps-instructions">
    </div>

    <div class="form--steps-container">

        <%--@elvariable id="donation" type="donation"--%>
        <form:form method="post" modelAttribute="donation">
            <div data-step="1" class="active">
                <h3>Podsumowanie Twojej darowizny</h3>

                <div class="summary">
                    <div class="form-section">
                        <h4>Oddajesz:</h4>
                        <ul>
                            <li>
                                <span class="icon icon-bag"></span>
                                <span class="summary--text"
                                >Liczba worków: ${donation.quantity}</span
                                >

                            </li>
                            <li >
                                <span class="summary--text">Kategoria:&nbsp</span>
                                <span >
                                      <c:forEach items="${donation.categories}" var="category">
                                          ${category.name}<br>
                                      </c:forEach>
                                </span>
                            </li>
                            <li>
                                <span class="icon icon-hand"></span>
                                <span  class="summary--text"
                                >${donation.institution.name}</span
                                >
                            </li>
                        </ul>
                    </div>

                    <div class="form-section form-section--columns">
                        <div class="form-section--column">
                            <h4>Adres odbioru:</h4>
                            <ul>
                                <li >${donation.street}</li>
                                <li >${donation.city}</li>
                                <li >${donation.zipCode}</li>
                            </ul>
                        </div>

                        <div class="form-section--column">
                            <h4>Termin odbioru:</h4>
                            <ul>
                                <li >${donation.pickUpDate}</li>
                                <li >${donation.pickUpTime}</li>
                                <li >${donation.pickUpComment}</li>
                            </ul>
                        </div>
                    </div>
                </div>

                <div class="form-group form-group--buttons">
                    <a href="/donations" class="btn">Powrót</a>
                </div>
            </div>
        </form:form>
    </div>
</section>

<script src="/resources/js/app.js"></script>
</body>
</html>