<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="header.jsp"%>
<section class="login-page">
    <h2>Zaloguj się</h2>
    <c:if test="${not empty param.logout}">
        <div class="logout" role="alert">
            Wylogowano poprawnie!
        </div>
    </c:if>
    <div class="errorLogin">
        <c:if test="${not empty param.error}">Błędne dane logowania</c:if>
    </div>
    <form:form method="post">
        <div class="form-group">
            <input type="text" name="username" placeholder="Email"/>
        </div>
        <div class="form-group">
            <input type="password" name="password" placeholder="Hasło"/>
        </div>

        <div class="form-group form-group--buttons">
            <a href="/" class="btn" type="submit">Zaloguj się</a>
            <a href="/register" class="btn btn--without-border">Załóż konto</a>
            <a href="/password" class="btn btn--without-border">Nie pamiętam hasła</a>
        </div>
    </form:form>
</section>

<%--<%@ include file="footer.jsp" %>--%>

</body>
</html>