<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<jsp:include page="header.jsp"/>
<section class="form--steps">
    <div class="form--steps-instructions">
        <div class="form--steps-container">
            <h3>Ważne!</h3>
            <p data-step="1" class="active">
                Uzupełnij szczegóły dotyczące Twoich rzeczy. Dzięki temu będziemy
                wiedzieć komu najlepiej je przekazać.
            </p>
            <p data-step="2">
                Uzupełnij szczegóły dotyczące Twoich rzeczy. Dzięki temu będziemy
                wiedzieć komu najlepiej je przekazać.
            </p>
            <p data-step="3">
                Wybierz jedną, do
                której trafi Twoja przesyłka.
            </p>
            <p data-step="4">Podaj adres oraz termin odbioru rzeczy.</p>
        </div>
    </div>

<form:form action="add4" method="post" modelAttribute="donation">
    <div data-step="3">
        <h3>Wybierz organizacje, której chcesz pomóc:</h3>
        <form:checkboxes path="institution" items="${institutions}" itemLabel="name" itemValue="id"  />
    </div>
    <div class="form-group form-group--buttons">
        <a href="/donation/add2"> <button type="button" class="btn prev-step">Wstecz</button></a>
        <button type="submit" class="btn next-step">Dalej
        </button>
    </div>
</form:form>



<jsp:include page="footer.jsp"/>

