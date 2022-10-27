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

    <div class="form--steps-container">
        <div class="form--steps-counter">Krok <span>1</span>/4</div>

        <form:form action="/donation/add" method="post" modelAttribute="categories">
            <div data-step="1" class="active">
                <h3>Zaznacz co chcesz oddać:</h3>

                <div class="form-group form-group--checkbox">
                    <label>
                        <input
                                type="checkbox"
                                name="categories"
                                value="${categories[0].id}"

                        />
                        <span class="checkbox"></span>
                        <span class="description"
                        >${categories[0].name}</span
                        >
                    </label>
                </div>

                <div class="form-group form-group--checkbox">
                    <label>
                        <input
                                type="checkbox"
                                name="categories"
                                value="${categories[1].id}"
                        />
                        <span class="checkbox"></span>
                        <span class="description">${categories[1].name}</span>
                    </label>
                </div>

                <div class="form-group form-group--checkbox">
                    <label>
                        <input type="checkbox" name="categories" value="${categories[2].id}"/>
                        <span class="checkbox"></span>
                        <span class="description">${categories[2].name}</span>
                    </label>
                </div>

                <div class="form-group form-group--checkbox">
                    <label>
                        <input type="checkbox" name="categories" value="${categories[3].id}"/>
                        <span class="checkbox"></span>
                        <span class="description">${categories[3].name}</span>
                    </label>
                </div>

                <div class="form-group form-group--checkbox">
                    <label>
                        <input type="checkbox" name="categories" value="${categories[4].id}"/>
                        <span class="checkbox"></span>
                        <span class="description">${categories[4].name}</span>
                    </label>
                </div>

                <div class="form-group form-group--buttons">
                    <button type="submit" class="btn next-step">Dalej</button>
                </div>
            </div>


        </form:form>
    </div>
</section>

<jsp:include page="footer.jsp"/>