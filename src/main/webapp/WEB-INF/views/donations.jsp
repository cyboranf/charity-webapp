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
    <title>Donations</title>
    <link rel="stylesheet" href="/resources/css/style.css"/>
    <link rel="stylesheet" href="/resources/css/bootstrap.css"/>
</head>
<body>

<%@ include file="headerUser.jsp" %>

<section class="login-page" >

    <h2>Moje zbiórki</h2>
    <div>
        <table class="table font-large">
            <thead>
            <tr>
                <th>Liczba worków</th>
                <th>Kategorie</th>
                <th>Instytucja</th>
                <th>Data odbioru</th>
                <th>Odebrane</th>
                <th>Potwierdzenie odbioru</th>
                <td></td>
                <td></td>
            </tr>
            </thead>
            <tbody>
            <c:forEach items='${myDonations}' var="donation">
                <tr>
                    <td>${donation.quantity}</td>
                    <td>
                        <c:forEach items="${donation.categories}" var="category">
                            ${category.name}<br>
                        </c:forEach>
                    </td>
                    <td>${donation.institution.name}</td>
                    <td>${donation.pickUpDate}</td>
                    <td>
                        <c:out value="${donation.received == false ? 'NIE': 'TAK'}"/>
                    </td>
                    <td>${donation.confirmDate}</td>
                    <td><a class="btn btn-outline-primary btn--large" href="${pageContext.request.contextPath}/donationDetails/${donation.id}">Szczegóły</a></td>
                    <td>
                        <c:if test="${donation.received == false}">
                            <a class="btn btn-outline-primary btn--large" href="${pageContext.request.contextPath}/donation/confirmation/${donation.id}">Potwierdź odbiór</a>
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

</section>
<script src="../../resources/js/app.js"></script>
</body>
</html>